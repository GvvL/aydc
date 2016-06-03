package com.aydc.client.fragments;

import android.view.View;

import com.aydc.client.R;
import com.aydc.client.framwork.FrgP;
import com.aydc.client.models.Tab4Model;
import com.aydc.client.ptr.PtrDefaultHandler;
import com.aydc.client.ptr.PtrFrameLayout;
import com.aydc.client.ptr.PtrHandler;
import com.aydc.client.ptr.StoreHouseHeader;

public class Tab4_fragment extends FrgP<Tab4_view> implements PtrHandler{
	private Tab4Model tab4Model;
	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		if(!isVisibleToUser) return;
		if(tab4Model!=null) return;
		viewDelegate.mPtrFrame.postDelayed(new Runnable() {
			@Override
			public void run() {
				viewDelegate.mPtrFrame.autoRefresh();
			}
		}, 50);
	}
	
	@Override
	protected void preliminary() {
		super.preliminary();
		viewDelegate.mPtrFrame.setPtrHandler(this);
	}

	@Override
	public void onRefreshBegin(final PtrFrameLayout frame) {
		frame.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				tab4Model=new Tab4Model();
				frame.refreshComplete();
				viewDelegate.scrollView.setVisibility(View.VISIBLE);
				StoreHouseHeader header=(StoreHouseHeader) frame.getHeaderView();
				header.setTextColor(getActivity().getResources().getColor(R.color.mainwhite));
				header.setBackgroundColor(getActivity().getResources().getColor(R.color.maingreen));
				frame.setBackgroundColor(getActivity().getResources().getColor(R.color.maingreen));
			}
		}, 2000);
		
	}
	@Override
	public boolean checkCanDoRefresh(PtrFrameLayout frame, View content,
			View header) {
		return PtrDefaultHandler.checkContentCanBePulledDown(frame, viewDelegate.scrollView, header);
	}

}
