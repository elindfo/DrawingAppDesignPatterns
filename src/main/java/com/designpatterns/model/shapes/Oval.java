package com.designpatterns.model.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Oval extends Shape {

//    private Point p;
//    private Size size;

    public Oval() {
//        this.p = new Point(50, 50);
//        this.size = new Size(20, 20);
    }

//    public Point getP() {
//        return p;
//    }
//
//    public void setP(Point p) {
//        this.p = p;
//    }
//
//    public Size getSize() {
//        return size;
//    }
//
//    public void setSize(Size size) {
//        this.size = size;
//    }

    @Override
    protected Shape createCopy() {
        return this;
    }

    @Override
    protected void draw(GraphicsContext graphicsContext) {

    }
}
