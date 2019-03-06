package com.designpatterns.controller;

import com.designpatterns.model.Model;
import com.designpatterns.model.ModelFacade;
import com.designpatterns.model.shapes.Line;
import com.designpatterns.view.View;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Observer;

public class Controller {

    private Model model;
    private View view;

    private Scene scene;

    public Controller(Stage stage) {
        this.model = new Model();
        this.view = new View();
        this.view.setEventHandlers(this);

        this.scene = new Scene(view, 400, 400);
        stage.setScene(this.scene);
        stage.setTitle("Shape Drawing App");

        init();

        stage.show();
    }

    private void init() {

    }

    public void subscribeRegistry(Observer observer) {
        model.observeRegistry(observer);
    }

    public void subscribeModel(Observer observer) {
        model.observeShapes(observer);
//         model.addObserver(observer);
    }

    public void handleCanvasDragEvent(MouseEvent mouseEvent) {
        System.out.println("Drag");
//        model.addShape();
    }

    public void handleCanvasMousePressed(MouseEvent mouseEvent) {
        System.out.println("Press");
    }

    public void handleCanvasMouseRelease(MouseEvent mouseEvent) {
        System.out.println("Release");
    }
}
