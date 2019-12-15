package solas.screenrecorder.recorder.remote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 18-Jun-19
 * All rights reserved
 */

@Component
public class Recorder {

    private final RemoteImageProviderImpl remoteImageProvider;
    private Robot robot;
    private Rectangle rectangle;

    @Autowired
    public Recorder(RemoteImageProviderImpl remoteImageProvider, Robot robot, Rectangle rectangle) {
        this.remoteImageProvider = remoteImageProvider;
        this.robot = robot;
        this.rectangle = rectangle;
    }

    @Scheduled(initialDelay = 200, fixedDelay = 50)
    public void record(){
        BufferedImage image = robot.createScreenCapture(rectangle);
        remoteImageProvider.setImage(image);
    }
}
