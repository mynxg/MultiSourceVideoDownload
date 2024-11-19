package cn.com.nxg.SourceVideo.domain.video.service.api.dto;

import cn.com.nxg.SourceVideo.domain.video.model.entity.avidCid.BiliDataEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author keney
 * @title BiliResponseDTO
 * @createTime 2024/11/19 16:59
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BiliResponseDTO {
    private Integer code;

    private String message;

    private Integer ttl;

    private BiliDataEntity data;
}
