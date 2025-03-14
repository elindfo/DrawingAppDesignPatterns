package com.designpatterns.model;

import com.designpatterns.model.command.AddShape;
import com.designpatterns.model.command.Command;
import com.designpatterns.model.command.CommandHandler;
import com.designpatterns.model.command.EditShape;
import com.designpatterns.model.shapes.Point;
import com.designpatterns.model.shapes.Shape;
import com.designpatterns.model.shapes.ShapeHandler;
import com.designpatterns.model.shapes.ShapeRegistry;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Observer;
import java.util.Optional;
import java.util.Set;

public class Model implements ModelFacade {

    private String selectedShape;
    private ShapeRegistry shapeRegistry;
    private ShapeHandler shapeHandler;
    private CommandHandler commandHandler;
    private boolean selectionMode;

    public Model() {
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
    public void setStartingPoint(Point point) throws ShapeNotSelectedException {
        if(selectedShape == null) {
            throw new ShapeNotSelectedException();
        }
        Shape shape = shapeRegistry.getShape(selectedShape);

        shape.setStart(point);
        shape.setEnd(point);
        shapeHandler.setCurrentShape(shape);
    }

    @Override
    public void setEndPoint(Point point) {
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
        return shapeHandler.getIntersectingShapeProperties(point);
    }

    @Override
    public void updateShape(ShapeViewProperties shapeViewProperties) {
        EditShape editShape = new EditShape(shapeHandler, shapeViewProperties, shapeHandler.getCurrentlyEditedShape());
        this.commandHandler.executeCommand(editShape);
    }

    @Override
    public void load(File file) throws IOException, ClassNotFoundException {
        List<Shape> shapes = FileHandler.deserialize(file);
        this.shapeHandler.setShapesList(shapes);
    }

    @Override
    public void save(File file) throws IOException {
        FileHandler.serialize(file, this.shapeHandler.getShapeList());
    }
}
