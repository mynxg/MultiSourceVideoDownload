package cn.com.nxg.SourceVideo.infrastructure.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author keney
 * @title VideoInfoResponse
 * @createTime 2024/11/19 21:58
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoInfoResponse {
    private Integer  code;

    private String message;
    private VideoInfo data;


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VideoInfo{
        private String url;
        private String title;
        private String cover;
        private String desc;
        private String duration;
        private String bvid;
        private Long aid;
        private Long cid;
        private String platform;
    }
}
