package com.example.demo2103fx;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MainController {

    @FXML
    private Pane pane;
    @FXML
    private Canvas canvas;
    @FXML
    private TextField xField;
    @FXML
    private TextField yField;
    @FXML
    private TextField rField;

    MyCircle circle;

    public void initialize() {
        canvas.widthProperty().bind(pane.widthProperty());
        canvas.heightProperty().bind(pane.heightProperty());
        canvas.widthProperty().addListener(o -> draw());
        canvas.heightProperty().addListener(o -> draw());
    }

    public void about() {
        Alert about = new Alert(Alert.AlertType.INFORMATION, "Hello from JavaFX");
        about.setTitle("Hello");
        about.setHeaderText(null);
        about.show();
    }

    public void createCircle() {
        double x = Double.parseDouble(xField.getText());
        double y = Double.parseDouble(yField.getText());
        double r = Double.parseDouble(rField.getText());

        circle = new MyCircle(x, y, r);

        draw();
    }

    private void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.ANTIQUEWHITE);
        gc.fillRect(0, 0, pane.getWidth(), pane.getHeight());
        if (circle == null) return;
        gc.strokeOval(circle.x() - circle.r(), circle.y() - circle.r(), circle.r() * 2, circle.r() * 2);
    }
}