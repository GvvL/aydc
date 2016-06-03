package com.aydc.client.adapter;

import com.aydc.client.utils.AppUtil;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class Tab2RecommendDecoration extends ItemDecoration{
	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
			State state) {
		if(parent.getChildPosition(view)==0){
			outRect.left=AppUtil.designedDP2px(10);
			outRect.right=AppUtil.designedDP2px(10);
		}else if(parent.getChildPosition(view)==parent.getChildCount()-1){
			outRect.right=AppUtil.designedDP2px(10);
		}else{
			outRect.right=AppUtil.designedDP2px(10);
		}
	}

}
