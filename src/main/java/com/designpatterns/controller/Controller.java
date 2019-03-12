package com.designpatterns.controller;

import com.designpatterns.model.Model;
import com.designpatterns.model.ModelFacade;
import com.designpatterns.model.ShapeNotSelectedException;
import com.designpatterns.model.ShapeViewProperties;
import com.designpatterns.model.shapes.Point;
import com.designpatterns.view.View;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.util.Observer;
import java.util.Optional;

public class Controller {

    private ModelFacade model;
    private View view;

    private Stage stage;

    public Controller(Stage stage) {
        this.stage = stage;
        this.model = new Model();
        this.view = new View(this.model);
        this.view.setEventHandlers(this);

        this.stage.setScene(new Scene(view));
        this.stage.setTitle("Shape Drawing App");
        this.stage.setResizable(false);
        this.stage.show();
    }

    public void subscribeRegistry(Observer observer) {
        model.observeRegistry(observer);
    }

    public void subscribeModel(Observer observer) {
        model.observeShapes(observer);
    }

    public void handleCanvasDragEvent(MouseEvent mouseEvent) {
        if (!model.isSelectionMode())
            model.setEndPoint(new Point(mouseEvent.getX(), mouseEvent.getY()));
    }

    public void handleCanvasMousePressed(MouseEvent mouseEvent) {
        if (!model.isSelectionMode()) {
            try {
                model.setStartingPoint(new Point(mouseEvent.getX(), mouseEvent.getY()));
            } catch (ShapeNotSelectedException e) {
                Platform.runLater(() -> this.view.showAlert("Error", "Shape not selected", "Select a shape"));
            }
        }
    }

    public void handleCanvasMouseRelease(MouseEvent mouseEvent) {
        if (!model.isSelectionMode())
            model.finishShape(new Point(mouseEvent.getX(), mouseEvent.getY()));
    }

    public void handleCanvasMouseClicked(MouseEvent mouseEvent) {
        if (model.isSelectionMode()) {
            Optional<ShapeViewProperties> shapeProperties = model.selectIntersectingShape(new Point(mouseEvent.getX(), mouseEvent.getY()));
            shapeProperties.ifPresent(s -> Platform.runLater(() -> view.showShapePropertiesPopup(s).ifPresent(model::updateShape)));
        }
    }

    public void handleToolMenuSelected(String shapeType) {
        model.setCurrentShapeType(shapeType);
    }

    public void handleUndoPressed(ActionEvent _actionEvent) {
        model.undo();
    }

    public void handleRedoPressed(ActionEvent _actionEvent) {
        model.redo();
    }

    public void handleModeToggle(ActionEvent _actionEvent) {
        model.toggleMode();
    }

    public void handleLoadedFile(File selectedFile) {
        if (selectedFile != null) {
            try {
                model.load(selectedFile);
            } catch (Exception e) {
                Platform.runLater(() -> view.showAlert("Error", "File load failure", e.getMessage()));
            }
        }
    }

    public void handleSaveToFile(File file) {
        if (file != null && file.getName().endsWith(".ser")) {
            try {
                this.model.save(file);
            } catch (Exception e) {
                Platform.runLater(() -> view.showAlert("Error", "File save failure", "Unable to save to file"));
            }
        }
    }

    public Stage getStage() {
        return this.stage;
    }
}
