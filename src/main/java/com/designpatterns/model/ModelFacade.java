package com.designpatterns.model;

import com.designpatterns.model.shapes.Point;
import com.designpatterns.model.shapes.Shape;

import java.util.List;
import java.util.Observer;

public interface ModelFacade {
    void addShape(Shape shape);
    void undo();
    void redo();
    List<Shape> getShapes();
    void observeRegistry(Observer observer);
    void observeShapes(Observer observer);
    void setStartingPoint(Point point);
    void setEndPoint(Point point);
}
