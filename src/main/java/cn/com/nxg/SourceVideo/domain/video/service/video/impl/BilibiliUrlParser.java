package cn.com.nxg.SourceVideo.domain.video.service.video.impl;

import cn.com.nxg.SourceVideo.domain.video.model.entity.videoV2.VideoV2InfoResponseDTO;
import cn.com.nxg.SourceVideo.domain.video.service.api.IBilibiliApiService;
import cn.com.nxg.SourceVideo.domain.video.service.api.dto.BiliResponseDTO;
import cn.com.nxg.SourceVideo.domain.video.service.api.dto.BiliVideoInfoResponseDTO;
import cn.com.nxg.SourceVideo.domain.video.service.video.IPlatformVideoUrlParser;
import cn.com.nxg.SourceVideo.infrastructure.common.VideoInfoResponse;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author keney
 * @title BilibiliUrlParser
 * @createTime 2024/11/19 18:35
 * @description
 */
@Service
public class BilibiliUrlParser implements IPlatformVideoUrlParser {
    // 正常的 bilibili 视频 URL 模式
    private static final Pattern NORMAL_PATTERN = Pattern.compile("/video/(\\w+)");
    // 短链接的 URL 前缀
    private static final String SHORT_URL_PREFIX = "https://b23.tv/";

    @Resource
    private IBilibiliApiService bilibiliApiService;

    @Override
    public String parseVideoId(String url) {
        if (url.startsWith(SHORT_URL_PREFIX)) {
            // 如果是短链接，先进行重定向解析
            url = resolveShortUrl(url);
        }
        return extractVideoIdFromNormalUrl(url);
    }

    /**
     * 从正常的 bilibili URL 中提取视频 ID
     *
     * @param url 正常 bilibili 视频 URL
     * @return 视频 ID 或 null
     */
    private String extractVideoIdFromNormalUrl(String url) {
        Matcher matcher = NORMAL_PATTERN.matcher(url);
        return matcher.find() ? matcher.group(1) : null;
    }

    /**
     * 解析 b23.tv 短链接，获取原始 URL（可以用 HTTP 客户端发送请求并获取重定向后的 URL）
     *
     * @param videoUrl b23.tv 短链接
     * @return 原始 URL
     */
    private String resolveShortUrl(String videoUrl) {
        // 判断链接是否以 "【" 开头
        if (videoUrl.startsWith("【")) {
            // 使用正则表达式分割，提取"】"后面的部分
            String[] parts = videoUrl.split("】 ", 2);
            if (parts.length > 1) {
                return parts[1];  // 返回实际的URL部分
            }
        }
        return videoUrl;  // 如果不符合条件则返回原始链接
    }

    @Override
    public VideoInfoResponse.VideoInfo getVideoInfo(String bvid) {
        //HttpUtil.createGet("https://api.bilibili.com/x/web-interface/view?bvid=" + bvid).execute().body()
        Call<VideoV2InfoResponseDTO> biliVideoAvidAndCid = bilibiliApiService.getBiliVideoAvidAndCid(bvid);
        try {
            VideoV2InfoResponseDTO body = biliVideoAvidAndCid.execute().body();
            return VideoInfoResponse.VideoInfo.builder()
                    .desc(body.getData().getDesc())
                    .title(body.getData().getTitle())
                    .cover(body.getData().getPic())
                    .aid(body.getData().getAid())
                    .cid(body.getData().getCid())
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public VideoInfoResponse getBiliVideoInfo(VideoInfoResponse.VideoInfo  videoInfo){
        try {
            //"https://api.bilibili.com/x/player/playurl?avid=" + avid + "&cid=" + cid + "&qn=80&type=mp4&platform=html5&high_quality=1"
            Call<BiliVideoInfoResponseDTO> biliVideoUrl = bilibiliApiService.getBiliVideoUrl(videoInfo.getAid(), videoInfo.getCid(), 80, "mp4", "html5", 1);
            BiliVideoInfoResponseDTO body = biliVideoUrl.execute().body();

            return VideoInfoResponse.builder()
                    .code(200)
                    .message("success")
                    .data(VideoInfoResponse.VideoInfo.builder()
                            .url(body.getData().getDurl().get(0).getUrl())
                            .title(videoInfo.getTitle())
                            .cover(videoInfo.getCover())
                            .desc(videoInfo.getDesc())
                            .aid(videoInfo.getAid())
                            .cid(videoInfo.getCid())
                            .build()
                    ).build();
        }catch (Exception e){
            return null;
        }
    }
}
