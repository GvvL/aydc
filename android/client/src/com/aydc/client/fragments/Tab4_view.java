package com.aydc.client.fragments;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import android.widget.ScrollView;
import android.widget.Toast;
import butterknife.Bind;

import com.aydc.client.R;
import com.aydc.client.entity.UserBean;
import com.aydc.client.framwork.ViewDelegate;
import com.aydc.client.ptr.PtrClassicFrameLayout;
import com.aydc.client.ptr.StoreHouseHeader;
import com.aydc.client.utils.AppUtil;

public class Tab4_view extends ViewDelegate{
	@Bind(R.id.tab4_ptrlayout) PtrClassicFrameLayout mPtrFrame;
	@Bind(R.id.tab4_scrollview) ScrollView scrollView;
	@Override
	public int getRootLayoutId() {
		return R.layout.frg_tab4;
	}
	@Override
	public void initWidget() {
		super.initWidget();
		configPtr();
		EventBus.getDefault().register(this);
	}
	/**
	 * 用户信息展示更新
	 * all event post there
	 * @param user
	 */
	@Subscribe(threadMode=ThreadMode.MAIN)
	public void displayUserInfo(UserBean user){
		if(!user.isLogin()){
			//未登录
		}else{
			
			Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();
		}
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
	@Override
	public void deinitWidget() {
		super.deinitWidget();
		EventBus.getDefault().unregister(this);
	}

}
