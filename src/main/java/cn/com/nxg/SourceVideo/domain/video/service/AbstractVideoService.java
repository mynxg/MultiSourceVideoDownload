package cn.com.nxg.SourceVideo.domain.video.service;

import cn.com.nxg.SourceVideo.domain.video.model.valobj.PlatformTypeVO;
import cn.com.nxg.SourceVideo.domain.video.service.video.IPlatformVideoUrlParser;
import cn.com.nxg.SourceVideo.domain.video.service.video.factory.VideoUrlParserFactory;
import cn.com.nxg.SourceVideo.infrastructure.common.ResponseCode;
import cn.com.nxg.SourceVideo.infrastructure.common.VideoInfoResponse;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * @author keney
 * @title AbstractVideoService
 * @createTime 2024/11/19 19:01
 * @description
 */
@Slf4j
public abstract class AbstractVideoService implements IVideoApiService {

    @Resource
    private VideoUrlParserFactory videoUrlParserFactory;


    @Override
    public VideoInfoResponse getOriginalVideoUrl(String url) {
        Integer videoUrlPlatformType = getVideoUrlPlatformType(url);

        //1.解析url，拿到平台视频id
        IPlatformVideoUrlParser videoUrlParserService = videoUrlParserFactory.getVideoUrlParserService(videoUrlPlatformType);
        String name = videoUrlParserService.getClass().getName();
        log.info("videoUrlParserService:{}", name);
        String videoId = videoUrlParserService.parseVideoId(url);
        log.info("videoId:{}", videoId);

        //2.根据平台视频id，获取 aid和cid以及视频信息
        VideoInfoResponse.VideoInfo videoInfo = videoUrlParserService.getVideoInfo(videoId);

        if (PlatformTypeVO.BILIBILI.getCode().equals(videoUrlPlatformType)){
            return getBiliVideoInfo(videoInfo);
        }

        //3. 获取视频源信息
        return VideoInfoResponse.builder()
                .code(ResponseCode.SUCCESS.getCode())
                .message(ResponseCode.SUCCESS.getMsg())
                .data(videoInfo)
                .build();
    }

    /**
     * 获取视频源信息
     *
     * @param videoInfo
     * @return
     */
    protected abstract VideoInfoResponse getBiliVideoInfo(VideoInfoResponse.VideoInfo videoInfo);

    /**
     * 获取视频平台类型
     *
     * @param videoUrl
     * @return
     */
    protected abstract Integer getVideoUrlPlatformType(String videoUrl);
}
