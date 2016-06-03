package com.aydc.client.models;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.aydc.client.entity.ResponseDataItem;
import com.aydc.client.entity.UserBean;
import com.aydc.client.framwork.App;
import com.aydc.client.utils.ApiCallBack;
import com.aydc.client.utils.HttpManager;
import com.aydc.client.utils.JSONUtil;
import com.aydc.client.utils.Md5Util;

public class UserModel {
	private static String SP_USER_KEY="user";
	private static UserModel instance=new UserModel();
	private UserModel(){
		
	}
	public static UserModel getInstance(){
		return instance;
	}
	
	public boolean isLogin(Context c){
		String userstr = App.getSharedPrefences(c).getString(SP_USER_KEY, "");
		if(userstr.length()<10) return false;
		return true;
	}
	/**
	 * 获取sp的user
	 * @return
	 */
	public UserBean getUserLocal(Context c){
		if(!isLogin(c)) throw new RuntimeException("用户尚未登录");
		String userstr = App.getSharedPrefences(c).getString(SP_USER_KEY, "");
		JSONObject instaceJsonObject = JSONUtil.instaceJsonObject(userstr);
		UserBean userBean=JSONUtil.jsonObject2Bean(instaceJsonObject, UserBean.class);
		return userBean;
	}
	/**
	 * 获取用户信息 网络
	 * @param ucb 
	 */
	public void getUserOnServer(final Context c,@Nullable final UserCallBack ucb){
			userServerApi.getUser(getUserLocal(c).getId()+"")
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(new ApiCallBack<ResponseDataItem<UserBean>>() {

				@Override
				protected void success(ResponseDataItem<UserBean> data) {
					UserBean userdata = data.getData();
					saveUserLocal(c, userdata);
					refreshUserUI(userdata);
					ucb.getUserSuccess(userdata);
				}

				@Override
				protected void error(int code, String str) {
					Toast.makeText(c, "获取用户信息失败", Toast.LENGTH_SHORT).show();
					ucb.getUserSuccess(null);
				}
			});
	}
	/**
	 * 通知更新
	 * @param userbean
	 */
	public void refreshUserUI(UserBean userbean){
		EventBus.getDefault().post(userbean);
	}
	/**
	 * 持久化
	 * @param c
	 * @param ub
	 */
	private void saveUserLocal(Context c,UserBean ub){
		JSONObject userjsonObject = JSONUtil.bean2JSONObject(ub);
		App.getSharedPrefences(c).edit().putString(SP_USER_KEY, userjsonObject.toString()).commit();
	}
	/**
	 * 退出登录
	 */
	public void logout(Context c){
		if(!isLogin(c)) throw new RuntimeException("用户尚未登录");
		App.getSharedPrefences(c).edit().remove(SP_USER_KEY).commit();
		//通知更新界面
		UserBean user=new UserBean();
		user.setLogin(false);
		EventBus.getDefault().post(user);
	}
	/**
	 * 
	 *登录
	 */
	public void login(final Context c,String username,String password){
		userServerApi.login(c,username, new Md5Util().getMD5ofStr(password))
		.observeOn(AndroidSchedulers.mainThread())
		.subscribeOn(Schedulers.io())
		.subscribe(new ApiCallBack<ResponseDataItem<UserBean>>() {

			@Override
			protected void success(ResponseDataItem<UserBean> data) {
				UserBean ubn=data.getData();
				saveUserLocal(c, ubn);
				//通知更新界面
				refreshUserUI(ubn);
			}

			@Override
			protected void error(int code, String str) {
				Toast.makeText(c, "登录失败", Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	public interface UserCallBack{
		void getUserSuccess(UserBean loginUser);
	}
	public interface UserServerApi{
		@POST("/android.php/")
		Observable<ResponseDataItem<UserBean>> getUser(@Part("uid") String uid);
		@Multipart
		@POST("/android.php/")
		Observable<ResponseDataItem<UserBean>> login(Context c,@Part("username") String uid,@Part("password") String password);
	}
	public static UserServerApi userServerApi=HttpManager.getRetrofit().create(UserServerApi.class);

}
