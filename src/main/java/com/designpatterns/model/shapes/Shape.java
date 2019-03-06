package com.designpatterns.model.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {

    private Point start, end;
    private String fillColor;
    private String strokeColor;
    private double lineWidth;
    private boolean filled;

    public Shape() {
        this.fillColor = "#00F";
        this.strokeColor = "#00F";
        this.lineWidth = 4.0;
        this.filled = true;
    }

    protected abstract Shape createCopy();

    protected abstract void drawShape(GraphicsContext graphicsContext);

    final public void draw(GraphicsContext graphicsContext) {
        // TODO Implement shared functionality
        graphicsContext.setFill(Color.web(fillColor));
        graphicsContext.setStroke(Color.web(strokeColor));
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

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
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
