package com.designpatterns.model;

import com.designpatterns.model.shapes.Shape;

public class ShapeViewProperties {

    private String color;
    private double lineWidth;
    private boolean filled;

    public ShapeViewProperties(String color, double lineWidth, boolean filled) {
        this.color = color;
        this.lineWidth = lineWidth;
        this.filled = filled;
    }

    public ShapeViewProperties(Shape shape) {
        this.color = shape.getColor();
        this.lineWidth = shape.getLineWidth();
        this.filled = shape.isFilled();
    }

    public String getColor() {
        return color;
    }

    public double getLineWidth() {
        return lineWidth;
    }

    public boolean isFilled() {
        return filled;
    }
}
