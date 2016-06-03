package com.aydc.client.adapter;

import com.aydc.client.utils.AppUtil;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class Tab3OrderDecoration extends ItemDecoration{
	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
			State state) {
//		if(parent.getChildPosition(view)!=parent.getChildCount()-1){
			outRect.bottom=AppUtil.designedDP2px(20);
//		}
	}

}
