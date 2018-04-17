package com.drkj.logisticswarehouse.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.drkj.logisticswarehouse.BaseApplication;
import com.drkj.logisticswarehouse.R;
import com.drkj.logisticswarehouse.activity.MainActivity;
import com.drkj.logisticswarehouse.bean.OrderBean;
import com.drkj.logisticswarehouse.bean.ResultOrderDetailBean;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.List;

/**
 * Created by ganlong on 2017/11/2.
 */

public class QRCodeDetailListAdapter extends BaseAdapter {
    private ResultOrderDetailBean orderBean;
    private LayoutInflater inflater;
    private Context context;
    public QRCodeDetailListAdapter(Context context,ResultOrderDetailBean orderBean) {
        this.context = context;
        this.orderBean = orderBean;
        inflater = LayoutInflater.from(context);
    }

//    public void setOrderBean(ResultOrderDetailBean orderBean){
//        this.orderBean = orderBean;
//        notifyDataSetChanged();
//    }

    @Override
    public int getCount() {
        List<ResultOrderDetailBean.DataBean.GoodsOrderVoListBean> list = orderBean.getData().getGoodsOrderVoList();
        return list==null?1:list.size()+1;
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
        if (orderBean.getData().getGoodsOrderVoList()!=null&&position<orderBean.getData().getGoodsOrderVoList().size()){
            GoodsViewHolder viewHolder = null;
            ResultOrderDetailBean.DataBean.GoodsOrderVoListBean goodsDetail = orderBean.getData().getGoodsOrderVoList().get(position);
            if (convertView==null){
                viewHolder = new GoodsViewHolder();
                convertView = inflater.inflate(R.layout.item_goods_detail,null);
                viewHolder.returnTextView = (TextView) convertView.findViewById(R.id.text_return_title);
                viewHolder.returnNumber = (EditText) convertView.findViewById(R.id.edit_return_number);
                viewHolder.actualtextView = (TextView) convertView.findViewById(R.id.text_actual_title);
                viewHolder.actualNumber = (TextView) convertView.findViewById(R.id.text_actual_number);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (GoodsViewHolder) convertView.getTag();
            }
            viewHolder.returnTextView.setText(goodsDetail.getCategoryVo().getGoodsName()+"退货数量");
            viewHolder.actualtextView.setText(goodsDetail.getCategoryVo().getGoodsName()+"实收数量");
            RxTextView.textChanges(viewHolder.returnNumber).subscribe();
            
            viewHolder.returnNumber.addTextChangedListener(new MyTextWatcher(viewHolder,position));
        }else{

            if (convertView==null){

                convertView = inflater.inflate(R.layout.item_goods_common,null);
                textView1 = (TextView) convertView.findViewById(R.id.text_payment_after_return);
                editText1 = (EditText) convertView.findViewById(R.id.edit_return_bottle);
                textView2 = (TextView) convertView.findViewById(R.id.text_bottle_unitprice);
                textView3 = (TextView) convertView.findViewById(R.id.text_returnedBottleDeductible);
                editText2 = (EditText) convertView.findViewById(R.id.edit_bottleCapQuantity);
                textView4 = (TextView) convertView.findViewById(R.id.text_bottleCapUnitPrice);
                textView5 = (TextView) convertView.findViewById(R.id.text_returnedBottleCapDeductible);
                editText3 = (EditText) convertView.findViewById(R.id.text_plasticbox_quantity);
                textView6 = (TextView) convertView.findViewById(R.id.text_plasticbox_unitprice);
                textView7 = (TextView) convertView.findViewById(R.id.text_plasticbox_deductible);
                textView8 = (TextView) convertView.findViewById(R.id.text_final_payment);
                button = (Button) convertView.findViewById(R.id.button_dialog_positive);
                textView2.setText(orderBean.getData().getOrderVo().getBottleSinglePrice()+"");
                textView4.setText(orderBean.getData().getOrderVo().getCoverSinglePrice()+"");
                textView6.setText(orderBean.getData().getOrderVo().getBasketSinglePrice()+"");
                editText1.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (TextUtils.isEmpty(s)){
                            textView3.setText("0");
                            return;
                        }
                        int number = Integer.parseInt(s.toString());
                        double returnedBottleDeductible = number*orderBean.getData().getOrderVo().getBottleSinglePrice();
//                       orderBean.getData().getOrderVo().setBottlePrice(returnedBottleDeductible);
                       orderBean.getData().getOrderVo().setBottleRecycleNums(number);
                        textView3.setText(returnedBottleDeductible+"");
                        countPrice();
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                editText2.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (TextUtils.isEmpty(s)){
                            textView5.setText("0");
                            return;
                        }
                        int number = Integer.parseInt(s.toString());
                        double returnedBottleCapDeductible = number*orderBean.getData().getOrderVo().getCoverSinglePrice();
//                        orderBean.getData().getOrderVo().setCoverPrice(returnedBottleCapDeductible);
                        orderBean.getData().getOrderVo().setCoverRecycleNums(number);
                        textView5.setText(returnedBottleCapDeductible+"");
                        countPrice();
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                editText3.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (TextUtils.isEmpty(s)){
                            textView7.setText("0");
                            return;
                        }
                        int number = Integer.parseInt(s.toString());
                        double returnedplasticBoxDeductible = number*orderBean.getData().getOrderVo().getBasketSinglePrice();
//                        orderBean.getData().getOrderVo().setBasketPrice(returnedplasticBoxDeductible);
                        orderBean.getData().getOrderVo().setBasketRecycleNums(number);
                        textView7.setText(returnedplasticBoxDeductible+"");
                        countPrice();
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                button.setOnClickListener((MainActivity)context);
                countPrice();
            }
        }
        return convertView;
    }

    private class GoodsViewHolder{
        public TextView returnTextView;
        public EditText returnNumber;
        public TextView actualtextView;
        public TextView actualNumber;
    }

        /**
         * 退货后应收货款
         */
        public TextView textView1;
        /**
         * 回瓶数量
         */
        public EditText editText1;
        /**
         * 回瓶单价
         */
        public TextView textView2;
        /**
         * 回瓶可抵扣金额
         */
        public TextView textView3;

        /**
         * 瓶盖数量
         */
        public EditText editText2;
        /**
         * 瓶盖单价
         */
        public TextView textView4;
        /**
         * 瓶盖可抵扣金额
         */
        public TextView textView5;
        /**
         * 塑箱数量
         */
        public EditText editText3;
        /**
         * 塑箱单价
         */
        public TextView textView6;
        /**
         * 塑箱可抵扣金额
         */
        public TextView textView7;
        /**
         * 抵扣后应收取货款
         */
        public TextView textView8;

        public Button button;

    private void countPrice(){
        double returnGoods = 0;
        if (orderBean.getData().getGoodsOrderVoList()==null)
            return;
        for (int i = 0;i<orderBean.getData().getGoodsOrderVoList().size();i++){
            returnGoods += orderBean.getData().getGoodsOrderVoList().get(i).getPrice()
                                        *orderBean.getData().getGoodsOrderVoList().get(i).getGoodsReturnNums();
        }
        double paymentAfterReturnGoods = orderBean.getData().getOrderVo().getOrderActualPrice()-returnGoods;
        textView1.setText(paymentAfterReturnGoods+"");
        double fianlPayment = paymentAfterReturnGoods
                            - orderBean.getData().getOrderVo().getBottleSinglePrice()*orderBean.getData().getOrderVo().getBottleRecycleNums()
                            - orderBean.getData().getOrderVo().getCoverSinglePrice()*orderBean.getData().getOrderVo().getCoverRecycleNums()
                            - orderBean.getData().getOrderVo().getBasketSinglePrice()*orderBean.getData().getOrderVo().getBasketRecycleNums();
        textView8.setText(fianlPayment+"");
    }

    class MyTextWatcher implements TextWatcher {

        private GoodsViewHolder viewHolder ;
        private ResultOrderDetailBean.DataBean.GoodsOrderVoListBean goodsDetail;

        public MyTextWatcher(GoodsViewHolder viewHolder,int postion){
            this.viewHolder = viewHolder;
            goodsDetail = orderBean.getData().getGoodsOrderVoList().get(postion);
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (TextUtils.isEmpty(s)){
                viewHolder.actualNumber.setText(goodsDetail.getDeliverAmount()+"");
//                goodsDetail.setGoodsActualGetNums(goodsDetail.getDeliverAmount());
                goodsDetail.setGoodsReturnNums(0);
                countPrice();
                return;
            }
            int number = Integer.parseInt(s.toString());
            if (number>goodsDetail.getDeliverAmount()*goodsDetail.getCategoryVo().getAttribute()){
                Toast.makeText(BaseApplication.getInstance(),"退货数量不能大于送货数",Toast.LENGTH_SHORT).show();
                return;
            }
            int actualNumber = goodsDetail.getDeliverAmount() - number;
            viewHolder.actualNumber.setText(actualNumber+"");
//            goodsDetail.setGoodsActualGetNums(actualNumber);
            goodsDetail.setGoodsReturnNums(number);
            countPrice();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

}
