package cn.com.nxg.SourceVideo.domain.video.model.entity.videoV2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author keney
 * @title Rights
 * @createTime 2024/11/19 22:29
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rights {
    private int bp;

    private int elec;

    private int download;

    private int movie;

    private int pay;

    private int hd5;

    private int no_reprint;

    private int autoplay;

    private int ugc_pay;

    private int is_cooperation;

    private int ugc_pay_preview;

    private int no_background;

    private int clean_mode;

    private int is_stein_gate;

    private int is_360;

    private int no_share;

    private int arc_pay;

    private int free_watch;
}
