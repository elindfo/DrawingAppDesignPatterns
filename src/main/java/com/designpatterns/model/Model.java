package com.designpatterns.model;

import com.designpatterns.model.shapes.Shape;
import com.designpatterns.model.shapes.ShapeRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Model implements ModelFacade {
    private ShapeRegistry shapeRegistry;
    private ViewModel viewModel;

    public Model() {
        this.shapeRegistry = new ShapeRegistry();
        this.viewModel = new ViewModel();
    }

    @Override
    public void addShape(Shape shape) {
        viewModel.addShape(shape);
    }

    @Override
    public List<Shape> getShapes() {
        return viewModel.getShapeList();
    }

    @Override
    public void observeRegistry(Observer observer) {
        viewModel.addObserver(observer);
    }

    @Override
    public void observeShapes(Observer observer) {
        shapeRegistry.addObserver(observer);
    }
}
