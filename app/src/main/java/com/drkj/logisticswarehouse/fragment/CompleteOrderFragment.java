package com.drkj.logisticswarehouse.fragment;


import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.drkj.logisticswarehouse.BaseApplication;
import com.drkj.logisticswarehouse.R;
import com.drkj.logisticswarehouse.adapter.CompleteListAdapter;
import com.drkj.logisticswarehouse.bean.ResultDeliverBean;
import com.drkj.logisticswarehouse.net.NetClient;
import com.drkj.logisticswarehouse.util.SupportMultipleScreensUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ganlong on 2017/10/24.
 */

public class CompleteOrderFragment extends Fragment implements View.OnClickListener {
    private ListView completeList;
    private Button refreshButton;
    private Activity activity;
    private CompleteListAdapter adapter;
    private ProgressBar progressBar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_complete, null);
        completeList = (ListView) view.findViewById(R.id.list_complete);
        progressBar = view.findViewById(R.id.progressbar2);
        View view1 = inflater.inflate(R.layout.footer_listview, null);
        refreshButton = (Button) view1.findViewById(R.id.button_refresh);
        refreshButton.setOnClickListener(this);
        completeList.addFooterView(view1);
        SupportMultipleScreensUtil.scale(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = getActivity();
        adapter = new CompleteListAdapter(activity,BaseApplication.getInstance().getDeliverBean());
        completeList.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_refresh:
                progressBar.setVisibility(View.VISIBLE);
                NetClient.getInstance().getApi().getDeliverOderByDriver(BaseApplication.getInstance().getLoginBean().getData().getDriver().getId())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<ResultDeliverBean>() {
                            @Override
                            public void accept(ResultDeliverBean resultDeliverBean) throws Exception {
                                progressBar.setVisibility(View.GONE);
                                if (resultDeliverBean.getData().getDeliverState() == 2||
                                        resultDeliverBean.getData().getDeliverState() == 3||
                                        resultDeliverBean.getData().getDeliverState() == 5) {
                                    BaseApplication.getInstance().setDeliverBean(resultDeliverBean);
                                    adapter.setData(resultDeliverBean);
                                }
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                progressBar.setVisibility(View.GONE);
                                throwable.printStackTrace();
                            }
                        });

                break;
            default:
                break;
        }
    }
}
