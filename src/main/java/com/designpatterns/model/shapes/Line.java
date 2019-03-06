package com.designpatterns.model.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Line extends Shape{

    @Override
    protected Shape createCopy() {
        Line copy = new Line();
        copy.setStart(this.getStart());
        copy.setEnd(this.getEnd());
        return copy;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        System.out.println("[Line] draw");
        System.out.println(graphicsContext);
        Point s = getStart();
        Point e = getEnd();
        System.out.println("s: " + s);
        System.out.println("e: " + e);
        graphicsContext.strokeLine(s.getX(), s.getY(), e.getX(), e.getY());
    }
}
