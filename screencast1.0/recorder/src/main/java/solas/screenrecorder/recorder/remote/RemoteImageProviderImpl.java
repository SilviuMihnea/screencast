package solas.screenrecorder.recorder.remote;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.springframework.stereotype.Component;
import solas.screenshare.common.RemoteImageProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.rmi.RemoteException;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 18-Jun-19
 * All rights reserved
 */

@Component
public class RemoteImageProviderImpl implements RemoteImageProvider {

    private BufferedImage image;

    @Override
    public byte[] getImageData() throws RemoteException {
        ByteOutputStream byteOutputStream = new ByteOutputStream();
        try {
            ImageIO.write(image, "png", byteOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        byteOutputStream.close();
        return byteOutputStream.getBytes();
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }
}
