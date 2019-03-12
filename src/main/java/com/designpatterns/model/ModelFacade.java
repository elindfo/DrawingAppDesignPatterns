package com.designpatterns.model;

import com.designpatterns.model.shapes.Point;
import com.designpatterns.model.shapes.Shape;

import java.io.File;
import java.io.IOException;
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
    void setStartingPoint(Point point) throws ShapeNotSelectedException;
    void setEndPoint(Point point);
    Set<String> getShapeDefinitions();
    void setCurrentShapeType(String shapeType);
    void finishShape(Point point);
    void toggleMode();
    boolean isSelectionMode();
    Optional<ShapeViewProperties> selectIntersectingShape(Point point);
    void updateShape(ShapeViewProperties shapeViewProperties);
    void load(File file) throws IOException, ClassNotFoundException;
    void save(File file) throws IOException;
}
