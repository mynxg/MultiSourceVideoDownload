package cn.com.nxg.SourceVideo.domain.video.model.entity.videoV2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author keney
 * @title Honor_reply
 * @createTime 2024/11/19 22:28
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Honor_reply {
    private List<Honor> honor;
}
