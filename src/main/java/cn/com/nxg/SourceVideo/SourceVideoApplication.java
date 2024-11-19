package cn.com.nxg.SourceVideo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Configurable
public class SourceVideoApplication {
    public static void main( String[] args ) {
        SpringApplication.run(SourceVideoApplication.class,args);
    }
}
