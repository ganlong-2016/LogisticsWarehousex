package com.drkj.logisticswarehouse.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.drkj.logisticswarehouse.R;
import com.drkj.logisticswarehouse.bean.ResultDeliverBean;
import com.drkj.logisticswarehouse.util.SupportMultipleScreensUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ganlong on 2017/10/25.
 */

public class CompleteListAdapter extends BaseAdapter {

    private LayoutInflater inflater;

    private List<ResultDeliverBean.DataBean.StockistDeliverVoListBean.OrderAppVosBean> list = new ArrayList<>();
    public CompleteListAdapter(Context context, ResultDeliverBean bean) {

        inflater = LayoutInflater.from(context);
        setData(bean);
    }

    @Override
    public int getCount() {

        return list.size();
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
        ViewHolder viewHolder = null;
        ResultDeliverBean.DataBean.StockistDeliverVoListBean.OrderAppVosBean bean = list.get(position);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_complete_list, null);
            viewHolder.textView1 = convertView.findViewById(R.id.history_shop_name);
            viewHolder.textView2 = convertView.findViewById(R.id.history_goods_name);
            viewHolder.textView3 = convertView.findViewById(R.id.history_unit_price);
            viewHolder.textView4 = convertView.findViewById(R.id.history_count);
            viewHolder.textView5 = convertView.findViewById(R.id.history_money);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView1.setText("零售商名称:"+bean.getOrderVo().getStockistVo().getShopName());
        viewHolder.textView2.setText("订单号:"+bean.getOrderVo().getOrderNumber());
        viewHolder.textView3.setText("地址:"+bean.getOrderVo().getStockistVo().getAddress());
        viewHolder.textView4.setText("电话:"+bean.getOrderVo().getStockistVo().getPhone());
        viewHolder.textView5.setText("代收货款:"+bean.getOrderVo().getOrderFinalPrice()+"");
        SupportMultipleScreensUtil.scale(convertView);
        return convertView;
    }

    private class ViewHolder {
        public TextView textView1;
        public TextView textView2;
        public TextView textView3;
        public TextView textView4;
        public TextView textView5;
    }
    public void setData(ResultDeliverBean bean){
        if (bean==null)return;
        list.clear();
        for (int i = 0; i < bean.getData().getStockistDeliverVoList().size(); i++) {
            for (int j = 0; j < bean.getData().getStockistDeliverVoList().get(i).getOrderAppVos().size(); j++) {
                if (bean.getData().getStockistDeliverVoList().get(i).getOrderAppVos().get(j).getOrderVo().getState() == 4
                        ||bean.getData().getStockistDeliverVoList().get(i).getOrderAppVos().get(j).getOrderVo().getState() == 6
                        ||bean.getData().getStockistDeliverVoList().get(i).getOrderAppVos().get(j).getOrderVo().getState() == 99) {
                    list.add(bean.getData().getStockistDeliverVoList().get(i).getOrderAppVos().get(j));
                }
            }
        }
        notifyDataSetChanged();
    }
}
