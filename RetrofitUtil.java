package coschat.wecanstudio.coschat.utils;

import java.lang.reflect.Field;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 利用拦截器+反射为okhttp设置通用header Content-Type="application/json"
 * Created by jss on 2016/11/23.
 */

public class RetrofitUtil {
    public static OkHttpClient genericClient() {
        OkHttpClient httpClient = new OkHttpClient();
        httpClient.interceptors().add(chain -> {
            Request request = chain.request();
            MediaType mediaType = request.body().contentType();
            try {
                Field field = mediaType.getClass().getDeclaredField("mediaType");
                field.setAccessible(true);
                field.set(mediaType, "application/json");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return chain.proceed(request);
        });
        return httpClient;
    }
}