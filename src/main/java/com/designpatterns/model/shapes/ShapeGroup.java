package com.designpatterns.model.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeGroup extends Shape {

    private List<Shape> shapeList;

    public ShapeGroup(Shape... shapes) {
        shapeList = new ArrayList<>(Arrays.asList(shapes));
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
        shapeList.forEach(shape -> shape.setColor(color));
    }

    @Override
    public void setLineWidth(double lineWidth) {
        super.setLineWidth(lineWidth);
        shapeList.forEach(shape -> shape.setLineWidth(lineWidth));
    }

    @Override
    public void setFilled(boolean filled) {
        super.setFilled(filled);
        shapeList.forEach(shape -> shape.setFilled(filled));
    }

    @Override
    public void setStart(Point start) {
        super.setStart(start);
        shapeList.forEach(shape -> shape.setStart(start));
    }

    @Override
    public void setEnd(Point end) {
        super.setEnd(end);
        shapeList.forEach(shape -> shape.setEnd(end));
    }

    @Override
    protected Shape clone() throws CloneNotSupportedException {
        try {
            ShapeGroup clone = (ShapeGroup) super.clone();
            clone.shapeList = new ArrayList<>();
            for (Shape shape : shapeList) {
                clone.addShape(shape.clone());
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            System.out.println("ShapeGroup: Cloning not supported");
            return null;
        }
    }

    //    @Override
//    protected Shape createCopy() {
//        ShapeGroup shapeGroup = new ShapeGroup();
//        shapeGroup.setStart(this.getStart());
//        shapeGroup.setEnd(this.getEnd());
//        this.shapeList.stream().map(Shape::createCopy).forEach(shapeGroup::addShape);
//        return shapeGroup;
//    }

    @Override
    protected void drawShape(GraphicsContext graphicsContext) {
        shapeList.forEach(shape -> shape.drawShape(graphicsContext));
    }

    public void addShape(Shape shape) {
        this.shapeList.add(shape);
    }
}
