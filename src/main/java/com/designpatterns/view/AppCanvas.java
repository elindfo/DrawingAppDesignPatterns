package com.designpatterns.view;

import com.designpatterns.model.Model;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.Observable;
import java.util.Observer;

public class AppCanvas extends Canvas implements Observer {

    private GraphicsContext graphicsContext;

    public AppCanvas(double width, double height) {
        super(width, height);
        graphicsContext = this.getGraphicsContext2D();
        graphicsContext.strokeLine(10, 10, 50, 50);
    }

    @Override
    public void update(Observable observable, Object o) {
        ((Model)observable).getShapes().forEach(shape -> {

        });
    }
}
