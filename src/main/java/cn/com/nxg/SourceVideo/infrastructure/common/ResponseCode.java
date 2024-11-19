package cn.com.nxg.SourceVideo.infrastructure.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ResponseCode {
    SUCCESS(0000, "成功"),
    UN_ERROR(0001, "未知失败"),
    ;
    private Integer code;
    private String msg;

}
