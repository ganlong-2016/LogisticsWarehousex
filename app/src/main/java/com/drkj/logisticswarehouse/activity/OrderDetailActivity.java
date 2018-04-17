package com.drkj.logisticswarehouse.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.drkj.logisticswarehouse.BaseActivity;
import com.drkj.logisticswarehouse.BaseApplication;
import com.drkj.logisticswarehouse.R;
import com.drkj.logisticswarehouse.bean.ResultOrderDetailBean;
import com.drkj.logisticswarehouse.util.MathUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderDetailActivity extends BaseActivity {
    @BindView(R.id.order_list)
    ListView listView;
    @BindView(R.id.text_price_after_return_goods)
    TextView priceText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ResultOrderDetailBean bean = BaseApplication.getInstance().getOrderDetailBean();
        MyAdapter adapter = new MyAdapter(bean);
        listView.setAdapter(adapter);
        double price =  bean.getData().getOrderVo().getOrderActualPrice();
        priceText.setText(price+"");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @OnClick(R.id.btn_add_reclaim)
    void addReclaim(){
        startActivity(AddReclaimActivity.class);
    }
    private void calculation(ResultOrderDetailBean bean){
       double price =  bean.getData().getOrderVo().getOrderActualPrice();
       for (ResultOrderDetailBean.DataBean.GoodsOrderVoListBean goodsOrderVoListBean :bean.getData().getGoodsOrderVoList()){
           double returnPrice = (goodsOrderVoListBean.getGoodsReturnNums()*goodsOrderVoListBean.getAttribute()
                   +goodsOrderVoListBean.getChildGoodsReturnNums())*goodsOrderVoListBean.getPrice();
           price -= returnPrice;
       }
       price = MathUtil.saveTwo(price);
        priceText.setText(price+"");
    }
    class MyAdapter extends BaseAdapter {
        ResultOrderDetailBean bean;

        public MyAdapter(ResultOrderDetailBean bean) {
            this.bean = bean;
        }

        @Override
        public int getCount() {
            return bean.getData().getGoodsOrderVoList().size();
        }

        @Override
        public Object getItem(int position) {
            return bean.getData().getGoodsOrderVoList().get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ResultOrderDetailBean.DataBean.GoodsOrderVoListBean goodsOrderVoListBean = bean.getData().getGoodsOrderVoList().get(position);
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(OrderDetailActivity.this).inflate(R.layout.item_orderdetail, null);
                holder.goodsName = convertView.findViewById(R.id.text_goods_name);
                holder.editText1 = convertView.findViewById(R.id.edit1);
                holder.editText2 = convertView.findViewById(R.id.edit2);
                holder.textView1 = convertView.findViewById(R.id.text1);
                holder.textView2 = convertView.findViewById(R.id.text2);
                holder.textView3 = convertView.findViewById(R.id.text3);
                holder.textView4 = convertView.findViewById(R.id.text4);
                holder.textView5 = convertView.findViewById(R.id.text5);
                holder.textView6 = convertView.findViewById(R.id.text6);
                holder.textView7 = convertView.findViewById(R.id.text7);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.goodsName.setText(goodsOrderVoListBean.getGoodsName());
            holder.textView1.setText(goodsOrderVoListBean.getCategoryVo().getUnit());
            holder.textView2.setText(goodsOrderVoListBean.getCategoryVo().getChildUnit());
            holder.textView4.setText(goodsOrderVoListBean.getCategoryVo().getUnit());
            holder.textView6.setText(goodsOrderVoListBean.getCategoryVo().getChildUnit());
            holder.textView7.setText("( 规格:"+goodsOrderVoListBean.getCategoryVo().getVisualAttribute()+" )");
            holder.textView3.setText(goodsOrderVoListBean.getDeliverAmount()+"");
            holder.textView5.setText(goodsOrderVoListBean.getChildDeliverAmount()+"");
            ViewHolder finalHolder = holder;
            holder.editText1.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (!TextUtils.isEmpty(s)){
                        int i = Integer.parseInt(s.toString());
                        if (i>goodsOrderVoListBean.getApplyAmount()){
                            String s1 = s.subSequence(0,s.length()-1).toString();
                            finalHolder.editText1.setText(s1);
                            finalHolder.editText1.setSelection(s1.length());
                        }else {
                            int b = goodsOrderVoListBean.getDeliverAmount()-i;
                            goodsOrderVoListBean.setGoodsReturnNums(i);
                            goodsOrderVoListBean.setGoodsActualGetNums(b);
                            finalHolder.textView3.setText(b+"");
                        }
                    }else {
                        goodsOrderVoListBean.setGoodsReturnNums(0);
                        goodsOrderVoListBean.setGoodsActualGetNums(goodsOrderVoListBean.getDeliverAmount());
                        finalHolder.textView3.setText(goodsOrderVoListBean.getDeliverAmount()+"");
                    }
                    calculation(bean);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            holder.editText2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (!TextUtils.isEmpty(s)){
                        int i = Integer.parseInt(s.toString());
                        if (i>=goodsOrderVoListBean.getAttribute()||
                                (goodsOrderVoListBean.getGoodsReturnNums()==goodsOrderVoListBean.getDeliverAmount()
                                        &&i>goodsOrderVoListBean.getChildDeliverAmount())){
                            String s1 = s.subSequence(0,s.length()-1).toString();
                            finalHolder.editText2.setText(s1);
                            finalHolder.editText2.setSelection(s1.length());

                        }else if (i>goodsOrderVoListBean.getChildDeliverAmount()){
                            int b = goodsOrderVoListBean.getChildDeliverAmount()+goodsOrderVoListBean.getAttribute()-i;
                            goodsOrderVoListBean.setChildGoodsReturnNums(i);
                            goodsOrderVoListBean.setChildGoodsActualGetNums(b);
                            goodsOrderVoListBean.setGoodsActualGetNums(goodsOrderVoListBean.getDeliverAmount()-goodsOrderVoListBean.getGoodsReturnNums()-1);
                            finalHolder.textView3.setText(goodsOrderVoListBean.getGoodsActualGetNums()+"");
                            finalHolder.textView5.setText(b+"");
                        }else {
                            int b = goodsOrderVoListBean.getChildDeliverAmount()-i;
                            goodsOrderVoListBean.setChildGoodsReturnNums(i);
                            goodsOrderVoListBean.setChildGoodsActualGetNums(b);
                            goodsOrderVoListBean.setGoodsActualGetNums(goodsOrderVoListBean.getDeliverAmount()-goodsOrderVoListBean.getGoodsReturnNums());
                            finalHolder.textView3.setText(goodsOrderVoListBean.getGoodsActualGetNums()+"");
                            finalHolder.textView5.setText(b+"");
                        }
                    }else {
                        goodsOrderVoListBean.setChildGoodsReturnNums(0);
                        goodsOrderVoListBean.setChildGoodsActualGetNums(goodsOrderVoListBean.getChildDeliverAmount());
                        goodsOrderVoListBean.setGoodsActualGetNums(goodsOrderVoListBean.getDeliverAmount()-goodsOrderVoListBean.getGoodsReturnNums());
                        finalHolder.textView3.setText(goodsOrderVoListBean.getGoodsActualGetNums()+"");
                        finalHolder.textView5.setText(goodsOrderVoListBean.getChildDeliverAmount()+"");
                    }
                    calculation(bean);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            return convertView;
        }

        class ViewHolder {
            TextView goodsName;
            EditText editText1;
            EditText editText2;
            TextView textView1;
            TextView textView2;
            TextView textView3;
            TextView textView4;
            TextView textView5;
            TextView textView6;
            TextView textView7;
        }
    }
}
