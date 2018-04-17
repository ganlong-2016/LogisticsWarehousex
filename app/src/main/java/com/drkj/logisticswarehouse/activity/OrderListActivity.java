package com.drkj.logisticswarehouse.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.navisdk.adapter.BNCommonSettingParam;
import com.baidu.navisdk.adapter.BNRoutePlanNode;
import com.baidu.navisdk.adapter.BNaviSettingManager;
import com.baidu.navisdk.adapter.BaiduNaviManager;
import com.drkj.logisticswarehouse.BaseActivity;
import com.drkj.logisticswarehouse.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.baidu.navisdk.adapter.PackageUtil.getSdcardDir;

public class OrderListActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static final String[] orders = new String[]{
            "滨河路二段368",
            "高新区益州大道599号",
            "高新区天府大道中段 500号",
            "成都大学",
            "四川大学",
            "航天城上城"
    };
    private ListView orderList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logistics_list);
        initView();
        initDirs();
        initNavi();
    }

    private void initView() {
        orderList = (ListView) findViewById(R.id.order_list);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,orders);
        orderList.setAdapter(adapter);
        orderList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        serachAddress(orders[position]);

    }

    private void serachAddress(String address) {
        GeoCoder geoCoder = GeoCoder.newInstance();
        geoCoder.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {
            @Override
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
                if (geoCodeResult == null || geoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    Toast.makeText(OrderListActivity.this, "抱歉，未能找到结果", Toast.LENGTH_LONG)
                            .show();
                    return;
                }
                //30.558185  104.074910
                String strInfo = String.format("纬度：%f 经度：%f",
                        geoCodeResult.getLocation().latitude, geoCodeResult.getLocation().longitude);
                Toast.makeText(OrderListActivity.this, strInfo, Toast.LENGTH_LONG).show();
                if (BaiduNaviManager.isNaviInited()) {
                    routeplanToNavi(geoCodeResult.getLocation().latitude, geoCodeResult.getLocation().longitude);
                }
            }

            @Override
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {

            }
        });
        geoCoder.geocode(new GeoCodeOption().city("成都").address(address));
    }

    String authinfo = null;

    private boolean hasInitSuccess = false;

    private String mSDCardPath = null;
    private static final String APP_FOLDER_NAME = "LogisticsWarehouse";
    private boolean initDirs() {
        mSDCardPath = getSdcardDir();
        if (mSDCardPath == null) {
            return false;
        }
        File f = new File(mSDCardPath, APP_FOLDER_NAME);
        if (!f.exists()) {
            try {
                f.mkdir();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
    private void initNavi() {

        BaiduNaviManager.getInstance().init(this, mSDCardPath, APP_FOLDER_NAME, new BaiduNaviManager.NaviInitListener() {
            @Override
            public void onAuthResult(int status, String msg) {
                if (0 == status) {
                    authinfo = "key校验成功!";
                } else {
                    authinfo = "key校验失败, " + msg;
                }
                OrderListActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        Toast.makeText(OrderListActivity.this, authinfo, Toast.LENGTH_LONG).show();
                    }
                });
            }

            public void initSuccess() {
                Toast.makeText(OrderListActivity.this, "百度导航引擎初始化成功", Toast.LENGTH_SHORT).show();
                hasInitSuccess = true;
                initSetting();
            }

            public void initStart() {
                Toast.makeText(OrderListActivity.this, "百度导航引擎初始化开始", Toast.LENGTH_SHORT).show();
            }

            public void initFailed() {
                Toast.makeText(OrderListActivity.this, "百度导航引擎初始化失败", Toast.LENGTH_SHORT).show();
            }

        }, null, ttsHandler, ttsPlayStateListener);

    }

    private void initSetting() {
         BNaviSettingManager.setDayNightMode(BNaviSettingManager.DayNightMode.DAY_NIGHT_MODE_AUTO);
        BNaviSettingManager
                .setShowTotalRoadConditionBar(BNaviSettingManager.PreViewRoadCondition.ROAD_CONDITION_BAR_SHOW_ON);
        BNaviSettingManager.setVoiceMode(BNaviSettingManager.VoiceMode.Veteran);
//         BNaviSettingManager.setPowerSaveMode(BNaviSettingManager.PowerSaveMode.DISABLE_MODE);
        BNaviSettingManager.setRealRoadCondition(BNaviSettingManager.RealRoadCondition.NAVI_ITS_ON);
        BNaviSettingManager.setIsAutoQuitWhenArrived(true);
        Bundle bundle = new Bundle();
        // 必须设置APPID，否则会静音
        bundle.putString(BNCommonSettingParam.TTS_APP_ID, "10245186");
        BNaviSettingManager.setNaviSdkParam(bundle);
    }

    /**
     * 内部TTS播报状态回传handler
     */
    private Handler ttsHandler = new Handler() {
        public void handleMessage(Message msg) {
            int type = msg.what;
            switch (type) {
                case BaiduNaviManager.TTSPlayMsgType.PLAY_START_MSG: {
                     showToastMsg("Handler : TTS play start");
                    break;
                }
                case BaiduNaviManager.TTSPlayMsgType.PLAY_END_MSG: {
                     showToastMsg("Handler : TTS play end");
                    break;
                }
                default:
                    break;
            }
        }
    };

    /**
     * 内部TTS播报状态回调接口
     */
    private BaiduNaviManager.TTSPlayStateListener ttsPlayStateListener = new BaiduNaviManager.TTSPlayStateListener() {

        @Override
        public void playEnd() {
             showToastMsg("TTSPlayStateListener : TTS play end");
        }

        @Override
        public void playStart() {
             showToastMsg("TTSPlayStateListener : TTS play start");
        }
    };

    public void showToastMsg(final String msg) {
        OrderListActivity.this.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                Toast.makeText(OrderListActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void routeplanToNavi(double latitude,double longitude) {

        if (!hasInitSuccess) {
            Toast.makeText(OrderListActivity.this, "还未初始化!", Toast.LENGTH_SHORT).show();
        }

        BNRoutePlanNode sNode = new BNRoutePlanNode(104.074271,30.557638,"出发地", null);
        BNRoutePlanNode eNode = new BNRoutePlanNode(longitude,latitude, "目的地", null);
        if (sNode != null && eNode != null) {
            List<BNRoutePlanNode> list = new ArrayList<>();
            list.add(sNode);
            list.add(eNode);

            // 开发者可以使用旧的算路接口，也可以使用新的算路接口,可以接收诱导信息等
             BaiduNaviManager.getInstance().launchNavigator(this, list, BaiduNaviManager.RoutePlanPreference.ROUTE_PLAN_MOD_RECOMMEND, true, new DemoRoutePlanListener(sNode));
//            BaiduNaviManager.getInstance().launchNavigator(this, list, BaiduNaviManager.RoutePlanPreference.ROUTE_PLAN_MOD_RECOMMEND, true, new DemoRoutePlanListener(sNode),eventListerner);
        }
    }
//    BaiduNaviManager.NavEventListener eventListerner = new BaiduNaviManager.NavEventListener() {
//
//        @Override
//        public void onCommonEventCall(int what, int arg1, int arg2, Bundle bundle) {
//            BNEventHandler.getInstance().handleNaviEvent(what, arg1, arg2, bundle);
//        }
//    };

    public static final String ROUTE_PLAN_NODE = "routePlanNode";
    public class DemoRoutePlanListener implements BaiduNaviManager.RoutePlanListener {

        private BNRoutePlanNode mBNRoutePlanNode = null;

        public DemoRoutePlanListener(BNRoutePlanNode node) {
            mBNRoutePlanNode = node;
        }

        @Override
        public void onJumpToNavigator() {
            /*
             * 设置途径点以及resetEndNode会回调该接口
             */

            for (Activity ac : activities) {

                if (ac.getClass().getName().endsWith("GuideActivity")) {

                    return;
                }
            }
            Intent intent = new Intent(OrderListActivity.this, GuideActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(ROUTE_PLAN_NODE, mBNRoutePlanNode);
            intent.putExtras(bundle);
            startActivity(intent);

        }

        @Override
        public void onRoutePlanFailed() {
            Toast.makeText(OrderListActivity.this, "算路失败", Toast.LENGTH_SHORT).show();
        }
    }
}
