package com.aydc.client.utils;

import com.aydc.client.framwork.App;
import com.squareup.okhttp.Headers;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
/**
 * cookie管理类
 * @author Administrator
 *
 */
public class CookieUtil {

	public static String getCookies(Context context) {
		String str="";
		if(App.getSharedPrefences(context).contains("Cooki")){
			str=App.getSharedPrefences(context).getString("Cooki", "");
		}
		return str;
	}

	public static void saveCookies(Headers headers, Context context) {
		String string = headers.get("Set-Cookie");
		if(string!=null&&string.length()>0){
			App.getSharedPrefences(context).edit().putString("Cooki", string).commit();
		}
	}

}
