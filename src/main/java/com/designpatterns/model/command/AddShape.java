package com.designpatterns.model.command;

import com.designpatterns.model.shapes.ShapeHandler;
import com.designpatterns.model.shapes.Shape;

public class AddShape extends Command {

    private ShapeHandler shapeHandler;
    private Shape shape;

    public AddShape(ShapeHandler shapeHandler, Shape shape) {
        this.shapeHandler = shapeHandler;
        this.shape = shape;
    }

    @Override
    public void execute() {
        shapeHandler.addShape(shape);
    }

    @Override
    public void undo() {
        shapeHandler.removeShape(shape);
    }
}
