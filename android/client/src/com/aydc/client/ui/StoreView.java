package com.aydc.client.ui;


import butterknife.Bind;

import com.aydc.client.R;
import com.aydc.client.framwork.ViewDelegate;
import com.aydc.client.widgets.list.StickyListHeadersListView;

public class StoreView extends ViewDelegate{
	@Bind(R.id.act_store_food_lv) StickyListHeadersListView foodListView;
	@Override
	public int getRootLayoutId() {
		return R.layout.act_store;
	}
	@Override
	public void initWidget() {
		super.initWidget();
	}
}
