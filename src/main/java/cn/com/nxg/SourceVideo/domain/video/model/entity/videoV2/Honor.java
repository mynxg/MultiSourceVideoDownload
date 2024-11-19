package cn.com.nxg.SourceVideo.domain.video.model.entity.videoV2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author keney
 * @title Honor
 * @createTime 2024/11/19 22:28
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Honor {
    private Long aid;

    private int type;

    private String desc;

    private Long weekly_recommend_num;
}
