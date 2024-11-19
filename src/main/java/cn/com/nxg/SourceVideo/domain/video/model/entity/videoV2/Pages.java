package cn.com.nxg.SourceVideo.domain.video.model.entity.videoV2;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author keney
 * @title Pages
 * @createTime 2024/11/19 22:29
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pages {
    private Long cid;

    private Long page;

    private String from;

    private String part;

    private Long duration;

    private String vid;

    private String weblink;

    private Dimension dimension;

    private String first_frame;

}
