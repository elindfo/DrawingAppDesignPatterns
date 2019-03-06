package com.designpatterns.view;

import com.designpatterns.controller.Controller;
import com.designpatterns.model.ModelFacade;
import javafx.scene.layout.BorderPane;

public class View extends BorderPane {

    private AppCanvas appCanvas;
    private ToolMenu toolMenu;
    private UndoRedoView undoRedoView;

    public View(ModelFacade model) {
        this.appCanvas = new AppCanvas(200, 200);
        this.toolMenu = new ToolMenu(model);
        this.undoRedoView = new UndoRedoView();
        this.setCenter(this.appCanvas);
        this.setLeft(this.toolMenu);
        this.setTop(this.undoRedoView);
    }

    public void setEventHandlers(Controller controller) {

        this.appCanvas.setEventHandlers(controller);
        this.toolMenu.setEventHandlers(controller);
        this.undoRedoView.setEventHandlers(controller);

        controller.subscribeModel(this.appCanvas);
    }
}
