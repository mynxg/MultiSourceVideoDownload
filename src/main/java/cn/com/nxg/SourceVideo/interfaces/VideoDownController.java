package cn.com.nxg.SourceVideo.interfaces;

import cn.com.nxg.SourceVideo.domain.video.service.IVideoApiService;
import cn.com.nxg.SourceVideo.infrastructure.common.VideoInfoResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author keney
 * @title VideoDownController
 * @createTime 2024/11/19 23:04
 * @description 视频下载接口
 */
@RequestMapping("/api/${app.config.api-version}/video/")
public class VideoDownController {

    @Resource
    private IVideoApiService videoApiService;

    /**
     * 1.bili接口获取，先截取url链接中的bv，再根据bv获取avid和cid，再根据avid和cid请求下载地址接口，获取视频地址
     */
    @RequestMapping(value = "/parser_url",method = RequestMethod.GET)
    public VideoInfoResponse getAvByUrl(@RequestParam("url") String url) {
        //判断url是否符合网址格式要求
        if (!isValidUrl(url)){
            return VideoInfoResponse.builder().code(400).message("url格式不正确").build();
        }

        return videoApiService.getOriginalVideoUrl(url);
    }

    /**
     * 判断url是否合法
     * @param url
     * @return
     */
    private boolean isValidUrl(String url) {
        String urlPattern = "^(https?|ftp)://[\\w.-]+(?:\\.[\\w\\.-]+)+[/\\w\\.-]*$";
        return url != null && url.matches(urlPattern);
    }
}
