package cn.com.nxg.SourceVideo.domain.video.service;

import cn.com.nxg.SourceVideo.infrastructure.common.VideoInfoResponse;

/**
 * @author keney
 * @title IVideoApiService
 * @createTime 2024/11/19 18:48
 * @description
 */
public interface IVideoApiService {

    /**
     * 获取原始视频地址
     * @param url
     * @return
     */
    VideoInfoResponse getOriginalVideoUrl(String url);
}
