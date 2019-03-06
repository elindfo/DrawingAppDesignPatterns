package com.designpatterns.model;

import com.designpatterns.model.command.AddShape;
import com.designpatterns.model.command.Command;
import com.designpatterns.model.command.CommandHandler;
import com.designpatterns.model.shapes.Point;
import com.designpatterns.model.shapes.Shape;
import com.designpatterns.model.shapes.ShapeRegistry;

import java.util.List;
import java.util.Observer;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Model implements ModelFacade {
    private String selectedShape;
    private ShapeRegistry shapeRegistry;
    private ShapeHandler shapeHandler;
    private CommandHandler commandHandler;
    private boolean selectionMode;

    public Model() {
        this.selectedShape = "oval";
        this.shapeRegistry = new ShapeRegistry();
        this.shapeHandler = new ShapeHandler();
        this.commandHandler = new CommandHandler();
        this.selectionMode = false;
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
        System.out.println("Set starting point: " + point);
        Shape shape = shapeRegistry.getShape(selectedShape);
        System.out.println(shape);
        shape.setStart(point);
        shape.setEnd(point);
        shapeHandler.setCurrentShape(shape);
    }

    @Override
    public void setEndPoint(Point point) {
        System.out.println("Set end point: " + point);
        shapeHandler.updateCurrentShape(point);
    }

    @Override
    public Set<String> getShapeDefinitions() {
        return shapeRegistry.getShapes();
    }

    @Override
    public void setCurrentShapeType(String shapeType) {
        this.selectedShape = shapeType;
    }

    @Override
    public void finishShape(Point point) {
        Shape shapeToDraw = shapeHandler.getCurrentShape();
        Command addShapeCommand = new AddShape(shapeHandler, shapeToDraw);
        commandHandler.executeCommand(addShapeCommand);
        shapeHandler.setCurrentShape(null);
    }

    @Override
    public void toggleMode() {
        this.selectionMode = !this.selectionMode;
    }

    @Override
    public boolean isSelectionMode() {
        return selectionMode;
    }

    @Override
    public Optional<ShapeViewProperties> selectIntersectingShape(Point point) {
        List<Shape> shapes = this.shapeHandler.getShapeList().stream().filter(shape -> shape.intersects(point)).collect(Collectors.toList());
        if (!shapes.isEmpty()) {
            Shape shape = shapes.get(shapes.size() - 1);
            System.out.println(shape);
            return Optional.of(new ShapeViewProperties(shape.getColor(), shape.getLineWidth(), shape.isFilled()));
        } else {
            System.out.println("Nothing found");
        }
        return Optional.empty();
    }
}
