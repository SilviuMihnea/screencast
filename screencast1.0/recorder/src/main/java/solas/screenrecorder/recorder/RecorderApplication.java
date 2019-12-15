package solas.screenrecorder.recorder;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RecorderApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder applicationBuilder =
                new SpringApplicationBuilder(RecorderApplication.class);
        applicationBuilder.headless(false).run(args);
    }

}
