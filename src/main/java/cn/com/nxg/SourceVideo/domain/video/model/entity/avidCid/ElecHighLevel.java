package cn.com.nxg.SourceVideo.domain.video.model.entity.avidCid;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * @author keney
 * @title Elec_high_level
 * @createTime 2024/11/19 17:10
 * @description
 */
@Data
public class ElecHighLevel {
    private int privilege_type;

    private String title;

    private String sub_title;

    private boolean show_button;

    private String button_text;

    private String jump_url;

    private String intro;

    @JSONField(name = "new")
    private boolean is_new;
}
