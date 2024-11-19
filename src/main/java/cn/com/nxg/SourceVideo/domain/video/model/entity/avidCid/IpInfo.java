package cn.com.nxg.SourceVideo.domain.video.model.entity.avidCid;

import lombok.Data;

/**
 * @author keney
 * @title Ip_info
 * @createTime 2024/11/19 17:12
 * @description
 */
@Data
public class IpInfo {
    private String ip;

    private String zone_ip;

    private int zone_id;

    private String country;

    private String province;

    private String city;
}
