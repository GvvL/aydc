package com.aydc.client.fragments;

import android.support.v7.widget.RecyclerView;
import android.widget.ScrollView;
import butterknife.Bind;

import com.aydc.client.R;
import com.aydc.client.framwork.ViewDelegate;
import com.aydc.client.ptr.PtrClassicFrameLayout;
import com.aydc.client.ptr.StoreHouseHeader;
import com.aydc.client.utils.AppUtil;

public class Tab3_view extends ViewDelegate{
	@Bind(R.id.rcv_order)
	RecyclerView rcv_order;
	@Bind(R.id.tab3_ptrlayout)
	PtrClassicFrameLayout mPtrFrame;
	@Bind(R.id.tab3_scrollview)
	ScrollView scrollView;
	@Override
	public int getRootLayoutId() {
		return R.layout.frg_tab3;
	}
	@Override
	public void initWidget() {
		super.initWidget();
		configPtr();
	}
	private void configPtr() {
		mPtrFrame.setLastUpdateTimeRelateObject(this);
		final StoreHouseHeader header=new StoreHouseHeader(getActivity());
		header.setPadding(0, AppUtil.dp2px(20), 0, 0);
		header.initWithStringArray(R.array.storehouse);
		header.setTextColor(getActivity().getResources().getColor(R.color.maingreen));
		header.setLineWidth(AppUtil.dp2px(2));
		header.setmBarDarkAlpha(0.8f);
		mPtrFrame.setHeaderView(header);
		mPtrFrame.addPtrUIHandler(header);
		mPtrFrame.disableWhenHorizontalMove(true);
        mPtrFrame.setResistance(1.7f);//阻尼
        mPtrFrame.setRatioOfHeaderHeightToRefresh(2.4f);
        mPtrFrame.setDurationToClose(300);
        mPtrFrame.setDurationToCloseHeader(1000);
	}
}
