package solas.projects.viewer;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ViewerApplication extends Application {

    private ConfigurableApplicationContext context;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        context = new SpringApplicationBuilder(ViewerApplication.class)
                .headless(false).run();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = context.getBean("view", Parent.class);
        String host = context.getBean("host", String.class);
        int port = context.getBean("port", Integer.class);

        stage.setTitle(host + ":" + port);
        stage.setScene(new Scene(parent));
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        SpringApplication.exit(context);
    }
}
