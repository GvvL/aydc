package com.aydc.client.fragments;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ScrollView;
import butterknife.Bind;

import com.aydc.client.R;
import com.aydc.client.adapter.Tab2RecommendAdapter;
import com.aydc.client.adapter.Tab2RecommendDecoration;
import com.aydc.client.framwork.ViewDelegate;
import com.aydc.client.ptr.PtrClassicFrameLayout;
import com.aydc.client.ptr.StoreHouseHeader;
import com.aydc.client.utils.AppUtil;

public class Tab2_view extends ViewDelegate{
	@Bind(R.id.rcv_recommend) RecyclerView rev_recommend;
	@Bind(R.id.ptrClassicFrameLayout) PtrClassicFrameLayout ptrFrameLayout;
	@Bind(R.id.tab2_scrollview) ScrollView scrollView;
	@Override
	public int getRootLayoutId() {
		return R.layout.frg_tab2;
	}
	@Override
	public void initWidget() {
		super.initWidget();
		LinearLayoutManager llm=new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
		rev_recommend.setLayoutManager(llm);
		rev_recommend.setAdapter(new Tab2RecommendAdapter(getActivity()));
		rev_recommend.addItemDecoration(new Tab2RecommendDecoration());
		configPtr();
	}
	private void configPtr() {
		final StoreHouseHeader storeHouseHeader=new StoreHouseHeader(getActivity());
		storeHouseHeader.setPadding(0, AppUtil.dp2px(20), 0, 0);
		storeHouseHeader.initWithStringArray(R.array.storehouse);
		storeHouseHeader.setTextColor(getActivity().getResources().getColor(R.color.maingreen));
		storeHouseHeader.setLineWidth(AppUtil.dp2px(2));
		storeHouseHeader.setmBarDarkAlpha(0.8f);
		ptrFrameLayout.setHeaderView(storeHouseHeader);
		ptrFrameLayout.addPtrUIHandler(storeHouseHeader);
		ptrFrameLayout.disableWhenHorizontalMove(true);
		ptrFrameLayout.setResistance(1.7f);
		ptrFrameLayout.setRatioOfHeaderHeightToRefresh(2.4f);
		ptrFrameLayout.setDurationToClose(300);
		ptrFrameLayout.setDurationToCloseHeader(1000);
	}

}
