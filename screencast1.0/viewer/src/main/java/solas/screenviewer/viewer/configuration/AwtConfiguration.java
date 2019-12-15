package solas.screenviewer.viewer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.awt.*;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 18-Jun-19
 * All rights reserved
 */

@Configuration
@EnableScheduling
public class AwtConfiguration {

    @Bean
    public Rectangle rectangle(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int height = dimension.height;
        int width = dimension.width / 2;
        int startX = dimension.width/2;
        int startY = 0;
        return new Rectangle(startX, startY, width, height);
    }
}
