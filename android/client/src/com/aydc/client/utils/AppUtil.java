package com.aydc.client.utils;


import com.aydc.client.framwork.App;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class AppUtil {
	/**
	 * 获取状态栏高度
	 * @return
	 */
    public static int getStatusBarHeight(){
		  int resourceId = App.getInstance().getResources().getIdentifier("status_bar_height", "dimen", "android");
		  int statusHeight=0;
		  if (resourceId > 0) {
		      statusHeight = App.getInstance().getResources().getDimensionPixelSize(resourceId);
		  }
		  return statusHeight;
//		     另两种获取办法
//		  Rect rectangle= new Rect();
//		  Window window= getWindow();
//		  window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
//		  int statusBarHeight= rectangle.top;
//		  showLog("状态2："+statusBarHeight);
//		  
//		  int s3=getWindowManager().getDefaultDisplay().getHeight()-rectangle.height();
//		  showLog("状态3："+s3);
    }
	/**
	 * 屏幕尺寸
	 * @param act
	 * @return
	 */
	public static DisplayMetrics getMetric(Activity act){
		DisplayMetrics metric = new DisplayMetrics();
		act.getWindowManager().getDefaultDisplay().getMetrics(metric);
		return metric;
	}
	/**
	 * 获取dp
	 * @param act
	 * @return
	 */
    @SuppressLint("NewApi")
    public static float[] getSceenDp() {
//    	WindowManager wm=act.getWindowManager();
        DisplayMetrics metrics =  App.getInstance().getResources().getDisplayMetrics();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            wm.getDefaultDisplay().getRealMetrics(metrics);
//        } else {
//            wm.getDefaultDisplay().getMetrics(metrics);
//        }
        float widthDp = metrics.widthPixels / metrics.density;
        float heightDp = metrics.heightPixels / metrics.density;
        float[] dps=new float[2];
        dps[0]=widthDp;
        dps[1]=heightDp;
        return dps;
    }
    /**
     * 
     * @param dpValue
     * @return
     */
    public static int dp2px(float dpValue) {
        final float scale = App.getInstance().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    public static int designedDP2px(float designedDp) {
    	int width=(int)getSceenDp()[0];
        if (width != 320) {
            designedDp = designedDp * width / 320f;
        }
        return dp2px(designedDp);
    }

    public static void setPadding(final View view, float left, float top, float right, float bottom) {
        view.setPadding(designedDP2px(left), dp2px(top), designedDP2px(right), dp2px(bottom));
    }

	/**
	 * 检查网络
	 * @param context
	 * @return
	 */
	public static boolean isHasNet(Context context) {
		ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = conn.getActiveNetworkInfo();// 获取联网状态网络
		if (info == null || !info.isAvailable()) {
			return false;
		} else {
			return true;
		}
	}

}
