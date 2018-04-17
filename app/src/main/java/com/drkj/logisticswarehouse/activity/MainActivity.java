package com.drkj.logisticswarehouse.activity;

import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.drkj.logisticswarehouse.BaseActivity;
import com.drkj.logisticswarehouse.BaseApplication;
import com.drkj.logisticswarehouse.Constant.Constant;
import com.drkj.logisticswarehouse.R;
import com.drkj.logisticswarehouse.adapter.QRCodeDetailListAdapter;
import com.drkj.logisticswarehouse.bean.ResultBean;
import com.drkj.logisticswarehouse.bean.ResultDeliverBean;
import com.drkj.logisticswarehouse.bean.ResultOrderDetailBean;
import com.drkj.logisticswarehouse.fragment.CompleteOrderFragment;
import com.drkj.logisticswarehouse.fragment.MapLocateFragment;
import com.drkj.logisticswarehouse.fragment.OrderListFragment;
import com.drkj.logisticswarehouse.net.NetClient;
import com.drkj.logisticswarehouse.util.CommonUtil;
import com.drkj.logisticswarehouse.util.SupportMultipleScreensUtil;
import com.google.gson.Gson;
import com.google.zxing.Result;
import com.vondear.rxtools.RxActivityTool;
import com.vondear.rxtools.activity.ActivityScanerCode;
import com.vondear.rxtools.interfaces.OnRxScanerListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    private String TAG = "MainActivity111";
    private static final int BAIDU_REQUEST_PERMISSIONS = 0;
    private RelativeLayout waitforship;
    private ImageView waitforshipImage;
    private TextView waitforshipText;
    private View waitforshipView;
    private RelativeLayout shipping;
    private ImageView shippingImage;
    private TextView shippingText;
    private View shippingView;
    private RelativeLayout complete;
    private ImageView completeImage;
    private TextView completeText;
    private View completeView;
    private int RESULT_OK = 0xA1;
    private MapLocateFragment shippingFragment;
    private OrderListFragment waitFragment;
    private CompleteOrderFragment completeFragment;
    private ImageView scanQRcodeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View rootView = findViewById(android.R.id.content);
        SupportMultipleScreensUtil.init(getApplication());
        SupportMultipleScreensUtil.scale(rootView);

        initviews();
        initEvents();
        selet(1);

        LocationManager locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Toast.makeText(this, "未打开位置开关，可能导致定位失败或定位不准", Toast.LENGTH_SHORT).show();
        }
        baiduMapRequestPermissions();


    }

    @Override
    protected void onResume() {
        super.onResume();
        getDeliver();
    }

    private boolean baiduMapRequestPermissions() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (checkSelfPermission(READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED
                && checkSelfPermission(ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && checkSelfPermission(ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && checkSelfPermission(READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        requestPermissions(new String[]{
                READ_PHONE_STATE,
                ACCESS_COARSE_LOCATION,
                ACCESS_FINE_LOCATION,
                READ_EXTERNAL_STORAGE,
                WRITE_EXTERNAL_STORAGE
        }, BAIDU_REQUEST_PERMISSIONS);
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == BAIDU_REQUEST_PERMISSIONS) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            }
        }
    }

    private void initviews() {
        waitforship = (RelativeLayout) findViewById(R.id.layout_waitforship);
        waitforshipImage = (ImageView) findViewById(R.id.icon_waitforship);
        waitforshipText = (TextView) findViewById(R.id.text_waitforship);
        waitforshipView = findViewById(R.id.view_waitforship);
        shipping = (RelativeLayout) findViewById(R.id.layout_shipping);
        shippingImage = (ImageView) findViewById(R.id.icon_shipping);
        shippingText = (TextView) findViewById(R.id.text_shipping);
        shippingView = findViewById(R.id.view_shipping);
        complete = (RelativeLayout) findViewById(R.id.layout_complete);
        completeImage = (ImageView) findViewById(R.id.icon_complete);
        completeText = (TextView) findViewById(R.id.text_complete);
        completeView = findViewById(R.id.view_complete);

        scanQRcodeImage = (ImageView) findViewById(R.id.icon_sacn_qrcode);

    }

    private void initEvents() {
        waitforship.setOnClickListener(this);
        shipping.setOnClickListener(this);
        complete.setOnClickListener(this);
        scanQRcodeImage.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_waitforship:
                selet(0);
                break;
            case R.id.layout_shipping:
                selet(1);
                break;
            case R.id.layout_complete:
                selet(2);
                break;
            case R.id.icon_sacn_qrcode:
//                postOrderComplete("B2017122114253596364");
                if (CommonUtil.isCameraCanUse()) {
                    ActivityScanerCode.setScanerListener(new OnRxScanerListener() {
                        @Override
                        public void onSuccess(String s, Result result) {
                            RxActivityTool.finishActivity(ActivityScanerCode.class);
                            Toast.makeText(MainActivity.this, "扫描结果:" + result, Toast.LENGTH_SHORT).show();
                            handleResult(result.toString());
                        }

                        @Override
                        public void onFail(String s, String s1) {
                            Toast.makeText(MainActivity.this, s1, Toast.LENGTH_SHORT).show();
                        }
                    });
                    Intent intent = new Intent(MainActivity.this, com.vondear.rxtools.activity.ActivityScanerCode.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "请打开此应用的摄像头权限！", Toast.LENGTH_SHORT).show();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{CAMERA}, 10100);
                    }
                }
                break;
            case R.id.button_dialog_positive:
//                Toast.makeText(this, "确定", Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
//                ProgressDialog progressDialog = new ProgressDialog(this);
//                progressDialog.show();
//                if (bean != null) {
//
//                    Gson gson = new Gson();
//                    String obj = gson.toJson(bean.getData());
//                    try {
//                        String encodeString = URLEncoder.encode(obj, "UTF-8");
//                        NetClient.getInstance().getApi().signForOrder(encodeString)
//                                .subscribeOn(Schedulers.newThread())
//                                .observeOn(AndroidSchedulers.mainThread())
//                                .subscribe(new Consumer<ResultBean>() {
//                                    @Override
//                                    public void accept(ResultBean resultBean) throws Exception {
//                                        if (resultBean.getCode() == 200) {
//                                            Log.i(TAG, "accept: 成功!");
//                                            Toast.makeText(MainActivity.this, "上传成功", Toast.LENGTH_SHORT).show();
//                                            progressDialog.dismiss();
//                                            getDeliver();
//                                        } else {
//                                            progressDialog.dismiss();
//                                            Toast.makeText(MainActivity.this, "签收失败", Toast.LENGTH_SHORT).show();
//                                        }
//                                    }
//                                }, new Consumer<Throwable>() {
//                                    @Override
//                                    public void accept(Throwable throwable) throws Exception {
//                                        progressDialog.dismiss();
//                                        Toast.makeText(MainActivity.this, "连接服务器异常", Toast.LENGTH_SHORT).show();
//                                        throwable.printStackTrace();
//                                    }
//                                });
//                    } catch (UnsupportedEncodingException e) {
//                        e.printStackTrace();
//                    }
//                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(mReceiver);
    }

    private void selet(int i) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        hideFragment(transaction);
        resetEnable();
        switch (i) {
            case 0:
                if (waitFragment == null) {
                    waitFragment = new OrderListFragment();
                    transaction.add(R.id.main_framelayout, waitFragment);
                } else {
                    transaction.show(waitFragment);
                }
                waitforship.setEnabled(false);
                waitforshipImage.setEnabled(false);
                waitforshipText.setEnabled(false);
                waitforshipView.setVisibility(View.VISIBLE);
                break;
            case 1:
                if (shippingFragment == null) {
                    shippingFragment = new MapLocateFragment();
                    transaction.add(R.id.main_framelayout, shippingFragment);
                } else {
                    transaction.show(shippingFragment);
                }
                shipping.setEnabled(false);
                shippingImage.setEnabled(false);
                shippingText.setEnabled(false);
                shippingView.setVisibility(View.VISIBLE);
                break;
            case 2:
                if (completeFragment == null) {
                    completeFragment = new CompleteOrderFragment();
                    transaction.add(R.id.main_framelayout, completeFragment);
                } else {
                    transaction.show(completeFragment);
                }
                complete.setEnabled(false);
                completeImage.setEnabled(false);
                completeText.setEnabled(false);
                completeView.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (shippingFragment != null)
            transaction.hide(shippingFragment);
        if (waitFragment != null)
            transaction.hide(waitFragment);
        if (completeFragment != null)
            transaction.hide(completeFragment);
    }

    private void resetEnable() {
        waitforship.setEnabled(true);
        waitforshipImage.setEnabled(true);
        waitforshipText.setEnabled(true);
        waitforshipView.setVisibility(View.GONE);
        shipping.setEnabled(true);
        shippingImage.setEnabled(true);
        shippingText.setEnabled(true);
        shippingView.setVisibility(View.GONE);
        complete.setEnabled(true);
        completeImage.setEnabled(true);
        completeText.setEnabled(true);
        completeView.setVisibility(View.GONE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //扫描结果回调
        if (resultCode == RESULT_OK && requestCode == 100) { //RESULT_OK = -1
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("qr_scan_result");
            //将扫描出的信息显示出来
//            Toast.makeText(this,scanResult,Toast.LENGTH_SHORT).show();
            handleResult(scanResult);

        }

    }

    public void handleResult(String url) {
        try {
            JSONObject object = new JSONObject(url);
            String jiekou = object.getString("interface");
            if (TextUtils.equals(jiekou, Constant.HANDLE_ASSIGN_ORDER)) {
                //司机关联分拣单
                String assignOrderNumber = object.getString("assignOrderNumber");
                showdialog(assignOrderNumber);
            } else if (TextUtils.equals(jiekou, "getOrderDetailByOrderNumber")) {
                //订单送达，弹出需要填写的表单
                String orderNumber = object.getString("OrderNumber");
                postOrderComplete(orderNumber);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void showdialog(String assignOrderNumber) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("确定关联此分拣单:" + assignOrderNumber + "?")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        postLoadComplete(assignOrderNumber, BaseApplication.getInstance().getLoginBean().getData().getDriver().getDriverPhone());

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();
        dialog.show();
    }

    private ResultOrderDetailBean bean = null;
    private Dialog dialog;

    private void postOrderComplete(String orderNumber) {
        NetClient.getInstance().getApi().getOrderDetailByOrderNumber(orderNumber)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResultOrderDetailBean>() {
                    @Override
                    public void accept(ResultOrderDetailBean resultOrderDetailBean) throws Exception {
//                        bean = resultOrderDetailBean;
//                        dialog = new Dialog(MainActivity.this);
//                        dialog.setTitle("订单详情");
//                        dialog.setContentView(R.layout.dialog_qrcode_detail);
//                        dialog.show();
//                        ListView qrcodeDetail = (ListView) dialog.findViewById(R.id.list_qrcode_detail);
//                        QRCodeDetailListAdapter adapter = new QRCodeDetailListAdapter(MainActivity.this, resultOrderDetailBean);
//                        qrcodeDetail.setAdapter(adapter);
                        if (resultOrderDetailBean.getData().getOrderVo().getState() == 3) {

                            Log.i(TAG, "accept: 跳转");
                            BaseApplication.getInstance().setOrderDetailBean(resultOrderDetailBean);
                            startActivity(OrderDetailActivity.class);
                        }else {
                            Toast.makeText(MainActivity.this,"订单不能提交",Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });

    }

    private void postLoadComplete(String assignOrderNumber, String phone) {
        Observable<ResultBean> observable = NetClient.getInstance().getApi().handleAssignOrder(assignOrderNumber, phone);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResultBean>() {
                    @Override
                    public void accept(ResultBean s) throws Exception {
                        Log.i(TAG, "accept: " + s);
                        getDeliver();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
    }

    public void getDeliver() {
        if (BaseApplication.getInstance().getLoginBean().getData() != null && BaseApplication.getInstance().getLoginBean().getData().getDriver() == null)
            return;
        NetClient.getInstance().getApi().getDeliverOderByDriver(BaseApplication.getInstance().getLoginBean().getData().getDriver().getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResultDeliverBean>() {
                    @Override
                    public void accept(ResultDeliverBean resultDeliverBean) throws Exception {
                        if (resultDeliverBean.getData().getDeliverState() == 4 ||
                                resultDeliverBean.getData().getDeliverState() == 2 ||
                                resultDeliverBean.getData().getDeliverState() == 5) {
                            BaseApplication.getInstance().setDeliverBean(resultDeliverBean);
                            if (waitFragment != null) {
                                waitFragment.setDatas(resultDeliverBean);
                            }
                            if (shippingFragment != null) {
                                shippingFragment.setDatas(resultDeliverBean);
                            }
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
    }
}
