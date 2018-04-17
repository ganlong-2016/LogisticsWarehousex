package com.drkj.logisticswarehouse.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.drkj.logisticswarehouse.bean.OrderBean;

import java.util.List;


/**
 * Created by ganlong on 2017/10/12.
 */

public class OrderListAdapter extends BaseAdapter {

    private List<OrderBean> orderBeens;

    public OrderListAdapter(List<OrderBean> orderBeens){
        this.orderBeens = orderBeens;
    }

    @Override
    public int getCount() {
        return orderBeens.size();
    }

    @Override
    public Object getItem(int position) {
        return orderBeens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
