package com.aydc.client.adapter;

import com.aydc.client.R;

import butterknife.ButterKnife;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab3OrderAdapter extends RecyclerView.Adapter<Tab3OrderAdapter.ViewH>{
	private Context mContext;
	private LayoutInflater layoutInflater;
	public Tab3OrderAdapter(Context context) {
		mContext=context;
		layoutInflater=LayoutInflater.from(mContext);
	}

	@Override
	public int getItemCount() {
		return 4;
	}

	@Override
	public void onBindViewHolder(ViewH arg0, int arg1) {

		
	}

	@Override
	public ViewH onCreateViewHolder(ViewGroup arg0, int arg1) {
		View view=layoutInflater.inflate(R.layout.cell_tab3_order, arg0, false);
		ViewH vh=new ViewH(view);
		return vh;
	}

	public static class ViewH extends android.support.v7.widget.RecyclerView.ViewHolder{

		public ViewH(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
		
	}


}
