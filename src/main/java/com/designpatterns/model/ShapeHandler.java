package com.designpatterns.model;

import com.designpatterns.model.shapes.Shape;

import java.util.List;
import java.util.Observable;

public class ShapeHandler extends Observable {
    private List<Shape> shapeList;

    public ShapeHandler() {
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }

    public boolean addShape(Shape shape) {
        return shapeList.add(shape);
    }

    public boolean removeShape(Shape shape) {
        return shapeList.remove(shape);
    }
}
