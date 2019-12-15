package solas.projects.recorder.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 19-Jun-19
 * All rights reserved
 */

@Component
public class PanelController {

    @FXML
    public TextField xField;
    @FXML
    public TextField yField;
    @FXML
    public TextField widthField;
    @FXML
    public TextField heightField;
    @FXML
    public ToolBar toolbar;

    private Rectangle rectangle;
    private double xOffset;
    private double yOffset;

    @Autowired
    public PanelController(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @FXML
    public void initialize(){
        toolbar.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        Parent parent = toolbar.getParent();
        toolbar.setOnMouseDragged(event -> {
            parent.getScene().getWindow().setX(event.getScreenX() - xOffset);
            parent.getScene().getWindow().setY(event.getScreenY() - yOffset);
        });
        resetFields();
    }

    public void set(){
        int x = Integer.parseInt(xField.getText());
        int y = Integer.parseInt(yField.getText());
        int width = Integer.parseInt(widthField.getText());
        int height = Integer.parseInt(heightField.getText());
        rectangle.setBounds(x, y, width, height);
    }

    public void reset(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int height = dimension.height;
        int width = dimension.width / 2;
        rectangle.setBounds(0, 0, width, height);
        resetFields();
    }


    public void minimize(ActionEvent actionEvent) {

    }

    public void exit(ActionEvent actionEvent) {
        Button button = (Button)actionEvent.getSource();
        Stage stage = (Stage)button.getScene().getWindow();
        stage.close();
    }

    private void resetFields(){
        xField.setText(rectangle.x + "");
        yField.setText(rectangle.y + "");
        widthField.setText(rectangle.width + "");
        heightField.setText(rectangle.height + "");
    }
}
