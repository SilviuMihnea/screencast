package solas.screenrecorder.recorder.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 18-Jun-19
 * All rights reserved
 */

@Component
public class RecordFrame extends JFrame {

    private Rectangle rectangle;
    private Container container;
    private TextField xField = new TextField();
    private TextField yField = new TextField();
    private TextField widthField = new TextField();
    private TextField heightField = new TextField();
    private Button set = new Button("Set");
    private Button reset = new Button("Reset");

    @Autowired
    public RecordFrame(Rectangle rectangle) throws HeadlessException {
        this.rectangle = rectangle;
        this.container = getContentPane();
        buildLayout();
        initialize();
        settings();
    }

    private void buildLayout(){
        container.setLayout(new GridLayout(5, 2));

        container.add(new Label("X: "));
        container.add(xField);

        container.add(new Label("Y: "));
        container.add(yField);

        container.add(new Label("Width: "));
        container.add(widthField);

        container.add(new Label("Height: "));
        container.add(heightField);

        container.add(set);
        container.add(reset);
    }

    private void initialize() {
        ActionListener listener = e -> {
            int x = Integer.parseInt(xField.getText());
            int y = Integer.parseInt(yField.getText());
            int width = Integer.parseInt(widthField.getText());
            int height = Integer.parseInt(heightField.getText());
            rectangle.setBounds(x, y, width, height);
        };

        xField.addActionListener(listener);
        yField.addActionListener(listener);
        widthField.addActionListener(listener);
        heightField.addActionListener(listener);
        set.addActionListener(listener);

        reset.addActionListener(e -> {
            resetBoundsForRecording();
            fillFields();
        });

        fillFields();
    }

    private void settings() {
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(300, 300));
    }

    private void resetBoundsForRecording(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int height = dimension.height;
        int width = dimension.width / 2;
        int startX = 0;
        int startY = 0;
        rectangle.setBounds(startX, startY, width, height);
    }

    private void fillFields(){
        xField.setText(rectangle.x + "");
        yField.setText(rectangle.y + "");
        widthField.setText(rectangle.width + "");
        heightField.setText(rectangle.height + "");
    }

}
