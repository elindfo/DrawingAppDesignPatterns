package com.designpatterns.view;

import com.designpatterns.controller.Controller;
import com.designpatterns.model.ModelFacade;
import com.designpatterns.model.ShapeViewProperties;
import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.Optional;

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

    public Optional<ShapeViewProperties> showShapePropertiesPopup(ShapeViewProperties shape) {
        Dialog<ShapeViewProperties> dialog = new Dialog<>();
        dialog.setTitle("Properties");
        dialog.setHeaderText("Change color, width, filled");
        ButtonType okButton = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(okButton, ButtonType.CANCEL);
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        TextField colorTextField = new TextField(shape.getColor());
        colorTextField.setPromptText("Color #AABBCC");
        TextField lineWidthTextField = new TextField(String.valueOf(shape.getLineWidth()));
        lineWidthTextField.setPromptText("Color #AABBCC");
        ToggleButton shapedFilledButton = new ToggleButton("Filled");
        shapedFilledButton.setSelected(shape.isFilled());
        gridPane.addColumn(0, colorTextField, lineWidthTextField, shapedFilledButton);
        dialog.getDialogPane().setContent(gridPane);
        Platform.runLater(colorTextField::requestFocus);
        dialog.setResultConverter(button -> {
            if (button == okButton) {
                String color = colorTextField.getText();
                double lineWidth = Double.parseDouble(lineWidthTextField.getText());
                boolean filled = shapedFilledButton.isSelected();
                return new ShapeViewProperties(color, lineWidth, filled);
            }
            return null;
        });
        return dialog.showAndWait();
    }
}
