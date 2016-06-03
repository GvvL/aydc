package com.aydc.client.fragments;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.aydc.client.adapter.Tab3OrderAdapter;
import com.aydc.client.adapter.Tab3OrderDecoration;
import com.aydc.client.framwork.FrgP;
import com.aydc.client.models.Tab3Model;
import com.aydc.client.ptr.PtrDefaultHandler;
import com.aydc.client.ptr.PtrFrameLayout;
import com.aydc.client.ptr.PtrHandler;

public class Tab3_fragment extends FrgP<Tab3_view> implements PtrHandler{
	private Tab3Model tab3Model;
	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		if(!isVisibleToUser) return;
		if(tab3Model!=null) return;
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
		
		
		viewDelegate.rcv_order.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
		Tab3OrderAdapter adapter=new Tab3OrderAdapter(getActivity());
		viewDelegate.rcv_order.setAdapter(adapter);
		viewDelegate.rcv_order.addItemDecoration(new Tab3OrderDecoration());
		viewDelegate.rcv_order.setItemAnimator(new DefaultItemAnimator());
	}
	@Override
	public void onRefreshBegin(final PtrFrameLayout frame) {
		frame.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				tab3Model=new Tab3Model();
				frame.refreshComplete();
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
