package com.designpatterns.view;

import com.designpatterns.controller.Controller;
import com.designpatterns.model.Model;
import com.designpatterns.model.ViewModel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Observable;
import java.util.Observer;

public class AppCanvas extends Canvas implements Observer {

    private GraphicsContext graphicsContext;

    public AppCanvas(double width, double height) {
        super(width, height);
        graphicsContext = this.getGraphicsContext2D();
        graphicsContext.setFill(Color.GREEN);
        graphicsContext.fillRect(0, 0, width, height);
        graphicsContext.strokeLine(10, 10, 50, 50);
    }

    @Override
    public void update(Observable observable, Object o) {
//        ((ViewModel)observable).getShapes().forEach(shape -> {
//
//        });
    }

    public void setEventHandlers(Controller controller) {
        this.setOnMousePressed(controller::handleCanvasMousePressed);
        this.setOnMouseDragged(controller::handleCanvasDragEvent);
        this.setOnMouseReleased(controller::handleCanvasMouseRelease);
        controller.subscribeModel(this);
    }
}
