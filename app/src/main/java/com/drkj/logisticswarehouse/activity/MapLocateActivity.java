package com.drkj.logisticswarehouse.activity;

import android.app.Dialog;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.LogoPosition;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.IndoorRouteResult;
import com.baidu.mapapi.search.route.MassTransitRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.drkj.logisticswarehouse.BaseActivity;
import com.drkj.logisticswarehouse.R;
import com.drkj.logisticswarehouse.adapter.RouteLineAdapter;
import com.drkj.logisticswarehouse.bean.OrderBean;
import com.drkj.logisticswarehouse.util.DrivingRouteOverlay;

import java.util.ArrayList;
import java.util.List;

public class MapLocateActivity extends BaseActivity implements View.OnClickListener, SensorEventListener, OnGetRoutePlanResultListener, BaiduMap.OnMarkerClickListener {

    private MapView mMapView;

    private BaiduMap mBaiduMap;
    private LocationClient mLocationClient = null;
    private BDLocationListener myListener = null;
    private boolean isFirst = true;
    private List<String> address = new ArrayList<>();
    private static final int accuracyCircleFillColor = 0xAAFFFF88;
    private static final int accuracyCircleStrokeColor = 0xAA00FF00;
    private SensorManager mSensorManager;
    private Double lastX = 0.0;
    private int mCurrentDirection = 0;
    private float mCurrentAccracy;
    private double mCurrentLat = 0.0;
    private double mCurrentLon = 0.0;
    RoutePlanSearch mRoutePlanSearch = null;
    boolean hasShownDialogue = false;
    private List<OrderBean> orderBeanList = new ArrayList<>();
    Marker[] markers = new Marker[10];
    //当前正在派送的订单序号
    private int currentOrder=0;
    DrivingRouteOverlay overlay;
    int[] markerIcon = new int[]{R.drawable.marker_one,
            R.drawable.marker_two,
            R.drawable.marker_three,
            R.drawable.marker_four,
            R.drawable.marker_five,
            R.drawable.marker_six,
            R.drawable.marker_seven,
            R.drawable.marker_eight,
            R.drawable.marker_nine,
            R.drawable.marker_ten,
            R.drawable.marker_eleven,
            R.drawable.marker_twelve,
            R.drawable.marker_thirteen,
            R.drawable.marker_fourteen,
            R.drawable.marker_fifteen,
            R.drawable.marker_sixteen,
            R.drawable.marker_seventeen,
            R.drawable.marker_eighteen,
            R.drawable.marker_nineteen,
            R.drawable.marker_twenty,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        initView();
        initEvent();
        address.add("四川大学");
        address.add("成都大学");
        address.add("成都理工大学");
//        address.add("西南名族大学");
        address.add("电子科技大学");
        address.add("西南交通大学");
        address.add("西南财经大学");
        address.add("西南石油大学");
        address.add("成都中医药大学");
        for (int i=0;i<address.size();i++){
            OrderBean bean = new OrderBean();
            bean.setAddress(address.get(i));
            bean.setSerialNumber(i+1);
            bean.setCity("成都");
            orderBeanList.add(bean);
        }
        serachAddress(orderBeanList);
    }

    private void initView() {
        mMapView = (MapView) findViewById(R.id.mapview);

        mMapView.setLogoPosition(LogoPosition.logoPostionRightTop);

        mBaiduMap = mMapView.getMap();
        //普通地图
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        //卫星地图
//        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
        //空白地图, 基础地图瓦片将不会被渲染。在地图类型中设置为NONE，将不会使用流量下载基础地图瓦片图层。使用场景：与瓦片图层一起使用，节省流量，提升自定义瓦片图下载速度。
//        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NONE);
        //开启交通图
        mBaiduMap.setTrafficEnabled(true);
        //设置可改变地图位置
        mBaiduMap.setMyLocationEnabled(true);
        //开启热力图
//        mBaiduMap.setBaiduHeatMapEnabled(true);

        mBaiduMap.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL,true,null,accuracyCircleFillColor,accuracyCircleStrokeColor));
        mBaiduMap.setOnMarkerClickListener(this);
    }

    private void initEvent() {
        mSensorManager =(SensorManager) getSystemService(SENSOR_SERVICE);//获取传感器管理服务
        mLocationClient = new LocationClient(getApplicationContext());
        myListener = new MyLocationListener();
        mLocationClient.registerLocationListener(myListener);
        initLocation();
        mLocationClient.start();
        mRoutePlanSearch = RoutePlanSearch.newInstance();
        mRoutePlanSearch.setOnGetRoutePlanResultListener(this);
        overlay = new DrivingRouteOverlay(mBaiduMap);
    }
    private void serachAddress(final List<OrderBean> addresss) {

        GeoCoder geoCoder = GeoCoder.newInstance();
        for (int i=0;i<addresss.size();i++){
            final int finalI = i;
            geoCoder.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {
            @Override
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
                if (geoCodeResult == null || geoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    Toast.makeText(MapLocateActivity.this, "抱歉，未能找到结果", Toast.LENGTH_LONG)
                            .show();
                    return;
                }
                addresss.get(finalI).setLatitude(geoCodeResult.getLocation().latitude);
                addresss.get(finalI).setLongitude(geoCodeResult.getLocation().longitude);

//                mBaiduMap.clear();
                markers[finalI]= (Marker) mBaiduMap.addOverlay(new MarkerOptions().position(geoCodeResult.getLocation())
                        .icon(BitmapDescriptorFactory
                                .fromResource(markerIcon[finalI])).zIndex(finalI));
//                mBaiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(geoCodeResult
//                        .getLocation()));
            }

            @Override
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {

            }
        });
            geoCoder.geocode(new GeoCodeOption().city(addresss.get(i).getCity()).address(addresss.get(i).getAddress()));
        }
    }
    @Override
    public void onClick(View view) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
        //为系统的方向传感器注册监听器
        mSensorManager.registerListener( this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //取消注册传感器监听
        mSensorManager.unregisterListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
        mLocationClient.unRegisterLocationListener(myListener);
        mLocationClient.stop();
    }

    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);

        //可选，默认gcj02，设置返回的定位结果坐标系
        option.setCoorType("bd09ll");

        //可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setScanSpan(1000);

        //可选，设置是否需要地址信息，默认不需要
        option.setIsNeedAddress(true);

        //可选，默认false,设置是否使用gps
        option.setOpenGps(true);

        //可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
        option.setLocationNotify(true);

        //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationDescribe(true);

        //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIsNeedLocationPoiList(true);

        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.setIgnoreKillProcess(true);

        //可选，默认false，设置是否需要过滤GPS仿真结果，默认需要
        option.setEnableSimulateGps(false);

        mLocationClient.setLocOption(option);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        double x = sensorEvent.values[SensorManager.DATA_X];
        if (Math.abs(x - lastX) > 1.0) {
            mCurrentDirection = (int) x;
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(mCurrentAccracy)
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(mCurrentDirection).latitude(mCurrentLat)
                    .longitude(mCurrentLon).build();
            mBaiduMap.setMyLocationData(locData);
        }
        lastX = x;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onGetWalkingRouteResult(WalkingRouteResult walkingRouteResult) {

    }

    @Override
    public void onGetTransitRouteResult(TransitRouteResult transitRouteResult) {

    }

    @Override
    public void onGetMassTransitRouteResult(MassTransitRouteResult massTransitRouteResult) {

    }

    @Override
    public void onGetDrivingRouteResult(final DrivingRouteResult result) {
        if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
            Toast.makeText(MapLocateActivity.this, "抱歉，未找到结果", Toast.LENGTH_SHORT).show();
        }
        if (result.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
            // 起终点或途经点地址有岐义，通过以下接口获取建议查询信息
            // result.getSuggestAddrInfo()
            return;
        }
        if (result.error == SearchResult.ERRORNO.NO_ERROR) {

            if (result.getRouteLines().size() >= 1) {


//                mBaiduMap.setOnMarkerClickListener(overlay);
                overlay.setData(result.getRouteLines().get(0));
                overlay.addToMap();
                overlay.zoomToSpan();

//                if (!hasShownDialogue) {
//                    MyTransitDlg myTransitDlg = new MyTransitDlg(MapLocateActivity.this,
//                            result.getRouteLines(),
//                            RouteLineAdapter.Type.DRIVING_ROUTE);
//                    myTransitDlg.setOnDismissListener(new DialogInterface.OnDismissListener() {
//                        @Override
//                        public void onDismiss(DialogInterface dialog) {
//                            hasShownDialogue = false;
//                        }
//                    });
//                    myTransitDlg.setOnItemInDlgClickLinster(new OnItemInDlgClickListener() {
//                        public void onItemClick(int position) {
//                            DrivingRouteOverlay overlay = new DrivingRouteOverlay(mBaiduMap);
//                            mBaiduMap.setOnMarkerClickListener(overlay);
//                            overlay.setData(result.getRouteLines().get(position));
//                            overlay.addToMap();
//                            overlay.zoomToSpan();
//                        }
//
//                    });
//                    myTransitDlg.show();
//                    hasShownDialogue = true;
//                }
//            } else if (result.getRouteLines().size() == 1) {
//                DrivingRouteOverlay overlay = new DrivingRouteOverlay(mBaiduMap);
//                mBaiduMap.setOnMarkerClickListener(overlay);
//                overlay.setData(result.getRouteLines().get(0));
//                overlay.addToMap();
//                overlay.zoomToSpan();
            } else {
                Log.d("route result", "结果数<0");
                return;
            }

        }
    }

    @Override
    public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {

    }

    @Override
    public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        int i = marker.getZIndex();
//        DrivingRouteOverlay overlay = new DrivingRouteOverlay(mBaiduMap);
        OrderDetailDialog dialog = new OrderDetailDialog(this,orderBeanList.get(i));
        dialog.show();
        if (currentOrder==0&&i!=0||currentOrder!=0&&i!=currentOrder)return true;
        overlay.removeFromMap();
        currentOrder++;
        if (i<orderBeanList.size()){
            if (i>0){
                markers[i-1].remove();
            }
            Toast.makeText(this,"这里是："+orderBeanList.get(i).getAddress(),Toast.LENGTH_SHORT).show();

            LatLng start = new LatLng(mCurrentLat,mCurrentLon);
            LatLng terminal= marker.getPosition();
            PlanNode stNode = PlanNode.withLocation(start);
            PlanNode enNode = PlanNode.withLocation(terminal);
            mRoutePlanSearch.drivingSearch(new DrivingRoutePlanOption().from(stNode).to(enNode));
        }
        return true;
    }

    class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            // map view 销毁后不在处理新接收的位置
            //30.557638,104.074271
            if (bdLocation == null || mMapView == null) {
                return;
            }
            mCurrentAccracy = bdLocation.getRadius();
            mCurrentLat = bdLocation.getLatitude();
            mCurrentLon = bdLocation.getLongitude();
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(bdLocation.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(mCurrentDirection).latitude(bdLocation.getLatitude())
                    .longitude(bdLocation.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);
            if (isFirst){
                LatLng ll = new LatLng(bdLocation.getLatitude(),
                        bdLocation.getLongitude());
                isFirst = false;
                MapStatus mapStatus = new MapStatus.Builder().target(ll).zoom(18).build();
                MapStatusUpdate u = MapStatusUpdateFactory.newMapStatus(mapStatus);
                mBaiduMap.animateMapStatus(u);
            }
        }
    }


    class OrderDetailDialog extends Dialog{
        private OrderBean orderBean;
        private TextView orderSerialNumber;
        private TextView orderAddress;
        public OrderDetailDialog(Context context,OrderBean orderBean){
            this(context, 0);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            this.orderBean = orderBean;
        }

        public OrderDetailDialog(@NonNull Context context, @StyleRes int themeResId) {
            super(context, themeResId);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_orderdetails_dialog);
            orderSerialNumber = (TextView) findViewById(R.id.order_shopName);
            orderAddress = (TextView) findViewById(R.id.order_address);
            orderSerialNumber.setText(orderBean.getSerialNumber()+"");
            orderAddress.setText(orderBean.getAddress());
        }
    }

    // 响应DLg中的List item 点击
    interface OnItemInDlgClickListener {
        void onItemClick(int position);
    }

    // 供路线选择的Dialog
    class MyTransitDlg extends Dialog {

        private List<? extends RouteLine> mtransitRouteLines;
        private ListView transitRouteList;
        private RouteLineAdapter mTransitAdapter;

        OnItemInDlgClickListener onItemInDlgClickListener;

        public MyTransitDlg(Context context, int theme) {
            super(context, theme);
        }

        public MyTransitDlg(Context context, List<? extends RouteLine> transitRouteLines, RouteLineAdapter.Type
                type) {
            this(context, 0);
            mtransitRouteLines = transitRouteLines;
            mTransitAdapter = new RouteLineAdapter(context, mtransitRouteLines, type);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }

        @Override
        public void setOnDismissListener(OnDismissListener listener) {
            super.setOnDismissListener(listener);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_transit_dialog);

            transitRouteList = (ListView) findViewById(R.id.transitList);
            transitRouteList.setAdapter(mTransitAdapter);

            transitRouteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    onItemInDlgClickListener.onItemClick(position);
                    dismiss();
                    hasShownDialogue = false;
                }
            });
        }

        public void setOnItemInDlgClickLinster(OnItemInDlgClickListener itemListener) {
            onItemInDlgClickListener = itemListener;
        }

    }
}
