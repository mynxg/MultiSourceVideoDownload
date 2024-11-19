package cn.com.nxg.SourceVideo.domain.video.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author keney
 * @title VideoTypeVO
 * @createTime 2024/11/19 18:51
 * @description 不同平台的视频类型
 */
@Getter
@AllArgsConstructor
public enum PlatformTypeVO {
    //bilibili，哔哩哔哩，yutube油管、爱奇艺
    BILIBILI(1,"bilibili"),
    YOUTUBE(2,"youtube" ),
    ;

    private final Integer code;
    private final String desc;
    public static PlatformTypeVO get(Integer  code) {
        switch (code) {
            case 1:
                return BILIBILI;
            case 2:
                return YOUTUBE;
            default:
                return BILIBILI;
        }
    }
}
