package solas.screenviewer.viewer.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import solas.screenviewer.viewer.controller.ScreenController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 18-Jun-19
 * All rights reserved
 */

@Component
public class ScreenFrame extends JFrame {

    private ScreenController controller;
    private ScreenComponent screenComponent;
    private ConfigurableApplicationContext context;
    private Rectangle rectangle;

    @Autowired
    public ScreenFrame(ScreenController controller,
                       ScreenComponent screenComponent,
                       ConfigurableApplicationContext context, Rectangle rectangle)
            throws HeadlessException {
        this.controller = controller;
        this.screenComponent = screenComponent;
        this.context = context;
        this.rectangle = rectangle;
        this.add(screenComponent);
        settings();
    }

    private void settings(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBounds(rectangle);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                screenComponent.setWidth(e.getComponent().getWidth());
                screenComponent.setHeight(e.getComponent().getHeight());
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                SpringApplication.exit(context);
            }
        });

    }

    @Scheduled(initialDelay = 1000, fixedDelay = 50)
    public void keepTrack(){
        screenComponent.setImage(controller.getImage());
    }
}
