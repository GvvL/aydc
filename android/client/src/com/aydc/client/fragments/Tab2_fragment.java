package com.aydc.client.fragments;


import android.view.View;

import com.aydc.client.framwork.FrgP;
import com.aydc.client.models.Tab2Model;
import com.aydc.client.ptr.PtrDefaultHandler;
import com.aydc.client.ptr.PtrFrameLayout;
import com.aydc.client.ptr.PtrHandler;

public class Tab2_fragment extends FrgP<Tab2_view> implements PtrHandler{
	private Tab2Model tab2Model;
	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		if(!isVisibleToUser) return;
		if(tab2Model!=null) return;
		viewDelegate.ptrFrameLayout.postDelayed(new Runnable() {
			@Override
			public void run() {
				viewDelegate.ptrFrameLayout.autoRefresh();
			}
		}, 100);
	}
	
	@Override
	protected void preliminary() {
		super.preliminary();
		viewDelegate.ptrFrameLayout.setPtrHandler(this);
	}

	@Override
	public void onRefreshBegin(final PtrFrameLayout frame) {
		viewDelegate.ptrFrameLayout.postDelayed(new Runnable() {
			@Override
			public void run() {
				frame.refreshComplete();
				frame.setRatioOfHeaderHeightToRefresh(1.7f);
				tab2Model=new Tab2Model();
				viewDelegate.scrollView.setVisibility(View.VISIBLE);
			}
		}, 2000);
	}
	@Override
	public boolean checkCanDoRefresh(PtrFrameLayout frame, View content,
			View header) {
		return PtrDefaultHandler.checkContentCanBePulledDown(frame, viewDelegate.scrollView, header);
	}

	
}
