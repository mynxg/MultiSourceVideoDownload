package cn.com.nxg.SourceVideo.infrastructure.config;

import cn.com.nxg.SourceVideo.domain.video.service.api.IBilibiliApiService;
import cn.com.nxg.SourceVideo.domain.video.service.api.IYutubeApiService;
import cn.com.nxg.SourceVideo.infrastructure.common.Constants;
import com.google.common.cache.Cache;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.annotation.Resource;

/**
 * @author keney
 * @title Retrofit2Config
 * @createTime 2024/11/19 16:36
 * @description
 */
@Configuration
public class Retrofit2Config {
    @Value("${video.api.bilibili-url}")
    private String bilibiliUrl;
    @Value("${video.api.bilibili-login-url}")
    private String biliLoginUrl;

    @Value("${video.api.yutube-url}")
    private String youtubeUrl;

    @Resource
    private Cache<String, String>  biliCookieCache;

    @Bean("bilibiliRetrofit")
    public Retrofit bilibiliRetrofit(){
        //TODO: cookie缓存失效问题,待优化
        String biliCookie = biliCookieCache.getIfPresent(Constants.BILI_COOKIE_KEY+"ip");
        if (biliCookie != null){
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new CookieInterceptor(biliCookie))
                    .build();
            return new Retrofit.Builder()
                    .client(client)
                    .baseUrl(bilibiliUrl)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
        }
        return new Retrofit.Builder()
                .baseUrl(bilibiliUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    @Bean("bilibiliLoginRetrofit")
    public Retrofit bilibiliLoginRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(biliLoginUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    @Bean
    public Retrofit youtubeRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(youtubeUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    /**
     *  bili 接口
     * @param bilibiliRetrofit
     * @return
     */
    @Bean("bilibiliApiService")
    public IBilibiliApiService bilibiliApiService(Retrofit bilibiliRetrofit){
        return bilibiliRetrofit.create(IBilibiliApiService.class);
    }

    /**
     * bili登录接口
     * @param bilibiliLoginRetrofit
     * @return
     */
    @Bean("biliLoginApiService")
    public IBilibiliApiService biliLoginApiService(Retrofit bilibiliLoginRetrofit){
        return bilibiliLoginRetrofit.create(IBilibiliApiService.class);
    }

    @Bean
    public IYutubeApiService iYutubeApiService(Retrofit youtubeRetrofit){
        return youtubeRetrofit.create(IYutubeApiService.class);
    }
}
