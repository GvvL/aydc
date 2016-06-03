package com.aydc.client.adapter;

import butterknife.ButterKnife;

import com.aydc.client.R;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class Tab2RecommendAdapter extends RecyclerView.Adapter<Tab2RecommendAdapter.ViewHolder>{
	private Context mContext;
	public Tab2RecommendAdapter(Context c) {
		this.mContext=c;
	}
	@Override
	public int getItemCount() {
		return 6;
	}

	@Override
	public void onBindViewHolder(ViewHolder vh, int arg1) {
		
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup vg, int position) {
		View view=View.inflate(mContext, R.layout.cell_tab2_recommend, null);
		ViewHolder vh=new ViewHolder(view);
		return vh;
	}
	
	public static class ViewHolder extends RecyclerView.ViewHolder{
		
		public ViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}


}
