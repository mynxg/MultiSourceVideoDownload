package cn.com.nxg.SourceVideo.domain.video.model.entity.avidCid;

import lombok.Data;

/**
 * @author keney
 * @title Level_info
 * @createTime 2024/11/19 17:13
 * @description
 */
@Data
public class LevelInfo {
    private int current_level;

    private int current_min;

    private int current_exp;

    private int next_exp;

    private int level_up;
}
