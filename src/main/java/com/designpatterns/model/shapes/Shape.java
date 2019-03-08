package com.designpatterns.model.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.Serializable;

public abstract class Shape implements Serializable {

    private Point start, end;
    private String color;
    private double lineWidth;
    private boolean filled;

    public Shape() {
        this.start = new Point(0, 0);
        this.end = new Point(0, 0);
        this.color = "#00F";
        this.lineWidth = 4.0;
        this.filled = true;
    }

    protected abstract Shape createCopy();

    protected abstract void drawShape(GraphicsContext graphicsContext);

    public boolean intersects(Point point) {
        boolean xIntersects;
        boolean yIntersects;

        if (start.getX() < end.getX()) {
            xIntersects = point.getX() >= start.getX() && point.getX() <= end.getX();
        } else {
            xIntersects = point.getX() <= start.getX() && point.getX() >= end.getX();
        }

        if (start.getY() < end.getY()) {
            yIntersects = point.getY() >= start.getY() && point.getY() <= end.getY();
        } else {
            yIntersects = point.getY() <= start.getY() && point.getY() >= end.getY();
        }
        return xIntersects && yIntersects;
    }

    final public void draw(GraphicsContext graphicsContext) {
        // TODO Implement shared functionality
        graphicsContext.setFill(Color.web(color));
        graphicsContext.setStroke(Color.web(color));
        graphicsContext.setLineWidth(lineWidth);
        drawShape(graphicsContext);
    }

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(double lineWidth) {
        this.lineWidth = lineWidth;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
