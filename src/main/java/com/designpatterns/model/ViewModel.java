package com.designpatterns.model;

import com.designpatterns.model.shapes.Shape;

import java.util.List;
import java.util.Observable;

public class ViewModel extends Observable {
    private List<Shape> shapeList;

    public ViewModel() {
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }

    public boolean addShape(Shape shape) {
        return shapeList.add(shape);
    }
}
