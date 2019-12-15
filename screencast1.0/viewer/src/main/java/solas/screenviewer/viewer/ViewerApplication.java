package solas.screenviewer.viewer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ViewerApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder applicationBuilder =
                new SpringApplicationBuilder(ViewerApplication.class);
        applicationBuilder.headless(false).run(args);
    }

}
