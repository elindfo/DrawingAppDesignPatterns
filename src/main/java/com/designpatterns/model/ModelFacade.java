package com.designpatterns.model;

import com.designpatterns.model.shapes.Point;
import com.designpatterns.model.shapes.Shape;

import java.util.List;
import java.util.Observer;
import java.util.Optional;
import java.util.Set;

public interface ModelFacade {
    void undo();
    void redo();
    List<Shape> getShapes();
    void observeRegistry(Observer observer);
    void observeShapes(Observer observer);
    void setStartingPoint(Point point);
    void setEndPoint(Point point);
    Set<String> getShapeDefinitions();
    void setCurrentShapeType(String shapeType);
    void finishShape(Point point);
    void toggleMode();
    boolean isSelectionMode();
    Optional<ShapeViewProperties> selectIntersectingShape(Point point);
    void updateShape(ShapeViewProperties shapeViewProperties);
}
