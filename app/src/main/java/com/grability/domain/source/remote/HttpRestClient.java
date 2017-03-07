package com.grability.domain.source.remote;

import com.grability.domain.entity.Theme;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by rogerp91 on 19/01/17.
 */

public interface HttpRestClient {

    public static String BASE_URL = "https://www.reddit.com/";

    @Headers("ContentType: application/json")
    @GET("reddits.json")
    Call<Theme> performTheme();


}