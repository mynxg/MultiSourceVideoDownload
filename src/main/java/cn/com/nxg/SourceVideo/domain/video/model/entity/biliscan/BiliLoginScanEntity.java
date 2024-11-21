package cn.com.nxg.SourceVideo.domain.video.model.entity.biliscan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author keney
 * @title BiliLoginScanEntity
 * @createTime 2024/11/21 23:05
 * @description 扫码登录
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BiliLoginScanEntity {
    /**
     * 游戏分站跨域登录 url	未登录为空
     */
    private String url;
    /**
     * 刷新refresh_token	未登录为空
     */
    private String refresh_token;
    /**
     * 登录时间	未登录为0
     * 时间戳 单位为毫秒
     */
    private Long timestamp;
    /**
     * 0：扫码登录成功
     * 86038：二维码已失效
     * 86090：二维码已扫码未确认
     * 86101：未扫码
     */
    private Integer code;
    private String message;
}
