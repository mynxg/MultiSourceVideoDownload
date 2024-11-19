package cn.com.nxg.SourceVideo.domain.video.service.video.factory;

import cn.com.nxg.SourceVideo.domain.video.model.valobj.PlatformTypeVO;
import cn.com.nxg.SourceVideo.domain.video.service.video.IPlatformVideoUrlParser;
import cn.com.nxg.SourceVideo.domain.video.service.video.impl.BilibiliUrlParser;
import cn.com.nxg.SourceVideo.domain.video.service.video.impl.YouTubeUrlParser;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author keney
 * @title VideoUrlConfig
 * @createTime 2024/11/19 18:44
 * @description
 */
public class VideoUrlConfig {
    /**
     * 不同的视频平台解析器
     */
    protected static final Map<Integer, IPlatformVideoUrlParser> videoUrlParserMap = new HashMap<>();

    @Resource
    private  BilibiliUrlParser bilibiliUrlParser;
    @Resource
    private  YouTubeUrlParser youTubeUrlParser;
    @PostConstruct
    public void init() {
        videoUrlParserMap.put(PlatformTypeVO.BILIBILI.getCode(), bilibiliUrlParser);
        videoUrlParserMap.put(PlatformTypeVO.YOUTUBE.getCode(), youTubeUrlParser);
    }
}
