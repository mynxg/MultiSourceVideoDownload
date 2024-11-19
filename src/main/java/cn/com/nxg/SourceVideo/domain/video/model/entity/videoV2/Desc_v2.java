package cn.com.nxg.SourceVideo.domain.video.model.entity.videoV2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author keney
 * @title Desc_v2
 * @createTime 2024/11/19 22:27
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Desc_v2 {
    private String raw_text;

    private int type;

    private int biz_id;
}
