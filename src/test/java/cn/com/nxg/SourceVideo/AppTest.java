package cn.com.nxg.SourceVideo;

import cn.com.nxg.SourceVideo.domain.video.service.IVideoApiService;
import cn.com.nxg.SourceVideo.domain.video.service.api.IBilibiliApiService;
import cn.com.nxg.SourceVideo.domain.video.service.api.dto.BiliLoginResponseDTO;
import cn.com.nxg.SourceVideo.domain.video.service.api.dto.BiliQrcodeResponseDTO;
import cn.com.nxg.SourceVideo.domain.video.service.api.dto.BiliResponseDTO;
import cn.com.nxg.SourceVideo.infrastructure.common.VideoInfoResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.Cache;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import retrofit2.Call;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@Slf4j
public class AppTest {

    @Resource
    private IVideoApiService videoApiService;

    @Test
    public void test_service() {
        String url = "https://www.bilibili.com/video/BV1DnUKYYEkj/?vd_source=83e20cd531608ce070908ea29997e648";
        VideoInfoResponse originalVideoUrl = videoApiService.getOriginalVideoUrl(url);
        log.info("结果：{}", JSON.toJSON(originalVideoUrl));
    }

    @Resource
    private Cache<String,Integer> biliCookieCache;
    @Test
    public void test_google_cache_01() {
        biliCookieCache.put("test",1);
        Integer test = biliCookieCache.getIfPresent("test");
        log.info("结果：{}", test);
    }

    @Resource
    private IBilibiliApiService biliLoginApiService;
    @Test
    public void test_google_cache_02() {
        Call<BiliQrcodeResponseDTO> biliQrcode = biliLoginApiService.getBiliQrcode();
        try {
            BiliQrcodeResponseDTO body = biliQrcode.execute().body();
            log.info("结果：{}", JSON.toJSON(body));
            Call<BiliLoginResponseDTO> biliLoginStatus = biliLoginApiService.getBiliLoginStatus(body.getData().getQrcode_key());
            BiliLoginResponseDTO body1 = biliLoginStatus.execute().body();
            log.info("结果：{}", JSON.toJSON(body1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01() {
        System.out.println("hello video!");
        String url = "https://www.bilibili.com/video/BV1DnUKYYEkj/?vd_source=83e20cd531608ce070908ea29997e648";
        //如果url中包含www.bilibili.com并且路径中有video/，则截取路径，/video/  以及/?之间的字符，否则直接返回

        if (url.contains("www.bilibili.com") && url.contains("/video/")) {
            // 定义正则表达式来匹配BV号
            Pattern pattern = Pattern.compile("/video/(BV\\w+)");
            Matcher matcher = pattern.matcher(url);

            url = "https://api.bilibili.com/x/web-interface/view?bvid=" + url.substring(url.indexOf("/video/") + 7, url.indexOf("/?"));
        } else {
            return;
        }

        String body = HttpUtil.createGet(url).execute().body();
        //解析body，并转换为BiliResponseDTO
        JSONObject jsonObject = JSON.parseObject(body);
        BiliResponseDTO biliResponseDTO = jsonObject.toJavaObject(BiliResponseDTO.class);
        System.out.println(biliResponseDTO);
    }

    @Test
    public void test_mobile() {
        String url = "https://b23.tv/Cq6Qa4p";
        String body = HttpUtil.createGet(url).execute().body();
        log.info("body:{}", body);
    }

    //根据bv获取详细信息，其中aid和cid
    @Test
    public void test_video_info_aid_cid() {
        String bvid = "BV1DnUKYYEkj";
        String body = HttpUtil.createGet("https://api.bilibili.com/x/web-interface/view?bvid=" + bvid).execute().body();
        log.info("body:{}", body);
    }

    //根据avid和cid请求下载地址接口，获取视频地址
    @Test
    public void test_video_info_url() {
        String aid = "BV1DnUKYYEkj";
        String cid = "140";
        String body = HttpUtil.createGet("https://api.bilibili.com/x/player/playurl?avid=" + aid + "&cid=" + cid + "&qn=80&type=mp4&platform=html5&high_quality=1").execute().body();
        log.info("body:{}", body);
    }
}
