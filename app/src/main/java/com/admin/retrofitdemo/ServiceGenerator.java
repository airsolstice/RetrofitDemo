package com.admin.retrofitdemo;

import com.admin.retrofitdemo.converter.string.StringConverterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by Administrator on 2016/8/18 0018.
 */
public class ServiceGenerator {

    public static final String API_BASE_URL = "http://www.baidu.com/";
    public static final String API_BASE_URL1 = "http://api.douban.com/v2/movie/";


    public static OkHttpClient sOkHttpClient = new OkHttpClient();

    private static Retrofit.Builder mRxBuilder = new Retrofit.Builder().baseUrl(API_BASE_URL1)
            .addConverterFactory(StringConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

    public static <S> S createService2(Class<S> serviceClass){
        Retrofit retrofit = mRxBuilder.build();
        return retrofit.create(serviceClass);
    }

    private static Retrofit.Builder mSimpleBuilder = new Retrofit.Builder()
            .baseUrl(API_BASE_URL).addConverterFactory(StringConverterFactory.create());

    public static <S> S createService1(Class<S> serviceClass) {
        Retrofit retrofit = mSimpleBuilder.client(sOkHttpClient).build();
        return retrofit.create(serviceClass);
    }


}
