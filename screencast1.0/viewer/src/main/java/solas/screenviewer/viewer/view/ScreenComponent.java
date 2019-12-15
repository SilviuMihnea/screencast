package solas.screenviewer.viewer.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.IOException;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 18-Jun-19
 * All rights reserved
 */

@Component
public class ScreenComponent extends JComponent {

    private BufferedImage image;
    private int width;
    private int height;
    private boolean changed;

    @Override
    protected void paintComponent(Graphics g) {
        if (image == null) {
            return;
        }
        if (changed) {
            width = this.getParent().getWidth();
            height = this.getParent().getHeight();
            image = getScaledImage(image, width, height);
            changed = false;
        }
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(image, 0, 0, width, height, this);
    }

    private static BufferedImage getScaledImage(BufferedImage image, int width, int height) {
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();

        double scaleX = (double) width / imageWidth;
        double scaleY = (double) height / imageHeight;
        AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
        AffineTransformOp bilinearScaleOp =
                new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);
        return bilinearScaleOp.filter(
                image,
                new BufferedImage(width, height, image.getType()));
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        changed = true;
        repaint();
    }

    public void setWidth(int width) {
        this.width = width;
        changed = true;
        repaint();
    }

    public void setHeight(int height) {
        this.height = height;
        changed = true;
        repaint();
    }
}
