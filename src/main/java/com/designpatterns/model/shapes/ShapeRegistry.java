package com.designpatterns.model.shapes;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

public class ShapeRegistry {

    private Map<String, Shape> shapeStore;

    public ShapeRegistry() {
        this.shapeStore = new HashMap<>();
        this.shapeStore.put("oval", new Oval());
        this.shapeStore.put("line", new Line());
        this.shapeStore.put("square", new Square());
        this.shapeStore.put("ovalline", new ShapeGroup(new Line(), new Oval()));
    }

    public Shape getShape(String name) {
        return shapeStore.get(name).createCopy();
    }

    public Set<String> getShapes() {
        return shapeStore.keySet();
    }
}
