package cn.com.nxg.SourceVideo.domain.video.model.entity.videoV2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author keney
 * @title Subtitle
 * @createTime 2024/11/19 22:31
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subtitle {
    private boolean allow_submit;

    private List<String> list;
}
