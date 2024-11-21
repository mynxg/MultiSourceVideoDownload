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
        if (url == null || url.isEmpty()) {
            return false;
        }
        // 正确关闭字符类的正则表达式
        String urlPattern = "^(https?|ftp)://[\\w.-]+(?:\\.[\\w\\.-]+)+([/\\w\\.-]*)*(\\?([\\w\\-._~:/?#\\[\\]@!$&'()*+,;=%]+)*)?$";

        return url.matches(urlPattern);
    }
}
