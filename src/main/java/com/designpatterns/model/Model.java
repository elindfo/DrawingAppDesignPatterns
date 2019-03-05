package com.designpatterns.model;

import com.designpatterns.model.shapes.Shape;
import com.designpatterns.model.shapes.ShapeRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable implements ModelFacade{

    private ShapeRegistry shapeRegistry;
    private List<Shape> shapes;

    public Model() {
        this.shapeRegistry = new ShapeRegistry();
        this.shapes = new ArrayList<>();
        this.notifyObservers();
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public ShapeRegistry getShapeRegistry() {
        return this.shapeRegistry;
    }

    @Override
    public void updateShape() {

    }
}
