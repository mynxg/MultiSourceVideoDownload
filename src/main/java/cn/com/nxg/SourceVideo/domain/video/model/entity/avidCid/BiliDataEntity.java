package cn.com.nxg.SourceVideo.domain.video.model.entity.avidCid;

import lombok.Data;

import java.util.List;

/**
 * @author keney
 * @title BiliDataEntity
 * @createTime 2024/11/19 17:02
 * @description
 */
@Data
public class BiliDataEntity {
    private Integer aid;

    private String bvid;

    private boolean allow_bp;

    private boolean no_share;

    private Integer cid;

    private Integer max_limit;

    private Integer page_no;

    private boolean has_next;

    private IpInfo ip_info;

    private Integer login_mid;

    private String login_mid_hash;

    private boolean is_owner;

    private String name;

    private String permission;

    private LevelInfo level_info;

    private Vip vip;

    private Integer answer_status;

    private Integer block_time;

    private String role;

    private Integer last_play_time;

    private Integer last_play_cid;

    private Integer now_time;

    private Integer online_count;

    private boolean need_login_subtitle;

    private Subtitle subtitle;

    private List<String> view_points;

    private String preview_toast;

    private Options options;

    private List<String> guide_attention;

    private List<String> jump_card;

    private List<String> operation_card;

    private OnlineSwitch online_switch;

    private Fawkes fawkes;

    private ShowSwitch show_switch;

    private String bgm_info;

    private boolean toast_block;

    private boolean is_upower_exclusive;

    private boolean is_upower_play;

    private boolean is_ugc_pay_preview;

    private ElecHighLevel elec_highLevel;

    private boolean disable_show_up_info;
}
