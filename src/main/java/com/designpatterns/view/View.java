package com.designpatterns.view;

import com.designpatterns.controller.Controller;
import javafx.scene.layout.BorderPane;

public class View extends BorderPane {

    private AppCanvas appCanvas;
    private ToolMenu toolMenu;

    public View() {
        this.appCanvas = new AppCanvas(200, 200);
        this.toolMenu = new ToolMenu();
        this.setCenter(this.appCanvas);
        this.setLeft(this.toolMenu);
    }

    public void setEventHandlers(Controller controller) {

        this.appCanvas.setEventHandlers(controller);
        this.toolMenu.setEventHandlers(controller);

        controller.subscribeModel(this.appCanvas);
    }
}
