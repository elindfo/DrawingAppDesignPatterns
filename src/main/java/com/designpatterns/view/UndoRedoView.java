package com.designpatterns.view;

import com.designpatterns.controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class UndoRedoView extends HBox {
    private Button undoButton;
    private Button redoButton;

    public UndoRedoView() {
        undoButton = new Button("Undo");
        redoButton = new Button("Redo");
        this.getChildren().addAll(undoButton, redoButton);
        this.setPadding(new Insets(8));
        this.setSpacing(8);
        this.setAlignment(Pos.CENTER_RIGHT);
    }

    public void setEventHandlers(Controller controller) {
        undoButton.setOnAction(controller::handleUndoPressed);
        redoButton.setOnAction(controller::handleRedoPressed);
    }
}
