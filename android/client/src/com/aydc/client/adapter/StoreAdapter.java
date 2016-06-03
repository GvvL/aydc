package com.aydc.client.adapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.aydc.client.R;
import com.aydc.client.entity.StoreBean;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StoreAdapter extends BaseAdapter{
	private Context mContext;
	private ArrayList<StoreBean> storearr=new ArrayList<>();
	public StoreAdapter(Context con,ArrayList<StoreBean> list) {
		mContext=con;
		storearr=list;
	}
	public StoreAdapter(Context con) {
		mContext=con;
	}
	public void setData(ArrayList<StoreBean> list){
		storearr=list;
		this.notifyDataSetChanged();
	}
	public void appendData(ArrayList<StoreBean> list){
		storearr.addAll(list);
		this.notifyDataSetChanged();
	}
	@Override
	public int getCount() {
		return storearr.size();
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
		VH vh = null;
		if(convertView==null){
			convertView=View.inflate(mContext, R.layout.cell_store, null);
			vh=new VH();
			ButterKnife.bind(vh, convertView);
			convertView.setTag(vh);
		}else{
			vh=(VH) convertView.getTag();
			
		}
		StoreBean sb=storearr.get(position);
		vh.tv_title.setText(sb.getNick_name());
		vh.tv_start_distribution_fee.setText("¥"+sb.getStart_distribution_fee());
		vh.tv_distribution_fee.setText("¥"+sb.getDistribution_fee());
		return convertView;
	}
	class VH{
		@Bind(R.id.st_title)
		TextView tv_title;
		@Bind(R.id.start_distribution_fee)
		TextView tv_start_distribution_fee;//起送价
		@Bind(R.id.distribution_fee)
		TextView tv_distribution_fee;//配送费
		@Bind(R.id.month_sales) TextView tv_month_sales;//月售
		@Bind(R.id.act_detail_str) TextView tv_act_detail_str;//活动详情
		@Bind(R.id.store_img) ImageView img_store;
	}

}
