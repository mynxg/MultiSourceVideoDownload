package cn.com.nxg.SourceVideo.domain.video.service.api.dto;

import cn.com.nxg.SourceVideo.domain.video.model.entity.avidCid.BiliDataEntity;
import cn.com.nxg.SourceVideo.domain.video.model.entity.biliscan.QrcodeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author keney
 * @title BiliQrcodeResponseDTO
 * @createTime 2024/11/21 23:00
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BiliQrcodeResponseDTO {
    private Integer code;

    private String message;

    private Integer ttl;

    private QrcodeEntity data;
}
