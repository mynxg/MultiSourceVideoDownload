package cn.com.nxg.SourceVideo.domain.video.model.entity.videoV2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author keney
 * @title Argue_info
 * @createTime 2024/11/19 22:26
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Argue_info {
    private String argue_msg;

    private int argue_type;

    private String argue_link;
}
