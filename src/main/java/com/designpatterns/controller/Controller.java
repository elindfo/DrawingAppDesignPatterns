package com.designpatterns.controller;

import com.designpatterns.model.Model;
import com.designpatterns.model.ModelFacade;
import com.designpatterns.view.View;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Observer;

public class Controller {

    private ModelFacade model;
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

    public void subscribeModel(Observer observer) {
        // model.addObserver(observer);
    }
}
