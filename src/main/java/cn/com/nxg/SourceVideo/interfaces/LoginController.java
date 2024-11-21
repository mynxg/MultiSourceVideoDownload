package cn.com.nxg.SourceVideo.interfaces;

import cn.com.nxg.SourceVideo.domain.video.service.IVideoApiService;
import cn.com.nxg.SourceVideo.domain.video.service.api.dto.BiliLoginResponseDTO;
import cn.com.nxg.SourceVideo.domain.video.service.api.dto.BiliQrcodeResponseDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author keney
 * @title LoginController
 * @createTime 2024/11/21 23:35
 * @description
 */
@RestController
@RequestMapping("/api/${app.config.api-version}/login/")
public class LoginController {

    @Resource
    private IVideoApiService videoApiService;

    @RequestMapping("get_qrcode")
    public BiliQrcodeResponseDTO getBiliQrcode() {
        return videoApiService.getBiliQrcode();
    }

    @RequestMapping("get_login_status")
    public BiliLoginResponseDTO getBiliLoginStatus(String qrcode_key) {
        if (qrcode_key == null){
            return BiliLoginResponseDTO.builder()
                    .code(400)
                    .message("参数错误")
                    .build();
        }
        return videoApiService.getBiliLoginStatus(qrcode_key);
    }
}
