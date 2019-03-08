package com.designpatterns.model.shapes;

import java.io.Serializable;

public class Point implements Serializable {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point createCopy() {
        return new Point(x, y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point add(Point p) {
        this.x += p.getX();
        this.y += p.getY();
        return this;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
