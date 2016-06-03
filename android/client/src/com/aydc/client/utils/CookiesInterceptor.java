package com.aydc.client.utils;

import java.io.IOException;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Interceptor.Chain;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import android.content.Context;

/**
 * 头信息拦截器
 *
 */
public class CookiesInterceptor implements Interceptor{
    private Context context;

    public CookiesInterceptor(Context context) {
        this.context = context;
    }
    //重写拦截方法
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String cookies = CookieUtil.getCookies(context);
        Request compressedRequest;
        if(cookies.length()>0){
            compressedRequest = request.newBuilder()
//                  .header("cookie", CookieUtil.getCookies(context))
                  .addHeader("Cookie", cookies)
                  .build();
        }else{
            compressedRequest = request.newBuilder().build();
        }

        
        Response response = chain.proceed(compressedRequest);
        CookieUtil.saveCookies(response.headers(), context);
        return response;
    }

}
