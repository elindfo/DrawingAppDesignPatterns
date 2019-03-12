package com.designpatterns.model.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Oval extends Shape {

    @Override
    protected Shape createCopy() {
        Oval copy = new Oval();
        copy.setStart(this.getStart().createCopy());
        copy.setEnd(this.getEnd().createCopy());
        copy.setColor(this.getColor());
        copy.setLineWidth(this.getLineWidth());
        copy.setFilled(this.isFilled());
        return copy;
    }

    @Override
    protected void drawShape(GraphicsContext graphicsContext) {
        Point s = getStart();
        Point e = getEnd();

        double w = e.getX() - s.getX();
        double h = e.getY() - s.getY();

        double x = w < 0 ? e.getX() : s.getX();
        double y = h < 0 ? e.getY() : s.getY();

        if (isFilled()){
            graphicsContext.fillOval(x, y, Math.abs(w), Math.abs(h));
        }
        else {
            graphicsContext.strokeOval(x, y, Math.abs(w), Math.abs(h));
        }

    }
}
