package cn.com.nxg.SourceVideo.domain.video.model.entity.avidCid;

import lombok.Data;

/**
 * @author keney
 * @title Label
 * @createTime 2024/11/19 17:12
 * @description
 */
@Data
public class Label {
    private String path;

    private String text;

    private String label_theme;

    private String text_color;

    private int bg_style;

    private String bg_color;

    private String border_color;

    private boolean use_img_label;

    private String img_label_uri_hans;

    private String img_label_uri_hant;

    private String img_label_uri_hans_static;

    private String img_label_uri_hant_static;
}
