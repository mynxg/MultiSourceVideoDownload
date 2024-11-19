package cn.com.nxg.SourceVideo.domain.video.service.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author keney
 * @title BiliVideoInfoResponseDTO
 * @createTime 2024/11/19 21:32
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BiliVideoInfoResponseDTO {
    private int code;

    private String message;

    private int ttl;

    private VideoInfoData data;


    /**
     * @author keney
     * @title Durl
     * @createTime 2024/11/19 21:28
     * @description
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Durl {
        private int order;

        private int length;

        private int size;

        private String ahead;

        private String vhead;

        private String url;

        private String backup_url;
    }

    /**
     * @author keney
     * @title Support_formats
     * @createTime 2024/11/19 21:31
     * @description
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Support_formats {
        private int quality;

        private String format;

        private String new_description;

        private String display_desc;

        private String superscript;

        private String codecs;
    }

    /**
     * @author keney
     * @title VideoInfoData
     * @createTime 2024/11/19 21:30
     * @description
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VideoInfoData {
        private String from;

        private String result;

        private String message;

        private int quality;

        private String format;

        private int timelength;

        private String accept_format;

        private List<String> accept_description;

        private List<Integer> accept_quality;

        private Long video_codecid;

        private String seek_param;

        private String seek_type;

        private List<Durl> durl;

        private List<Support_formats> support_formats;

        private String high_format;

        private Long last_play_time;

        private Long last_play_cid;

        private String view_info;
    }
}
