package cn.com.nxg.SourceVideo.domain.video.service.video;

import cn.com.nxg.SourceVideo.infrastructure.common.VideoInfoResponse;

/**
 * @author keney
 * @title IPlatformVideoUrlParser
 * @createTime 2024/11/19 19:01
 * @description
 */
public interface IPlatformVideoUrlParser {

    /**
     * 解析视频ID
     * @param url
     * @return
     */
    String parseVideoId(String url);

    /**
     * 根据bv获取详细信息，其中avid和cid
     * @param bvid
     * @return
     */
    VideoInfoResponse.VideoInfo getVideoInfo(String bvid);
}
