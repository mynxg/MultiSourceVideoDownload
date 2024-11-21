package cn.com.nxg.SourceVideo.infrastructure.config;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author keney
 * @title GuavaCacheConfig
 * @createTime 2024/11/21 22:34
 * @description
 */
@Configuration
public class GuavaCacheConfig {

    /**
     * biliCookie缓存
     * @return
     */
    @Bean(name = "biliCookieCache")
    public Cache<String, String> biliCookieCache() {
        return CacheBuilder.newBuilder()
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .build();
    }
}
