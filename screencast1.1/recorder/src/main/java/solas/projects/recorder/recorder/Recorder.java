package solas.projects.recorder.recorder;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 19-Jun-19
 * All rights reserved
 */

@Component
public class Recorder {

    private Robot robot;
    private Rectangle rectangle;
    private BufferedImage image;

    public Recorder(Robot robot, Rectangle rectangle) {
        this.robot = robot;
        this.rectangle = rectangle;
    }

    @Scheduled(initialDelay = 100, fixedDelay = 30)
    public void record(){
        image = robot.createScreenCapture(rectangle);
    }

    public BufferedImage getLastImage() {
        return image;
    }
}
