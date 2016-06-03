package com.aydc.client.apis;

import java.util.Map;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

import com.aydc.client.entity.ResponseDataItem;
import com.aydc.client.entity.ResponseDataList;
import com.aydc.client.entity.StoreBean;
import com.aydc.client.entity.UserBean;



public interface StoreApi {
	@GET("/users/{username}")
	Call<ResponseDataItem<StoreBean>> getUser(@Path("username") String username);
	@GET("/group/{id}/users")
	Call<ResponseDataList<StoreBean>> groupList(@Path("id") int groupId, @Query("sort") String sort);
	@POST("/users/new")
	Call<ResponseDataItem<StoreBean>> createUser(@Body StoreBean store);
	
	@Multipart
	@POST("/some/endpoint")
	Call<StoreBean> someEndpoint(@Part("name1") String name1, @Part("name2") String name2);
	
	@FormUrlEncoded
	@POST("/some/endpoint")
	Call<StoreBean> someEndpoint(@FieldMap Map<String, String> names);
	
	@POST("/android.php/aybus/login/")
	Observable<ResponseDataItem<UserBean>> tologin();
}
