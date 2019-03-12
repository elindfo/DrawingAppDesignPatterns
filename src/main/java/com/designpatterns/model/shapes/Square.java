package com.designpatterns.model.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Square extends Shape {

//    @Override
//    protected Shape createCopy() {
//        Square square = new Square();
//        square.setStart(this.getStart().createCopy());
//        square.setEnd(this.getEnd().createCopy());
//        square.setColor(this.getColor());
//        square.setLineWidth(this.getLineWidth());
//        square.setFilled(this.isFilled());
//        return square;
//    }

    @Override
    protected void drawShape(GraphicsContext graphicsContext) {
        Point s = getStart();
        Point e = getEnd();

        double w = e.getX() - s.getX();
        double h = e.getY() - s.getY();

        double x = w < 0 ? e.getX() : s.getX();
        double y = h < 0 ? e.getY() : s.getY();

        if (isFilled())
            graphicsContext.fillRect(x, y, Math.abs(w), Math.abs(h));
        else
            graphicsContext.strokeRect(x, y, Math.abs(w), Math.abs(h));
    }
}
