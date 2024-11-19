package cn.com.nxg.SourceVideo.domain.video.model.entity.videoV2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author keney
 * @title Owner
 * @createTime 2024/11/19 22:29
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
    private Long mid;

    private String name;

    private String face;

}
