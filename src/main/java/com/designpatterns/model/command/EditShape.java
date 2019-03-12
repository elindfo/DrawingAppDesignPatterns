package com.designpatterns.model.command;

import com.designpatterns.model.shapes.ShapeHandler;
import com.designpatterns.model.ShapeViewProperties;
import com.designpatterns.model.shapes.Shape;

public class EditShape extends Command{

    private ShapeHandler shapeHandler;
    private ShapeViewProperties shapeViewProperties, previousShapeViewProperties;
    private Shape currentlyEditedShape;

    public EditShape(ShapeHandler shapeHandler, ShapeViewProperties shapeViewProperties, Shape currentlyEditedShape) {
        this.shapeHandler = shapeHandler;
        this.shapeViewProperties = shapeViewProperties;
        this.currentlyEditedShape = currentlyEditedShape;
    }

    @Override
    public void execute() {
        this.previousShapeViewProperties = new ShapeViewProperties(this.currentlyEditedShape);
        this.shapeHandler.setCurrentlyEditedShape(this.currentlyEditedShape);
        this.shapeHandler.updateEditedShape(shapeViewProperties);
    }

    @Override
    public void undo() {
        this.shapeHandler.setCurrentlyEditedShape(this.currentlyEditedShape);
        this.shapeHandler.updateEditedShape(this.previousShapeViewProperties);
    }
}
