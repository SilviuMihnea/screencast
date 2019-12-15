package solas.projects.viewer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 18-Jun-19
 * All rights reserved
 */

@Configuration
public class AwtConfiguration {

    @Bean
    public Robot robot() throws AWTException {
        return new Robot();
    }

    @Bean
    public Dimension dimension() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    @Bean
    public Rectangle rectangle(Dimension dimension) {
        return new Rectangle(dimension.width / 2, dimension.height);
    }
}
