package cn.com.nxg.SourceVideo.domain.video.model.entity.videoV2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author keney
 * @title Stat
 * @createTime 2024/11/19 22:30
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Stat {
    private Long aid;

    private Long view;

    private Long danmaku;

    private Long reply;

    private Long favorite;

    private Long coin;

    private Long share;

    private Long now_rank;

    private Long his_rank;

    private Long like;

    private Long dislike;

    private String evaluation;

    private Long vt;
}
