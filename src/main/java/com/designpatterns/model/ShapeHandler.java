package com.designpatterns.model;

import com.designpatterns.model.shapes.Point;
import com.designpatterns.model.shapes.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Optional;
import java.util.stream.Collectors;

public class ShapeHandler extends Observable {

    private List<Shape> shapeList;
    private Shape currentShape, currentlyEditedShape;

    public ShapeHandler() {
        shapeList = new ArrayList<>();
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }

    public void addShape(Shape shape) {
        shapeList.add(shape);
        setChanged();
        notifyObservers();
    }

    public void removeShape(Shape shape) {
        shapeList.remove(shape);
        setChanged();
        notifyObservers();
    }

    public void setCurrentShape(Shape currentShape) {
        this.currentShape = currentShape;
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

    public Optional<ShapeViewProperties> getIntersectingShapeProperties(Point point) {
        List<Shape> shapes = this.shapeList.stream().filter(shape -> shape.intersects(point)).collect(Collectors.toList());
        if (!shapes.isEmpty()) {
            Shape shape = shapes.get(shapes.size() - 1);
            this.currentlyEditedShape = shape;
            return Optional.of(new ShapeViewProperties(shape.getColor(), shape.getLineWidth(), shape.isFilled()));
        }
        return Optional.empty();
    }

    public void updateEditedShape(ShapeViewProperties shapeViewProperties) {
        this.currentlyEditedShape.setColor(shapeViewProperties.getColor());
        this.currentlyEditedShape.setLineWidth(shapeViewProperties.getLineWidth());
        this.currentlyEditedShape.setFilled(shapeViewProperties.isFilled());
        this.currentlyEditedShape = null;
        setChanged();
        notifyObservers();
    }

    public Shape getCurrentlyEditedShape() {
        return this.currentlyEditedShape;
    }

    public void setCurrentlyEditedShape(Shape currentlyEditedShape) {
        this.currentlyEditedShape = currentlyEditedShape;
    }

    public void setShapesList(List<Shape> shapes) {
        this.shapeList = shapes;
        setChanged();
        notifyObservers();
    }
}
