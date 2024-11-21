package cn.com.nxg.SourceVideo.domain.video.service;

import cn.com.nxg.SourceVideo.domain.video.service.api.dto.BiliLoginResponseDTO;
import cn.com.nxg.SourceVideo.domain.video.service.api.dto.BiliQrcodeResponseDTO;
import cn.com.nxg.SourceVideo.infrastructure.common.VideoInfoResponse;
import lombok.extern.slf4j.Slf4j;

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

    /**
     * 获取b站登录二维码
     * @return
     */
    BiliQrcodeResponseDTO getBiliQrcode();

    /**
     * 检查是否登录（是否扫码成功）
     * @param qrcode_key
     * @return
     */
    BiliLoginResponseDTO getBiliLoginStatus(String qrcode_key);
}
