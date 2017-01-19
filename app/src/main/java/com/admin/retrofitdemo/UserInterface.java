package com.admin.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/8/18 0018.
 */
public interface UserInterface {

    @GET("/s?wd=getResultByKeyword")
    Call<String> getResultByKeyword(@Query("keyword") String keyword);

    @GET("top250")
    Observable<String> getTopMovie(@Query("start") int start,@Query("count") int count);

}
