package com.aydc.client.ui;




import java.util.ArrayList;
import java.util.List;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.aydc.client.R;
import com.aydc.client.fragments.Tab1_fragment;
import com.aydc.client.fragments.Tab2_fragment;
import com.aydc.client.fragments.Tab3_fragment;
import com.aydc.client.fragments.Tab4_fragment;
import com.aydc.client.framwork.App;
import com.aydc.client.framwork.Common;

public class MainActivity extends FragmentActivity implements OnPageChangeListener{
	@Bind(R.id.id_viewpager) ViewPager viewpager;
	@Bind(R.id.radiogroup) RadioGroup radioGroup;
	@Bind(R.id.id_tab_bottom_1) RadioButton rb1;
	@Bind(R.id.id_tab_bottom_2) RadioButton rb2;
	@Bind(R.id.id_tab_bottom_3) RadioButton rb3;
	@Bind(R.id.id_tab_bottom_4) RadioButton rb4;
	
	FragmentPagerAdapter mAdapter;
	private List<Fragment> mFragments = new ArrayList<Fragment>();
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.act_main);
		makeBarTranslucent(Common.TRANSTYPE);
		App.addActivity2Stack(this);
		ButterKnife.bind(this);
		rb1.setChecked(true);
		viewpager.setOnPageChangeListener(this);
		viewpager.setOffscreenPageLimit(4);//fragment初始化数据放入setuser
		initViewPager();
	
	}
	private void initViewPager() {
		mFragments.clear();
		Tab1_fragment tab1=new Tab1_fragment();
		Tab2_fragment tab2=new Tab2_fragment();
		Tab3_fragment tab3=new Tab3_fragment();
		Tab4_fragment tab4=new Tab4_fragment();
		mFragments.add(tab1);
		mFragments.add(tab2);
		mFragments.add(tab3);
		mFragments.add(tab4);
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
		{

			@Override
			public int getCount()
			{
				return mFragments.size();
			}

			@Override
			public Fragment getItem(int arg0)
			{
				return mFragments.get(arg0);
			}
		};
		viewpager.setAdapter(mAdapter);
		
	}
	@OnClick({R.id.id_tab_bottom_1,R.id.id_tab_bottom_2,R.id.id_tab_bottom_3,R.id.id_tab_bottom_4})
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.id_tab_bottom_1:
			viewpager.setCurrentItem(0,false);
			break;
		case R.id.id_tab_bottom_2:
			viewpager.setCurrentItem(1,false);
			break;
		case R.id.id_tab_bottom_3:
			viewpager.setCurrentItem(2,false);
			break;
		case R.id.id_tab_bottom_4:
			viewpager.setCurrentItem(3,false);
			break;
		default:
			break;
		}
		
	}
	@Override
	public void onPageScrollStateChanged(int id) {
		
	}
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
	}
	@Override
	public void onPageSelected(int id) {
		switch (id) {
		case 0:
			rb1.setChecked(true);
			break;
		case 1:
			rb2.setChecked(true);
			break;
		case 2:
			rb3.setChecked(true);
			break;
		case 3:
			rb4.setChecked(true);
			break;
		default:
			break;
		}
		
	}
	/*
	 * 状态栏透明化
	 */
	@SuppressWarnings("unused")
	@TargetApi(Build.VERSION_CODES.KITKAT)
	public void makeBarTranslucent(int transType){
		if(Common.TRANSTYPE==Common.NOTRANS) return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // 透明上部状态栏
            window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明下部导航栏
            if(Common.TRANSTYPE==Common.TRANSTOP) return;
            window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
	}

	

}
