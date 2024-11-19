package cn.com.nxg.SourceVideo.infrastructure.config;

import cn.com.nxg.SourceVideo.domain.video.service.api.IBilibiliApiService;
import cn.com.nxg.SourceVideo.domain.video.service.api.IYutubeApiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

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
    @Value("${video.api.yutube-url}")
    private String youtubeUrl;

    @Bean
    public Retrofit bilibiliRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(bilibiliUrl)
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
     * 对 IBiliApiService 接口实例化一下
     * @param bilibiliRetrofit
     * @return
     */
    @Bean
    public IBilibiliApiService IBiliApiService(Retrofit bilibiliRetrofit){
        return bilibiliRetrofit.create(IBilibiliApiService.class);
    }

    @Bean
    public IYutubeApiService iYutubeApiService(Retrofit youtubeRetrofit){
        return youtubeRetrofit.create(IYutubeApiService.class);
    }
}
