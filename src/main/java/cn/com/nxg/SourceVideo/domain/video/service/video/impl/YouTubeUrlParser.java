package cn.com.nxg.SourceVideo.domain.video.service.video.impl;

import cn.com.nxg.SourceVideo.domain.video.service.IVideoApiService;
import cn.com.nxg.SourceVideo.domain.video.service.video.IPlatformVideoUrlParser;
import cn.com.nxg.SourceVideo.infrastructure.common.VideoInfoResponse;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author keney
 * @title YouTubeUrlParser
 * @createTime 2024/11/19 18:36
 * @description
 */
@Service
public class YouTubeUrlParser implements IPlatformVideoUrlParser {
    @Override
    public String parseVideoId(String url) {
        Pattern pattern = Pattern.compile("v=([^&]+)");
        Matcher matcher = pattern.matcher(url);
        return matcher.find() ? matcher.group(1) : null;
    }

    @Override
    public VideoInfoResponse.VideoInfo getVideoInfo(String bv) {
        return null;
    }
}
