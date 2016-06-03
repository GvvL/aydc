package com.aydc.client.fragments;


import java.util.ArrayList;
import java.util.List;

import org.greenrobot.eventbus.EventBus;

import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;

import com.amap.api.location.AMapLocation;
import com.aydc.client.R;
import com.aydc.client.adapter.StoreAdapter;
import com.aydc.client.entity.BannerBean;
import com.aydc.client.entity.UserBean;
import com.aydc.client.framwork.ViewDelegate;
import com.aydc.client.ptr.PtrClassicFrameLayout;
import com.aydc.client.ptr.StoreHouseHeader;
import com.aydc.client.utils.AppUtil;
import com.aydc.client.utils.HttpManager;
import com.aydc.client.widgets.CircleIndicator;
import com.aydc.client.widgets.MImageCycleView;
import com.aydc.client.widgets.MListView;
import com.aydc.client.widgets.MScrollViewExtend;
import com.aydc.client.widgets.MImageCycleView.ImageInfo;
import com.aydc.client.widgets.MImageCycleView.LoadImageCallBack;
import com.aydc.client.widgets.MScrollViewExtend.OnScrollListener;
import com.bumptech.glide.Glide;

public class Tab1_view extends ViewDelegate implements OnScrollListener{
	@Bind(R.id.imagecycleview)
	MImageCycleView imagecycle;//顶部广告条
	@Bind(R.id.indicator)
	CircleIndicator indicator;//知识器
	@Bind(R.id.ptrlayout)
	PtrClassicFrameLayout mPtrFrame;
	@Bind(R.id.scrollview)
	MScrollViewExtend scrollView;
	@Bind(R.id.lv_store)
	MListView lv_store;
	StoreAdapter adatper_store;
	@Bind(R.id.llt)
	LinearLayout linearlayout;
	@Bind(R.id.condition_s)
	LinearLayout condition_s;
	@Bind(R.id.condition)
	LinearLayout condition;
	
	@Bind(R.id.tv_address) TextView tv_address;

	
	@Override
	public int getRootLayoutId() {
		return R.layout.frg_tab1;
	}
	@Override
	public void initWidget() {
		super.initWidget();
		adatper_store=new StoreAdapter(getActivity());
		lv_store.setAdapter(adatper_store);
		configPtrLayout();
		scrollView.setOnScrollListener(this);	
	}
	@OnClick(R.id.img_search)
	public void onclick(){
		EventBus.getDefault().post(new UserBean());
	}
	/**
	 * 下拉刷新
	 */
	private void configPtrLayout() {
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
        mPtrFrame.setPullToRefresh(false);// default is false
        mPtrFrame.setKeepHeaderWhenRefresh(true);// default is true
		
	}
	public void showAdv(List<BannerBean> banlist){
		List<MImageCycleView.ImageInfo> list = new ArrayList<MImageCycleView.ImageInfo>();
		for(BannerBean bb:banlist){
			list.add(new MImageCycleView.ImageInfo(bb.getBanner_content(), "",
					""));
		}
		
		imagecycle.loadData(list, new LoadImageCallBack() {
			@Override
			public View loadAndDisplay(ImageInfo imageInfo) {
				ImageView imageView = new ImageView(getActivity());
				imageView.setScaleType(ScaleType.FIT_XY);
				Glide.with(getActivity()).load(HttpManager.API_SERVER+imageInfo.image.toString()).into(imageView);
				return imageView;
			}
		});
		imagecycle.hindBottomText();// 清除di部文字
		indicator.setViewPager(imagecycle.getIndicatorVP());//设置一个指示器
		
	}
	/**
	 * 地址
	 */
	public void updataAddress(AMapLocation amapLocation){
		tv_address.setText("送至:"+amapLocation.getAoiName()+"\t");
	}
	
	

	@Override
	public void onScroll(int scrollY) {

	}
	@Override
	public void scrolling(int scrollY) {
		if(scrollY>condition.getTop()){
			if(condition_s.getVisibility()==View.VISIBLE) return;
			condition_s.setVisibility(View.VISIBLE);
		}else{
			if(condition_s.getVisibility()==View.INVISIBLE) return;
			condition_s.setVisibility(View.INVISIBLE);
		}
		
	}

	


}
