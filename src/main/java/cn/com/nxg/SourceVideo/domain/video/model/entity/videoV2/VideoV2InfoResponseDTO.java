package cn.com.nxg.SourceVideo.domain.video.model.entity.videoV2;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author keney
 * @title VideoV2InfoResponseDTO
 * @createTime 2024/11/19 22:32
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoV2InfoResponseDTO {
    private int code;

    private String message;

    private int ttl;

    private VideoV2Info data;
}
