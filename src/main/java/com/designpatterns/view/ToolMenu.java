package com.designpatterns.view;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ToolMenu extends GridPane {

    public ToolMenu() {
        this.add(new Button("Line"), 0, 0);
        this.add(new Button("Oval"), 1, 0);
        this.add(new Button("ja"), 0, 1);
        this.add(new Button("nej"), 1, 1);
    }
}
