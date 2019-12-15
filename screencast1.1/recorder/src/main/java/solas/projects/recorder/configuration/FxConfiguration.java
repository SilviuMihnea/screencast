package solas.projects.recorder.configuration;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import solas.projects.recorder.RecorderApplication;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 18-Jun-19
 * All rights reserved
 */

@Configuration
public class FxConfiguration {

    private final ConfigurableApplicationContext context;

    @Autowired
    public FxConfiguration(ConfigurableApplicationContext context) {
        this.context = context;
    }

    @Bean
    public Parent panel() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(RecorderApplication.class.getResource("panel.fxml"));
        loader.setControllerFactory(context::getBean);
        return loader.load();
    }

    @Bean
    public Image image(Robot robot, Rectangle rectangle){
        BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
        WritableImage image = new WritableImage(rectangle.width, rectangle.height);
        return SwingFXUtils.toFXImage(bufferedImage, image);
    }
}
