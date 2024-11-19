package cn.com.nxg.SourceVideo.domain.video.service;

import cn.com.nxg.SourceVideo.domain.video.model.valobj.PlatformTypeVO;
import cn.com.nxg.SourceVideo.domain.video.service.api.IBilibiliApiService;
import cn.com.nxg.SourceVideo.domain.video.service.api.dto.BiliVideoInfoResponseDTO;
import cn.com.nxg.SourceVideo.infrastructure.common.ResponseCode;
import cn.com.nxg.SourceVideo.infrastructure.common.VideoInfoResponse;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import javax.annotation.Resource;

/**
 * @author keney
 * @title VideoApiService
 * @createTime 2024/11/19 19:02
 * @description
 */
@Service
public class VideoApiService extends AbstractVideoService{

    @Resource
    private IBilibiliApiService bilibiliApiService;

    @Override
    public VideoInfoResponse getOriginalVideoUrl(String url) {
        return super.getOriginalVideoUrl(url);
    }

    @Override
    protected VideoInfoResponse getVideoInfo(VideoInfoResponse.VideoInfo videoInfo) {
        try {
            //"https://api.bilibili.com/x/player/playurl?avid=" + avid + "&cid=" + cid + "&qn=80&type=mp4&platform=html5&high_quality=1"
            Call<BiliVideoInfoResponseDTO> biliVideoUrl = bilibiliApiService.getBiliVideoUrl(videoInfo.getAid(), videoInfo.getCid(), 80, "mp4", "html5", 1);
            BiliVideoInfoResponseDTO body = biliVideoUrl.execute().body();

            //TODO:待优化，调用接口是否查询成功或失败处理

            return VideoInfoResponse.builder()
                    .code(ResponseCode.SUCCESS.getCode())
                    .message(ResponseCode.SUCCESS.getMsg())
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
            throw new RuntimeException(e);
        }
    }

    private static final String bilibili_url = "bilibili.com";
    private static final String bilibili_mobile_url = "b23.tv";
    private static final String youtube_url = "youtube.com";

    /**
     * 获取视频平台类型
     * @param videoUrl
     * @return
     */
    @Override
    protected Integer getVideoUrlPlatformType(String videoUrl) {
        Integer videoType = PlatformTypeVO.BILIBILI.getCode();

        //TODO:待优化
        //判断视频URL包含哪个平台标识
        if (videoUrl.contains(bilibili_url) || videoUrl.contains(bilibili_mobile_url)) {
            videoType = PlatformTypeVO.BILIBILI.getCode();
        } else if (videoUrl.contains(youtube_url)) {
            videoType = PlatformTypeVO.YOUTUBE.getCode();
        }

        return videoType;
    }
}
