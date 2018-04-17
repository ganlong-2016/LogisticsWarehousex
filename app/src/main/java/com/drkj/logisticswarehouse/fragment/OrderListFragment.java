package com.drkj.logisticswarehouse.fragment;


import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.drkj.logisticswarehouse.BaseApplication;
import com.drkj.logisticswarehouse.R;
import com.drkj.logisticswarehouse.adapter.OrderListDetailAdapter;
import com.drkj.logisticswarehouse.bean.Result2Bean;
import com.drkj.logisticswarehouse.bean.ResultDeliverBean;
import com.drkj.logisticswarehouse.net.NetClient;
import com.drkj.logisticswarehouse.util.SupportMultipleScreensUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ganlong on 2017/10/24.
 */

public class OrderListFragment extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    private ResultDeliverBean deliverBean;
    private ArrayList<String> data = new ArrayList<>();
    public static final String[] orders = new String[1];
    //    {
//            "【第一站】滨河路二段368",
//            "【第二站】高新区益州大道599号",
//            "【第三站】高新区天府大道中段 500号",
//            "【第四站】成都大学",
//            "【第五站】四川大学",
//            "【第六站】航天城上城",
//            "【第一站】滨河路二段368",
//            "【第二站】高新区益州大道599号",
//            "【第三站】高新区天府大道中段 500号",
//            "【第四站】成都大学",
//            "【第五站】四川大学",
//            "【第六站】航天城上城"
//    };
    public static final String[] order = new String[]{
            "【第一站】",
            "【第二站】",
            "【第三站】",
            "【第四站】",
            "【第五站】",
            "【第六站】",
            "【第七站】",
            "【第八站】",
            "【第九站】",
            "【第十站】",
            "【第十一站】",
            "【第十二站】",
            "【第十三站】",
            "【第十四站】",
            "【第十五站】",
            "【第十六站】",
            "【第十七站】",
            "【第十八站】",
            "【第十九站】",
            "【第二十站】",
    };
    private Activity activity;
    private ListView listView;

    private ArrayAdapter adapter;
    private Button startshipButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_orderlist, null);
        listView = (ListView) view.findViewById(R.id.list_orderlist);
        startshipButton = (Button) view.findViewById(R.id.button_start_ship);
        startshipButton.setOnClickListener(this);
        startshipButton.setVisibility(View.GONE);
        SupportMultipleScreensUtil.scale(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = getActivity();
        adapter = new ArrayAdapter(activity, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        setDatas(BaseApplication.getInstance().getDeliverBean());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Dialog dialog = new Dialog(activity);
        dialog.setTitle("订单信息");
        dialog.setContentView(R.layout.dialog_orderlist_detail);
        ListView list = dialog.findViewById(R.id.list_order_detail);
        BaseAdapter adapter = new OrderListDetailAdapter(activity,BaseApplication.getInstance().getDeliverBean().getData().getStockistDeliverVoList().get(position));
        list.setAdapter(adapter);
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_start_ship:
                if (TextUtils.equals(startshipButton.getText().toString(),"开始配送")){
                    showStartDialog();

                }else if(TextUtils.equals(startshipButton.getText().toString(),"结束配送")){
                    showEndDialog();
                }

                break;
            default:
                break;
        }
    }

    private void showStartDialog() {
        AlertDialog dialog = new AlertDialog.Builder(activity)
                .setMessage("确定开始配送")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String deliverOrderNumber = deliverBean.getData().getDeliverOrderNumber();
                        NetClient.getInstance().getApi().beginDeliver(deliverOrderNumber)
                                .subscribeOn(Schedulers.newThread())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<Result2Bean>() {
                                    @Override
                                    public void accept(Result2Bean result2Bean) throws Exception {
                                        startshipButton.setVisibility(View.GONE);
                                    }
                                }, new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) throws Exception {
                                        throwable.printStackTrace();
                                    }
                                });

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
    private void showEndDialog() {
        AlertDialog dialog = new AlertDialog.Builder(activity)
                .setMessage("确定结束配送")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String deliverOrderNumber = deliverBean.getData().getDeliverOrderNumber();
                        NetClient.getInstance().getApi().endDeliver(deliverOrderNumber)
                                .subscribeOn(Schedulers.newThread())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<Result2Bean>() {
                                    @Override
                                    public void accept(Result2Bean result2Bean) throws Exception {
                                        startshipButton.setVisibility(View.GONE);
                                    }
                                }, new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) throws Exception {
                                        throwable.printStackTrace();
                                    }
                                });


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
    public void setDatas(ResultDeliverBean bean) {
        if (bean == null) return;
        deliverBean = bean;
        List<ResultDeliverBean.DataBean.StockistDeliverVoListBean> list = bean.getData().getStockistDeliverVoList();
        data.clear();
        for (int i = 0; i < list.size(); i++) {
            int seq = list.get(i).getSeq();
            data.add(seq,order[seq] + list.get(i).getStockistVo().getShopName());
        }
//        if (bean.getData().getDeliverState()==1)
//            startshipButton.setVisibility(View.VISIBLE);
        if (deliverBean.getData().getDeliverState() == 4||deliverBean.getData().getDeliverState() == 5)
            startshipButton.setVisibility(View.VISIBLE);
        if (deliverBean.getData().getDeliverState() == 4){
            startshipButton.setText("开始配送");
        }
        if (deliverBean.getData().getDeliverState() == 5){
            startshipButton.setText("结束配送");
        }
        if (adapter != null)
            adapter.notifyDataSetChanged();
    }
}
