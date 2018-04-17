package com.drkj.logisticswarehouse.activity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.bigkoo.pickerview.OptionsPickerView;
import com.drkj.logisticswarehouse.BaseActivity;
import com.drkj.logisticswarehouse.BaseApplication;
import com.drkj.logisticswarehouse.R;
import com.drkj.logisticswarehouse.bean.ReclaimResultBean;
import com.drkj.logisticswarehouse.bean.ResultBean;
import com.drkj.logisticswarehouse.bean.ResultOrderDetailBean;
import com.drkj.logisticswarehouse.net.NetClient;
import com.drkj.logisticswarehouse.util.MathUtil;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.vondear.rxtools.RxImageTool.dp2px;

public class AddReclaimActivity extends BaseActivity {

    private ReclaimResultBean mReclaimResultBean;
    @BindView(R.id.list_reclaim)
    SwipeMenuListView listView;
    @BindView(R.id.text_price_after_reclaim)
    TextView priceText;
    private List<ResultOrderDetailBean.DataBean.CatalogueVoListBean> catalogueVoListBeans = new ArrayList<>();
    private BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reclaim);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
//                // create "open" item
//                SwipeMenuItem openItem = new SwipeMenuItem(
//                        getApplicationContext());
//                // set item background
//                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
//                        0xCE)));
//                // set item width
//                openItem.setWidth(dp2px(90));
//                // set item title
//                openItem.setTitle("Open");
//                // set item title fontsize
//                openItem.setTitleSize(18);
//                // set item title font color
//                openItem.setTitleColor(Color.WHITE);
//                // add to menu
//                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.GRAY));
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
//                deleteItem.setIcon(R.drawable.ic_delete);
                deleteItem.setTitle("删除");
                deleteItem.setTitleSize(18);
                deleteItem.setTitleColor(Color.BLACK);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        // set creator
        listView.setMenuCreator(creator);
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                catalogueVoListBeans.remove(position);
                adapter.notifyDataSetChanged();
                // false : close the menu; true : not close the menu
                return false;
            }
        });
        ResultOrderDetailBean bean = BaseApplication.getInstance().getOrderDetailBean();
        NetClient.getInstance().getApi().getReclaim(bean.getData().getOrderVo().getStockistId(), bean.getData().getOrderVo().getDealerId())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ReclaimResultBean>() {
                    @Override
                    public void accept(ReclaimResultBean reclaimResultBean) throws Exception {
                        mReclaimResultBean = reclaimResultBean;
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
        adapter = new ReclaimAdapter(catalogueVoListBeans);
        listView.setAdapter(adapter);
        double price = bean.getData().getOrderVo().getOrderActualPrice();
        for (ResultOrderDetailBean.DataBean.GoodsOrderVoListBean goodsOrderVoListBean : bean.getData().getGoodsOrderVoList()) {
            double returnPrice = (goodsOrderVoListBean.getGoodsReturnNums() * goodsOrderVoListBean.getAttribute()
                    + goodsOrderVoListBean.getChildGoodsReturnNums()) * goodsOrderVoListBean.getPrice();
            price -= returnPrice;
        }
        price = MathUtil.saveTwo(price);
        priceText.setText(price + "");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @OnClick(R.id.btn_add)
    void addReclaim() {
        if (mReclaimResultBean != null && mReclaimResultBean.getData() != null) {
            OptionsPickerView pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                @Override
                public void onOptionsSelect(int options1, int options2, int options3, View v) {
                    if (mReclaimResultBean.getData().get(options1).getReclaimPriceList().size() == 0) {
                        return;
                    }
                    ReclaimResultBean.DataBean.ReclaimPriceListBean bean2 = mReclaimResultBean.getData().get(options1).getReclaimPriceList().get(options2);
                    ResultOrderDetailBean.DataBean.CatalogueVoListBean bean1 = new ResultOrderDetailBean.DataBean.CatalogueVoListBean();

                    bean1.setName1(mReclaimResultBean.getData().get(options1).getName());
                    bean1.setName2(bean2.getName());
                    if (bean2.getReclaimPrice() > 0) {
                        bean1.setPrice(bean2.getReclaimPrice());
                    } else {
                        bean1.setPrice(bean2.getPrice());
                    }
                    bean1.setReclaimCatalogueId(bean2.getReclaimCatalogueId());
                    bean1.setUnit(bean2.getUnit());
                    bean1.setSubUnit(bean2.getSubUnit());
                    bean1.setSpec(bean2.getSpec());
                    bean1.setViewSpec(bean2.getViewSpec());
                    catalogueVoListBeans.add(bean1);
                    adapter.notifyDataSetChanged();
                }
            }).build();
            List<String> list1 = new ArrayList<>();
            List<List> list2 = new ArrayList<>();
            for (ReclaimResultBean.DataBean bean : mReclaimResultBean.getData()) {
                list1.add(bean.getName());
                List<String> list3 = new ArrayList<>();
                for (ReclaimResultBean.DataBean.ReclaimPriceListBean bean1 : bean.getReclaimPriceList()) {
                    list3.add(bean1.getName());
                }
                list2.add(list3);
            }
            if (list1.size() > 0) {

                pickerView.setPicker(list1, list2);
                pickerView.show();
            }

        }


    }

    @OnClick(R.id.btn_complete)
    void complete() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.show();
        Gson gson = new Gson();
        BaseApplication.getInstance().getOrderDetailBean().getData().setCatalogueVoList(catalogueVoListBeans);
        String obj = gson.toJson(BaseApplication.getInstance().getOrderDetailBean().getData());
        Log.i("objString", "complete: " + obj);
        try {
            String encodeString = URLEncoder.encode(obj, "UTF-8");
        NetClient.getInstance().getApi().signForOrder(encodeString)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResultBean>() {
                    @Override
                    public void accept(ResultBean resultBean) throws Exception {
                        if (resultBean.getCode() == 200) {
//                                Log.i(TAG, "accept: 成功!");
                            Toast.makeText(AddReclaimActivity.this, "上传成功", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            BaseApplication.getInstance().setOrderDetailBean(null);
                            finishActivity(OrderDetailActivity.class);
                            finish();
                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(AddReclaimActivity.this, "签收失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        progressDialog.dismiss();
                        Toast.makeText(AddReclaimActivity.this, "连接服务器异常", Toast.LENGTH_SHORT).show();
                        throwable.printStackTrace();
                    }
                });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void calculation() {
        ResultOrderDetailBean bean = BaseApplication.getInstance().getOrderDetailBean();
        double price = bean.getData().getOrderVo().getOrderActualPrice();
        for (ResultOrderDetailBean.DataBean.GoodsOrderVoListBean goodsOrderVoListBean : bean.getData().getGoodsOrderVoList()) {
            double returnPrice = (goodsOrderVoListBean.getGoodsReturnNums() * goodsOrderVoListBean.getAttribute()
                    + goodsOrderVoListBean.getChildGoodsReturnNums()) * goodsOrderVoListBean.getPrice();
            price -= returnPrice;
        }
        for (ResultOrderDetailBean.DataBean.CatalogueVoListBean bean1 : catalogueVoListBeans) {
            double price1 = bean1.getPrice() * (bean1.getReclaimNums() * bean1.getSpec() + bean1.getChildReclaimNums());
            BigDecimal b = new BigDecimal(price1);
            double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            price -= f1;
        }
        price = MathUtil.saveTwo(price);
        priceText.setText(price + "");
    }

    class ReclaimAdapter extends BaseAdapter {
        List<ResultOrderDetailBean.DataBean.CatalogueVoListBean> catalogueVoListBeans;

        public ReclaimAdapter(List<ResultOrderDetailBean.DataBean.CatalogueVoListBean> catalogueVoListBeans) {
            this.catalogueVoListBeans = catalogueVoListBeans;
        }

        @Override
        public int getCount() {
            return catalogueVoListBeans.size();
        }

        @Override
        public Object getItem(int position) {
            return catalogueVoListBeans.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(AddReclaimActivity.this).inflate(R.layout.item_add_reclaim, null);
                viewHolder = new ViewHolder();
                viewHolder.textView1 = convertView.findViewById(R.id.text1);
                viewHolder.textView2 = convertView.findViewById(R.id.text2);
                viewHolder.textView3 = convertView.findViewById(R.id.text3);
                viewHolder.textView4 = convertView.findViewById(R.id.text_unit);
                viewHolder.textView5 = convertView.findViewById(R.id.text_subunit);
                viewHolder.textSpec = convertView.findViewById(R.id.text_spec);
                viewHolder.editText1 = convertView.findViewById(R.id.edit1);
                viewHolder.editText2 = convertView.findViewById(R.id.edit2);
                viewHolder.editText3 = convertView.findViewById(R.id.edit3);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.textView4.setText(catalogueVoListBeans.get(position).getUnit());
            viewHolder.textView5.setText(catalogueVoListBeans.get(position).getSubUnit());
            viewHolder.textView1.setText(catalogueVoListBeans.get(position).getName1());
            viewHolder.textView2.setText(catalogueVoListBeans.get(position).getName2());
            viewHolder.editText2.setText(catalogueVoListBeans.get(position).getPrice() + "");
            viewHolder.textSpec.setText("规格:" + catalogueVoListBeans.get(position).getViewSpec());
            ViewHolder finalViewHolder = viewHolder;
            viewHolder.editText1.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (!TextUtils.isEmpty(s)) {
                        double price = (Integer.parseInt(s.toString()) * catalogueVoListBeans.get(position).getSpec() + catalogueVoListBeans.get(position).getChildReclaimNums())
                                * catalogueVoListBeans.get(position).getPrice();
                        BigDecimal b = new BigDecimal(price);
                        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        finalViewHolder.textView3.setText(f1 + "");
                        catalogueVoListBeans.get(position).setReclaimNums(Integer.parseInt(s.toString()));
                    } else {
                        catalogueVoListBeans.get(position).setReclaimNums(0);
                        double price = catalogueVoListBeans.get(position).getChildReclaimNums()
                                * catalogueVoListBeans.get(position).getPrice();
                        BigDecimal b = new BigDecimal(price);
                        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        finalViewHolder.textView3.setText(f1 + "");
                    }
                    calculation();
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            viewHolder.editText2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (!TextUtils.isEmpty(s)) {

                        double price = (catalogueVoListBeans.get(position).getReclaimNums()
                                * catalogueVoListBeans.get(position).getSpec() + catalogueVoListBeans.get(position).getChildReclaimNums())
                                * Double.parseDouble(s.toString());
                        BigDecimal b = new BigDecimal(price);
                        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        finalViewHolder.textView3.setText(f1 + "");
                        catalogueVoListBeans.get(position).setPrice(Double.parseDouble(s.toString()));

                    } else {
                        catalogueVoListBeans.get(position).setPrice(0.0);
                        finalViewHolder.textView3.setText("0.0");
                    }
                    calculation();
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            viewHolder.editText3.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (!TextUtils.isEmpty(s)) {
                        if (Integer.parseInt(s.toString()) >= catalogueVoListBeans.get(position).getSpec()) {
                            finalViewHolder.editText3.setText(s.subSequence(0, s.length() - 1));
                            finalViewHolder.editText3.setSelection(s.length() - 1);
                            return;
                        }
                        double price = (catalogueVoListBeans.get(position).getReclaimNums()
                                * catalogueVoListBeans.get(position).getSpec()
                                + Integer.parseInt(s.toString()))
                                * catalogueVoListBeans.get(position).getPrice();
                        BigDecimal b = new BigDecimal(price);
                        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        finalViewHolder.textView3.setText(f1 + "");
                        catalogueVoListBeans.get(position).setChildReclaimNums(Integer.parseInt(s.toString()));
                    } else {
                        catalogueVoListBeans.get(position).setChildReclaimNums(0);
                        double price = catalogueVoListBeans.get(position).getReclaimNums() * catalogueVoListBeans.get(position).getSpec()
                                * catalogueVoListBeans.get(position).getPrice();
                        BigDecimal b = new BigDecimal(price);
                        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        finalViewHolder.textView3.setText(f1 + "");
                    }
                    calculation();
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            return convertView;
        }

        class ViewHolder {
            public TextView textView1;
            public TextView textView2;
            public TextView textView4;
            public TextView textView5;
            public TextView textView3;
            public EditText editText1;
            public EditText editText2;
            public EditText editText3;
            public TextView textSpec;
        }
    }
}
