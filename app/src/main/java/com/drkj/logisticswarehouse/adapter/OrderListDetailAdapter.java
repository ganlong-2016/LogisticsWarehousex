package com.drkj.logisticswarehouse.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.drkj.logisticswarehouse.R;
import com.drkj.logisticswarehouse.bean.ResultDeliverBean;

/**
 * Created by ganlong on 2017/11/16.
 */

public class OrderListDetailAdapter extends BaseAdapter {
    private ResultDeliverBean.DataBean.StockistDeliverVoListBean bean ;
    private LayoutInflater inflater;
    public OrderListDetailAdapter(Context context,ResultDeliverBean.DataBean.StockistDeliverVoListBean bean){
        this.bean = bean;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        if (bean==null)return 0;
        return bean.getOrderAppVos().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView ==null){
            holder = new Holder();
            convertView = inflater.inflate(R.layout.item_orderlist_detail,null);
            holder.textView1 = convertView.findViewById(R.id.text_order_number);
            holder.textView2 = convertView.findViewById(R.id.text_time);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }
        holder.textView1.setText(bean.getOrderAppVos().get(position).getOrderVo().getOrderNumber());
        holder.textView2.setText(bean.getOrderAppVos().get(position).getOrderVo().getPriotyTime());
        return convertView;
    }

    class Holder{
        public TextView textView1;
        public TextView textView2;
    }
}
