package solas.screenviewer.viewer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import solas.screenshare.common.RemoteImageProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 18-Jun-19
 * All rights reserved
 */

@Component
public class ScreenController {

    private final RemoteImageProvider imageProvider;

    @Autowired
    public ScreenController(RemoteImageProvider imageProvider) {
        this.imageProvider = imageProvider;
    }

    public BufferedImage getImage(){
        try {
            byte[] bytes = imageProvider.getImageData();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
