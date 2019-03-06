package com.designpatterns.model.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Oval extends Shape {

    @Override
    protected Shape createCopy() {
        Oval copy = new Oval();
        copy.setStart(this.getStart());
        copy.setEnd(this.getEnd());
        return copy;
    }


    @Override
    public void draw(GraphicsContext graphicsContext) {
        System.out.println("[Oval] draw");
        Point s = getStart();
        Point e = getEnd();

        double w = e.getX() - s.getX();
        double h = e.getY() - s.getY();

        //TODO Take into account drawing in negative x and y direction

        graphicsContext.strokeOval(s.getX(), s.getY(), w, h);
    }
}
