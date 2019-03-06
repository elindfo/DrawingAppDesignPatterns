package com.designpatterns.model.shapes;

import java.io.Serializable;

public class Size implements Serializable {

    private double w, h;

    public Size(double w, double h) {
        this.w = w;
        this.h = h;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }
}
