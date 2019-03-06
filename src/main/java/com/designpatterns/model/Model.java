package com.designpatterns.model;

import com.designpatterns.model.command.AddShape;
import com.designpatterns.model.command.Command;
import com.designpatterns.model.command.CommandHandler;
import com.designpatterns.model.shapes.Point;
import com.designpatterns.model.shapes.Shape;
import com.designpatterns.model.shapes.ShapeRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Model implements ModelFacade {
    private String selectedShape;
    private ShapeRegistry shapeRegistry;
    private ShapeHandler shapeHandler;
    private CommandHandler commandHandler;

    public Model() {
        this.selectedShape = "line";
        this.shapeRegistry = new ShapeRegistry();
        this.shapeHandler = new ShapeHandler();
        this.commandHandler = new CommandHandler();
    }

    @Override
    public void addShape(Shape shape) {
        Shape shapeToDraw = shapeRegistry.getShape(selectedShape);
        Command addShapeCommand = new AddShape(shapeHandler, shapeToDraw);
        commandHandler.executeCommand(addShapeCommand);
    }

    @Override
    public void undo() {
        commandHandler.undo();
    }

    @Override
    public void redo() {
        commandHandler.redo();
    }

    @Override
    public List<Shape> getShapes() {
        return shapeHandler.getShapeList();
    }

    @Override
    public void observeRegistry(Observer observer) {
        shapeRegistry.addObserver(observer);
    }

    @Override
    public void observeShapes(Observer observer) {
        shapeHandler.addObserver(observer);
    }

    @Override
    public void setStartingPoint(Point point) {
        Shape shape = shapeRegistry.getShape(selectedShape);
//        shape.
        shapeHandler.setCurrentShape(shape);
    }

    @Override
    public void setEndPoint(Point point) {

    }
}
