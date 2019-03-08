package com.designpatterns.view;

import com.designpatterns.controller.Controller;
import com.designpatterns.model.ModelFacade;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ToolMenu extends BorderPane {

    private List<Button> menuButtons;
    private ToggleButton modeButton;

    public ToolMenu(ModelFacade model) {
        this.menuButtons = new ArrayList<>();
        model.getShapeDefinitions().stream().map(Button::new).forEach(menuButtons::add);
        menuButtons.forEach(button -> button.setPrefWidth(100));
        this.modeButton = new ToggleButton("Sel. Mode");
        modeButton.setPrefWidth(100);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(this.menuButtons);
        vBox.setSpacing(2);
        this.setTop(vBox);
        this.setBottom(this.modeButton);
        this.setPadding(new Insets(8));
    }

    public void setEventHandlers(Controller controller) {
        this.menuButtons.forEach(button ->
                button.setOnAction(e ->
                        controller.handleToolMenuSelected(button.getText())));

        this.modeButton.setOnAction(controller::handleModeToggle);
    }
}
