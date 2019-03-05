package com.designpatterns.model.shapes;

import java.util.HashMap;
import java.util.Map;

public class ShapeRegistry {

    private Map<String, Shape> shapeStore;

    public ShapeRegistry() {
        this.shapeStore = new HashMap<>();
        this.shapeStore.put("circle", new Oval());
        this.shapeStore.put("line", new Line());
    }

    public Shape getShape(String name) {
        return shapeStore.get(name).createCopy();
    }
}
