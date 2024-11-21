package cn.com.nxg.SourceVideo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

/**
 * @author keney
 * @title YutubeAppTest
 * @createTime 2024/11/21 22:22
 * @description
 */
@SpringBootTest
@Slf4j
public class YutubeAppTest {

    @Test
    public void test_yutube_url_parser() {
        String videoUrl = "https://www.youtube.com/watch?v=Bzw2T18YDJ4";

        // 获取文件路径
        String ytDlpPath = Paths.get("src/main/resources/yt-dlp_linux").toAbsolutePath().toString();

        try {
            // 修改文件权限：赋予可执行权限
            File ytDlpFile = new File(ytDlpPath);
            if (ytDlpFile.exists()) {
                // 对于Linux/Mac系统，使用PosixFilePermission来设置可执行权限
                if (System.getProperty("os.name").toLowerCase().contains("nix") ||
                        System.getProperty("os.name").toLowerCase().contains("nux") ||
                        System.getProperty("os.name").toLowerCase().contains("mac")) {
                    Set<PosixFilePermission> perms = Files.getPosixFilePermissions(Paths.get(ytDlpPath));
                    perms.add(PosixFilePermission.OWNER_EXECUTE);  // 赋予执行权限
                    perms.add(PosixFilePermission.GROUP_EXECUTE);  // 赋予组执行权限
                    perms.add(PosixFilePermission.OTHERS_EXECUTE);  // 赋予其他用户执行权限
                    Files.setPosixFilePermissions(Paths.get(ytDlpPath), perms);
                } else {
                    // Windows系统可以跳过权限修改，直接执行
                    ytDlpFile.setExecutable(true);
                }
            }

            // 使用yt-dlp_linux文件获取视频真实播放地址
            ProcessBuilder processBuilder = new ProcessBuilder(ytDlpPath, "-g", videoUrl);
            processBuilder.redirectErrorStream(true);

            // 启动进程
            Process process = processBuilder.start();

            // 读取命令行输出
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    log.info("yutube  真实播放地址: {}", line);
                }
            }

            // 等待进程执行完毕
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                log.error("yutube  yt-dlp_linux 执行失败，退出代码: {}", exitCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
