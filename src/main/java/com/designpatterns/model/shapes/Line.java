package com.designpatterns.model.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Line extends Shape {

    @Override
    protected Shape createCopy() {
        Line copy = new Line();
        copy.setStart(this.getStart().createCopy());
        copy.setEnd(this.getEnd().createCopy());
        copy.setColor(this.getColor());
        copy.setLineWidth(this.getLineWidth());
        copy.setFilled(this.isFilled());
        return copy;
    }

    @Override
    protected void drawShape(GraphicsContext graphicsContext) {
        System.out.println("[Line] drawShape");
        System.out.println(graphicsContext);
        Point s = getStart();
        Point e = getEnd();
        System.out.println("s: " + s);
        System.out.println("e: " + e);
        graphicsContext.strokeLine(s.getX(), s.getY(), e.getX(), e.getY());
    }
}
