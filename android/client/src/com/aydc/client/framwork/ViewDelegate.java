package com.aydc.client.framwork;

import com.aydc.client.R;
import com.aydc.client.utils.AppUtil;
import com.aydc.client.widgets.MDialog;
import com.aydc.client.widgets.MDialog.ButtonRespond;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import butterknife.ButterKnife;

/**
 * Created by giw on 2016/2/21.
 */
public abstract class ViewDelegate implements IView {
	protected final SparseArray<View> mViews = new SparseArray<View>();
	protected View rootView;

	@Override
	public void create(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		int layoutId = getRootLayoutId();
		rootView = inflater.inflate(layoutId, container, false);
	}

	@Override
	public int getOptionsMenuId() {
		return 0;
	}

	@Override
	public View getRootView() {
		return rootView;
	}

	public void setRootView(View rootView) {
		this.rootView = rootView;
	}

	public abstract int getRootLayoutId();

	@Override
	public void initWidget() {
		ButterKnife.bind(this, getActivity());
	}

	@SuppressWarnings("unchecked")
	public <T extends View> T bindView(int id) {
		T view = (T) mViews.get(id);
		if (view == null) {
			view = (T) rootView.findViewById(id);
			mViews.put(id, view);
		}
		return view;
	}

	@SuppressWarnings("unchecked")
	public <T extends View> T get(int id) {
		return (T) bindView(id);
	}

	public void setOnClickListener(View.OnClickListener listener, int... ids) {
		if (ids == null) {
			return;
		}
		for (int id : ids) {
			get(id).setOnClickListener(listener);
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends Activity> T getActivity() {
		return (T) rootView.getContext();
	}

	public void deinitWidget() {
		ButterKnife.unbind(this);
	}

	/**
	 * @param str
	 */
	public void showTS(String str) {
		Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
	}

	MDialog mDialog;

	/**
	 * 
	 * @param title
	 * @param msg
	 * @param left左文字
	 * @param right有蚊子
	 * @param brs回调
	 */
	public void showDialog(String title, String msg, String left, String right,
			ButtonRespond brs) {
		if (mDialog == null) {
			mDialog = new MDialog(getActivity(), brs);
		} else {
			mDialog.setButtonRespond(brs);
		}
		mDialog.setDialogTitle(title);
		mDialog.setDialogMassage(msg);
		mDialog.setLeftButtonText(left);
		mDialog.setRightButtonText(right);
		mDialog.show();
	}

	public void hideDialog() {
		if (mDialog == null)
			return;
		mDialog.hide();
	}
	
	public void jumpPage(Class cls){
		Intent intent=new Intent(getActivity(), cls);
		getActivity().startActivity(intent);
	}

	// 可操作层
	private LinearLayout operateFrame;
	private final int SHOW_LOADING = 1;
	private final int SHOW_NO_DATA = 2;
	private final int SHOW_NO_NET = 3;

	// 加载进度条
	public void showLoading() {
		createFrame();
		if (SHOW_LOADING != (int) operateFrame.getTag()) {
			showTS("新建load");
			View loadingview = View.inflate(getActivity(),
					R.layout.show_loading, null);
			LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
			layoutParams.topMargin = (int) (AppUtil.getStatusBarHeight() + App
					.getInstance().getResources()
					.getDimension(R.dimen.nav_bar_hight));
			layoutParams.bottomMargin = (int) App.getInstance().getResources()
					.getDimension(R.dimen.bottom_bar_hight);
			operateFrame.addView(loadingview, layoutParams);
		}
		operateFrame.setTag(SHOW_LOADING);
	}

	// 无数据展示
	public void showNoData() {
		createFrame();
		if (SHOW_NO_DATA != (int) operateFrame.getTag()) {
			showTS("新建data");
			View loadingview = View.inflate(getActivity(),
					R.layout.show_no_data, null);
			LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
			layoutParams.topMargin = (int) (AppUtil.getStatusBarHeight() + App
					.getInstance().getResources()
					.getDimension(R.dimen.nav_bar_hight));
			layoutParams.bottomMargin = (int) App.getInstance().getResources()
					.getDimension(R.dimen.bottom_bar_hight);
			operateFrame.addView(loadingview, layoutParams);
		}
		operateFrame.setTag(SHOW_NO_DATA);
	}

	// 无网络展示
	public void showNoNet() {
		createFrame();
		if (SHOW_NO_NET != (int) operateFrame.getTag()) {
			showTS("新建net");
			View loadingview = View.inflate(getActivity(),
					R.layout.show_no_net, null);
			LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
			layoutParams.topMargin = (int) (AppUtil.getStatusBarHeight() + App
					.getInstance().getResources()
					.getDimension(R.dimen.nav_bar_hight));
			layoutParams.bottomMargin = (int) App.getInstance().getResources()
					.getDimension(R.dimen.bottom_bar_hight);
			operateFrame.addView(loadingview, layoutParams);
		}
		operateFrame.setTag(SHOW_NO_NET);
	}

	public void hideOperateFrame() {
		operateFrame.setVisibility(View.INVISIBLE);
	}
	public boolean isCanOperate(){
		return operateFrame.getVisibility()!=View.VISIBLE;
	}

	private void createFrame() {
		if (operateFrame == null) {
			showTS("新建层");
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT);
			operateFrame = new LinearLayout(this.getActivity());
			operateFrame.setLayoutParams(lp);
			operateFrame.setBackgroundColor(Color.TRANSPARENT);
			((ViewGroup) this.getActivity().getWindow().getDecorView())
					.addView(operateFrame);
			operateFrame.setTag(0);
		}
		operateFrame.setVisibility(View.VISIBLE);
	}
}
