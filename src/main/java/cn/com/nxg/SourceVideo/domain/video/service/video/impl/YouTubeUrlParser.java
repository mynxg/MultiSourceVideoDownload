package cn.com.nxg.SourceVideo.domain.video.service.video.impl;

import cn.com.nxg.SourceVideo.domain.video.service.video.IPlatformVideoUrlParser;
import cn.com.nxg.SourceVideo.infrastructure.common.VideoInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

/**
 * @author keney
 * @title YouTubeUrlParser
 * @createTime 2024/11/19 18:36
 * @description
 */
@Slf4j
@Service
public class YouTubeUrlParser implements IPlatformVideoUrlParser {

    @Value("${yt-dlp.path-windows}")
    private String ytDlpPathWindows;
    @Value("${yt-dlp.path-linux}")
    private String ytDlpPathLinux;

    @Override
    public String parseVideoId(String url) {
        //Pattern pattern = Pattern.compile("v=([^&]+)");
        //Matcher matcher = pattern.matcher(url);
        //return matcher.find() ? matcher.group(1) : null;
        //匹配 这个规则的地址：https://www.youtube.com/watch?v=LLAZUTbc97I

        return url;
    }

    @Override
    public VideoInfoResponse.VideoInfo getVideoInfo(String videoUrl) {
        String ytDlpPath = null;
        try {
            ytDlpPath = getYtDlpPath(); // 获取yt-dlp的临时路径
        } catch (Exception e) {
            e.printStackTrace();
            return VideoInfoResponse.VideoInfo.builder().url(null).build();
        }

        String extractedUrl = null;

        try {
            // 使用yt-dlp获取视频真实播放地址
            ProcessBuilder processBuilder = new ProcessBuilder(ytDlpPath, "-g", videoUrl);
            processBuilder.redirectErrorStream(true);

            // 启动进程
            Process process = processBuilder.start();

            // 读取命令行输出
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    extractedUrl = line;
                    //System.out.println("真实播放地址: " + extractedUrl);
                    log.info("yutube  真实播放地址: {}", extractedUrl);
                }
            }

            // 等待进程执行完毕
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                //System.out.println("yt-dlp 执行失败，退出代码: " + exitCode);
                log.error("yutube  yt-dlp 执行失败，退出代码: {}", exitCode);
                extractedUrl = null; // 将 extractedUrl 置为 null 表示失败
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 返回最终的 URL
        return VideoInfoResponse.VideoInfo.builder()
                .url(extractedUrl) // 如果执行失败，返回的 URL 将是 null
                .build();
    }

    /**
     * 获取yt-dlp路径
     * @return
     */
    private String getYtDlpPath(){
        // 获取操作系统名称
        String os = System.getProperty("os.name").toLowerCase();
        // 定义yt-dlp文件的路径
        String ytDlpPath = "";

        // 根据操作系统选择不同的yt-dlp文件
        if (os.contains("win")) {
            // Windows系统，使用yt-dlp.exe
            ytDlpPath = Paths.get(ytDlpPathWindows).toAbsolutePath().toString();
        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            // Linux/macOS系统，使用yt-dlp_linux
            ytDlpPath = Paths.get(ytDlpPathLinux).toAbsolutePath().toString();

            // 设置Linux/macOS系统文件为可执行
            try {
                File ytDlpFile = new File(ytDlpPath);
                if (ytDlpFile.exists()) {
                    Set<PosixFilePermission> perms = Files.getPosixFilePermissions(Paths.get(ytDlpPath));
                    perms.add(PosixFilePermission.OWNER_EXECUTE);  // 赋予执行权限
                    perms.add(PosixFilePermission.GROUP_EXECUTE);  // 赋予组执行权限
                    perms.add(PosixFilePermission.OTHERS_EXECUTE);  // 赋予其他用户执行权限
                    Files.setPosixFilePermissions(Paths.get(ytDlpPath), perms);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ytDlpPath;
    }

    /**
     * 使用classpath方式读取路径，则使用以下方法
     * @return
     */
    private String getYtDlpPath_copy() {
        String  ytDlpPath = null;
        try {
            String os = System.getProperty("os.name").toLowerCase();
            String ytDlpFileName = os.contains("win") ? "ytdown/yt-dlp.exe" : "ytdown/yt-dlp_linux";

            // 将yt-dlp文件从classpath中复制到临时目录
            ClassPathResource resource = new ClassPathResource(ytDlpFileName);
            File tempFile = File.createTempFile("yt-dlp", os.contains("win") ? ".exe" : "");
            Files.copy(resource.getInputStream(), tempFile.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);

            // 设置执行权限（仅Linux/Mac）
            if (!os.contains("win")) {
                tempFile.setExecutable(true);
            }

            ytDlpPath  = tempFile.getAbsolutePath();
            System.out.println("yt-dlp路径：" + ytDlpPath);
        }catch (Exception e){
            e.printStackTrace();
        }


        return ytDlpPath;
    }
}
