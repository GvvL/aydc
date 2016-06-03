package com.aydc.client.models;

import com.aydc.client.entity.FoodBean;
import com.aydc.client.entity.ResponseDataList;
import com.aydc.client.utils.HttpManager;

import retrofit.http.POST;
import retrofit.http.Part;
import rx.Observable;

/**
 * 店铺
 * @author Administrator
 *
 */
public class StoreModel {
	
	
	public interface StoreApi{
		@POST("/android.php/home/store/getAllFoodsByStoreId")
		Observable<ResponseDataList<FoodBean>> getFoods(@Part("storeid") String storeid);
	}
	public static StoreApi storeServerApi=HttpManager.getRetrofit().create(StoreApi.class);

}
