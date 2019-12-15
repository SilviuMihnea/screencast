package solas.projects.recorder.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 19-Jun-19
 * All rights reserved
 */

@Configuration
public class AwtConfiguration {

    @Bean
    public Robot robot() throws AWTException {
        return new Robot();
    }

    @Bean
    public Rectangle rectangle(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int height = dimension.height;
        int width = dimension.width / 2;
        int startX = 0;
        int startY = 0;
        return new Rectangle(startX, startY, width, height);
    }

}
