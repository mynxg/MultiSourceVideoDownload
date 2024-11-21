package cn.com.nxg.SourceVideo.domain.video.service.api.dto;

import cn.com.nxg.SourceVideo.domain.video.model.entity.biliscan.BiliLoginScanEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author keney
 * @title BiliLoginResponseDTO
 * @createTime 2024/11/21 23:03
 * @description 扫码登录成功返回数据
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BiliLoginResponseDTO {
    private Integer code;

    private String message;

    private Integer ttl;

    private BiliLoginScanEntity data;

}
