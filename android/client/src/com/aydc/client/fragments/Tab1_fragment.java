package com.aydc.client.fragments;

import android.view.View;

import com.amap.api.location.AMapLocation;
import com.aydc.client.entity.Tab1Bean;
import com.aydc.client.framwork.FrgP;
import com.aydc.client.models.Tab1Model;
import com.aydc.client.models.Tab1Model.RespBack;
import com.aydc.client.ptr.PtrDefaultHandler;
import com.aydc.client.ptr.PtrFrameLayout;
import com.aydc.client.ptr.PtrHandler;
import com.aydc.client.utils.LocationManager;
import com.aydc.client.utils.LocationManager.LocationCallBack;

public class Tab1_fragment extends FrgP<Tab1_view> implements PtrHandler{
	private Tab1Model tab1model;
	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		if(isVisibleToUser && tab1model==null){
			tab1model=new Tab1Model();
		}
	}

	@Override
	protected void preliminary() {
		

		viewDelegate.mPtrFrame.setPtrHandler(this);
		
		
        viewDelegate.mPtrFrame.postDelayed(new Runnable() {
            @Override
            public void run() {
            	viewDelegate.mPtrFrame.autoRefresh();
            }
        }, 100);
	}

	@Override
	public boolean checkCanDoRefresh(PtrFrameLayout frame, View content,
			View header) {
		return PtrDefaultHandler.checkContentCanBePulledDown(frame, viewDelegate.scrollView, header);
	}

	@Override
	public void onRefreshBegin(final PtrFrameLayout frame) {
		LocationManager.getInstance().start(new LocationCallBack() {
			
			@Override
			public void locationComplete(AMapLocation amapLocation) {
				viewDelegate.showTS("--"+amapLocation.getAoiName());
				viewDelegate.updataAddress(amapLocation);
			}
		});
		tab1model.firstQuery(new RespBack() {
			@Override
			public void complete(Tab1Bean tab1bean) {
				frame.refreshComplete();
				frame.setRatioOfHeaderHeightToRefresh(1.7f);
				viewDelegate.adatper_store.setData(tab1bean.getStore());
				viewDelegate.showAdv(tab1bean.getBanner());
				viewDelegate.scrollView.scrollTo(0, 0);
				viewDelegate.scrollView.setVisibility(View.VISIBLE);
				
			}
		});
		
	}

}
