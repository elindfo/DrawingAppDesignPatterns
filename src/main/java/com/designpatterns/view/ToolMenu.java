package com.designpatterns.view;

import com.designpatterns.controller.Controller;
import com.designpatterns.model.ModelFacade;
import com.designpatterns.model.shapes.ShapeRegistry;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ToolMenu extends VBox {

    private List<Button> menuButtons;
    private ToggleButton modeButton;

    public ToolMenu(ModelFacade model) {
        this.menuButtons = new ArrayList<>();
        model.getShapeDefinitions().forEach(definition -> {
            Button b = new Button(definition);
            this.menuButtons.add(b);
        });
        this.modeButton = new ToggleButton("hej");

        this.getChildren().addAll(this.menuButtons);
        this.getChildren().add(this.modeButton);
    }

    public void setEventHandlers(Controller controller) {
        this.menuButtons.forEach(button -> {
            button.setOnAction(e -> {
                controller.handleToolMenuSelected(button.getText());
            });
        });

        this.modeButton.setOnAction(controller::handleModeToggle);
    }
}
