package com.designpatterns.model.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class ShapeGroup extends Shape {

    private List<Shape> shapeList;

    public ShapeGroup() {
        shapeList = new ArrayList<>();
    }

    @Override
    protected Shape createCopy() {

        return null;
    }

    @Override
    protected void drawShape(GraphicsContext graphicsContext) {
        shapeList.forEach(shape -> shape.drawShape(graphicsContext));
    }
}
