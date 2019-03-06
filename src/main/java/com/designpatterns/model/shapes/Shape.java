package com.designpatterns.model.shapes;

import javafx.scene.canvas.GraphicsContext;

public abstract class Shape implements Cloneable {

    private Point start, end;

    protected abstract Shape createCopy();

    public abstract void draw(GraphicsContext graphicsContext);

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }
}
