package cn.com.nxg.SourceVideo.domain.video.model.entity.videoV2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author keney
 * @title VideoV2InfoResponseDTO
 * @createTime 2024/11/19 22:27
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoV2Info {
    private String bvid;

    private Long aid;

    private Long videos;

    private Long tid;

    private String tname;

    private int copyright;

    private String pic;

    private String title;

    private int pubdate;

    private int ctime;

    private String desc;

    private List<Desc_v2> desc_v2;

    private int state;

    private Long duration;

    private Rights rights;

    private Owner owner;

    private Stat stat;

    private Argue_info argue_info;

    private String dynamic;

    private Long cid;

    private Dimension dimension;

    private String premiere;

    private int teenage_mode;

    private boolean is_chargeable_season;

    private boolean is_story;

    private boolean is_upower_exclusive;

    private boolean is_upower_play;

    private boolean is_upower_preview;

    private int enable_vt;

    private String vt_display;

    private boolean no_cache;

    private List<Pages> pages;

    private Subtitle subtitle;

    private boolean is_season_display;

    private User_garb user_garb;

    private Honor_reply honor_reply;

    private String like_icon;

    private boolean need_jump_bv;

    private boolean disable_show_up_info;

    private int is_story_play;

    private boolean is_view_self;
}
