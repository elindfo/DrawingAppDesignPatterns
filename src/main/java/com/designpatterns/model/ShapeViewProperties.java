package com.designpatterns.model;

public class ShapeViewProperties {
    private String color;
    private double lineWidth;
    private boolean filled;

    public ShapeViewProperties(String color, double lineWidth, boolean filled) {
        this.color = color;
        this.lineWidth = lineWidth;
        this.filled = filled;
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
