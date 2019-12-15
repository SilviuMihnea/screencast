package solas.projects.viewer.controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import solas.projects.common.converter.ImageConverter;
import solas.projects.viewer.client.Client;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 18-Jun-19
 * All rights reserved
 */

@Component
public class ViewController {

    @FXML
    public ImageView view;

    private ImageConverter imageConverter;
    private Client client;

    @Autowired
    public ViewController(ImageConverter imageConverter, Client client) {
        this.imageConverter = imageConverter;
        this.client = client;
    }

    @FXML
    public void initialize(){
    }

    @Scheduled(initialDelay = 100, fixedDelay = 30)
    public void updateImage(){
        byte[] bytes = client.getImageBytes();
        Image image = imageConverter.convertToImage(bytes);
        view.setImage(image);
    }
}
