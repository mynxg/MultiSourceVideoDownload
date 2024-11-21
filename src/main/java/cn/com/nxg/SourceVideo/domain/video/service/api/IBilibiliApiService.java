package cn.com.nxg.SourceVideo.domain.video.service.api;

import cn.com.nxg.SourceVideo.domain.video.model.entity.videoV2.VideoV2InfoResponseDTO;
import cn.com.nxg.SourceVideo.domain.video.service.api.dto.BiliLoginResponseDTO;
import cn.com.nxg.SourceVideo.domain.video.service.api.dto.BiliQrcodeResponseDTO;
import cn.com.nxg.SourceVideo.domain.video.service.api.dto.BiliVideoInfoResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author keney
 * @title BilibiliApiService
 * @createTime 2024/11/19 21:16
 * @description
 */
public interface IBilibiliApiService {

    /**
     * 获取视频信息
     * "https://api.bilibili.com/x/web-interface/view?bvid=" + bv
     * @param bv
     * @return
     */
    @GET("/x/web-interface/view")
    Call<VideoV2InfoResponseDTO> getBiliVideoAvidAndCid(
            @Query("bvid")String bv
    );

    /**
     * 获取视频播放地址
     * "https://api.bilibili.com/x/player/playurl?avid=" + avid + "&cid=" + cid + "&qn=80&type=mp4&platform=html5&high_quality=1"
     * @param avid
     * @param cid
     * @param qn
     * @param type
     * @param platform
     * @param high_quality
     * @return
     */
    @GET("/x/player/playurl")
    Call<BiliVideoInfoResponseDTO> getBiliVideoUrl(
            @Query("avid")Long avid,
            @Query("cid")Long cid,
            @Query("qn")int qn,
            @Query("type")String type,
            @Query("platform")String platform,
            @Query("high_quality")int high_quality
    );

    /**
     * 获取二维码
     * @return
     */
    @GET("/x/passport-login/web/qrcode/generate")
    Call<BiliQrcodeResponseDTO> getBiliQrcode();

    /**
     * 扫码登录状态（成功）
     * @param qrcode_key  密钥超时为180秒
     * @return
     */
    @GET("/x/passport-login/web/qrcode/poll")
    Call<BiliLoginResponseDTO> getBiliLoginStatus(@Query("qrcode_key")String qrcode_key);
}
