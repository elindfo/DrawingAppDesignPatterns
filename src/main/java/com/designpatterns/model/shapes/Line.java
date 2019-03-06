package com.designpatterns.model.shapes;

public class Line extends Shape{

    private Point p1, p2;

    public Line() {
        p1 = new Point(20, 20);
        p2 = new Point(70, 70);
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    @Override
    protected Shape createCopy() {
        return this;
    }

    @Override
    public String toString() {
        return "Line{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }
}
