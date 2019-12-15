package solas.projects.common.converter;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 19-Jun-19
 * All rights reserved
 */

public class ImageConverter {

    public byte[] convertImage(BufferedImage image){
        ByteOutputStream stream = new ByteOutputStream();
        try{
            ImageIO.write(image, "png", stream);
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
        stream.close();
        return stream.getBytes();
    }

    public Image convertToImage(byte[] bytes){
        return new Image(new ByteArrayInputStream(bytes));
    }
}
