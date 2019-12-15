package solas.projects.viewer.configuration;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import solas.projects.viewer.ViewerApplication;

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
    public Parent view() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ViewerApplication.class.getResource("view.fxml"));
        loader.setControllerFactory(context::getBean);
        return loader.load();
    }
}
