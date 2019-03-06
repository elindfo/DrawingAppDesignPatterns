package com.designpatterns.controller;

import com.designpatterns.model.Model;
import com.designpatterns.model.ShapeViewProperties;
import com.designpatterns.model.shapes.Point;
import com.designpatterns.model.shapes.Shape;
import com.designpatterns.view.View;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Observer;
import java.util.Optional;

public class Controller {

    private Model model;
    private View view;

    private Scene scene;

    public Controller(Stage stage) {
        this.model = new Model();
        this.view = new View(this.model);
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
    }

    public void handleCanvasDragEvent(MouseEvent mouseEvent) {
        if (!model.isSelectionMode())
            model.setEndPoint(new Point(mouseEvent.getX(), mouseEvent.getY()));
    }

    public void handleCanvasMousePressed(MouseEvent mouseEvent) {
        if (!model.isSelectionMode())
            model.setStartingPoint(new Point(mouseEvent.getX(), mouseEvent.getY()));
    }

    public void handleCanvasMouseRelease(MouseEvent mouseEvent) {
        if (!model.isSelectionMode())
            model.finishShape(new Point(mouseEvent.getX(), mouseEvent.getY()));
    }

    public void handleCanvasMouseClicked(MouseEvent mouseEvent) {
        if (model.isSelectionMode()) {
            Optional<ShapeViewProperties> shapeProperties = model.selectIntersectingShape(new Point(mouseEvent.getX(), mouseEvent.getY()));
            shapeProperties.ifPresent(s -> {
//                view.showShapePropertiesPopup(s).ifPresent(model::);
            });
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
}
