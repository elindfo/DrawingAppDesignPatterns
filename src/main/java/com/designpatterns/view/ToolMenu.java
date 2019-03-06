package com.designpatterns.view;

import com.designpatterns.controller.Controller;
import com.designpatterns.model.shapes.ShapeRegistry;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicInteger;

public class ToolMenu extends GridPane implements Observer {

//    private Model model;

    private List<Node> menuItems;

    public ToolMenu() {
//        this.add(new Button("Line"), 0, 0);
//        this.add(new Button("Oval"), 1, 0);
//        this.add(new Button("ja"), 0, 1);
//        this.add(new Button("nej"), 1, 1);
//        for (int i = 0; i < 3; i++) {
//            this.add(new Button("Hello"), 0, i);
//        }
    }

    public void setEventHandlers(Controller controller) {
        controller.subscribeRegistry(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
        AtomicInteger i = new AtomicInteger();
        ((ShapeRegistry) o).getShapes().forEach(shapeName -> this.add(new Button(shapeName), 0, i.getAndIncrement()));
    }
}
