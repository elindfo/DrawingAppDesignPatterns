package com.designpatterns;

import com.designpatterns.controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {
    public static void main( String[] args ) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        new Controller(stage);
    }
}
