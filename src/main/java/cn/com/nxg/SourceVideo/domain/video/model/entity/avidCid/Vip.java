package cn.com.nxg.SourceVideo.domain.video.model.entity.avidCid;

import lombok.Data;

/**
 * @author keney
 * @title Vip
 * @createTime 2024/11/19 17:15
 * @description
 */
@Data
public class Vip {
    private int type;

    private int status;

    private int due_date;

    private int vip_pay_type;

    private int theme_type;

    private Label label;

    private int avatar_subscript;

    private String nickname_color;

    private int role;

    private String avatar_subscript_url;

    private int tv_vip_status;

    private int tv_vip_pay_type;

    private int tv_due_date;

    private AvatarIcon avatar_icon;
}
