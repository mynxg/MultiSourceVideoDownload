package cn.com.nxg.SourceVideo.infrastructure.config;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author keney
 * @title CookieInterceptor
 * @createTime 2024/11/21 23:56
 * @description
 */
public class CookieInterceptor  implements Interceptor {
    private String cookie;

    public CookieInterceptor(String cookie) {
        this.cookie = cookie;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request newRequest = originalRequest.newBuilder()
                .addHeader("Cookie", cookie)
                .build();
        return chain.proceed(newRequest);
    }
}
