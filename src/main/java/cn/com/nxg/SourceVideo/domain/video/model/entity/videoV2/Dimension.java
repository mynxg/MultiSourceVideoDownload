package cn.com.nxg.SourceVideo.domain.video.model.entity.videoV2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author keney
 * @title Dimension
 * @createTime 2024/11/19 22:28
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dimension {
    private int width;

    private int height;

    private int rotate;
}
