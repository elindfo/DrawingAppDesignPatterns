package com.designpatterns.model;

import com.designpatterns.model.shapes.Line;
import com.designpatterns.model.shapes.Point;
import com.designpatterns.model.shapes.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ShapeHandler extends Observable {
    private List<Shape> shapeList;
    private Shape currentShape;

    public ShapeHandler() {
        shapeList = new ArrayList<>();
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

    public void setCurrentShape(Shape currentShape) {
        this.currentShape = currentShape;
        shapeList.add(currentShape);
        this.setChanged();
        this.notifyObservers();
    }

    public Shape getCurrentShape() {
        return this.currentShape;
    }

    public void updateCurrentShape(Point point) {
        this.currentShape.setEnd(point);
        this.setChanged();
        this.notifyObservers();
    }
}
