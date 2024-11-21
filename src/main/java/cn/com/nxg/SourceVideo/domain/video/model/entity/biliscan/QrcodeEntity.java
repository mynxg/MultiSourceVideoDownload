package cn.com.nxg.SourceVideo.domain.video.model.entity.biliscan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author keney
 * @title QrcodeEntity
 * @createTime 2024/11/21 22:59
 * @description bilibili  扫码登录获取二维码实体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QrcodeEntity {
    /**
     * 二维码内容 (登录页面 url)
     */
    private String url;
    /**
     * 扫码登录秘钥
     */
    private String qrcode_key;
}
