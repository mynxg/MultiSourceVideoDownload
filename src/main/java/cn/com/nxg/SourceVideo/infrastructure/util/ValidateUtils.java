package cn.com.nxg.SourceVideo.infrastructure.util;

/**
 * @author keney
 * @title ValidateUtils
 * @createTime 2024/11/20 0:40
 * @description 校验工具类
 */
public class ValidateUtils {
    /**
     * 判断url是否合法
     * @param url
     * @return
     */
    public static boolean isValidUrl(String url) {
        String urlPattern = "^(https?|ftp)://[\\w.-]+(?:\\.[\\w\\.-]+)+[/\\w\\.-]*$";
        return url != null && url.matches(urlPattern);
    }
}
