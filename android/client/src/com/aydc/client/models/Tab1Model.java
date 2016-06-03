package com.aydc.client.models;

import retrofit.http.POST;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import com.aydc.client.entity.ResponseDataItem;
import com.aydc.client.entity.Tab1Bean;
import com.aydc.client.utils.ApiCallBack;
import com.aydc.client.utils.HttpManager;

public class Tab1Model {

	public static Tab1Api tab1Api=HttpManager.getRetrofit().create(Tab1Api.class);
	

	
	//首次、刷新
	public void firstQuery(final RespBack rb){
		tab1Api.getStroe()
		.subscribeOn(Schedulers.io())
		.observeOn(AndroidSchedulers.mainThread())
		.subscribe(new ApiCallBack<ResponseDataItem<Tab1Bean>>() {

			@Override
			protected void success(ResponseDataItem<Tab1Bean> data) {
				rb.complete(data.getData());
			}

			@Override
			protected void error(int code, String str) {
//				Toast.makeText(mContext, "网络异常", Toast.LENGTH_SHORT).show();
			}
			
		});
		
	}
	//分页
	public void nextQuery(){
		
	}

	//成功回调
	public interface RespBack{
		public void complete(Tab1Bean tab1bean);
	}
	
	public interface Tab1Api{
		@POST("/android.php/")
		Observable<ResponseDataItem<Tab1Bean>> getStroe();
	}


	

}
