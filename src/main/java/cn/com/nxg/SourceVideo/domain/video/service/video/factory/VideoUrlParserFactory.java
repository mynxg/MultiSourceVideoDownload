package cn.com.nxg.SourceVideo.domain.video.service.video.factory;

import cn.com.nxg.SourceVideo.domain.video.service.video.IPlatformVideoUrlParser;
import org.springframework.stereotype.Service;

/**
 * @author keney
 * @title VideoUrlParserFactory
 * @createTime 2024/11/19 18:37
 * @description
 */
@Service
public class VideoUrlParserFactory extends VideoUrlConfig{

    public IPlatformVideoUrlParser getVideoUrlParserService(Integer videoType){
        return videoUrlParserMap.get(videoType);
    };

}
