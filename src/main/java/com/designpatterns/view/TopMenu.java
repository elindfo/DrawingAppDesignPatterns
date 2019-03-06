package com.designpatterns.view;

import com.designpatterns.controller.Controller;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;

import java.io.File;

public class TopMenu extends MenuBar {

    private Menu menu;
    private MenuItem loadFileItem, saveFileItem;

    public TopMenu() {
        menu = new Menu("File");
        loadFileItem = new MenuItem("Load");
        saveFileItem = new MenuItem("Save");
        menu.getItems().addAll(saveFileItem, loadFileItem);
        this.getMenus().add(menu);
    }

    public void setEventHandlers(Controller controller) {
        this.loadFileItem.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Shapes File");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Serialized Files (*.ser)", "*.ser"));
            File selectedFile = fileChooser.showOpenDialog(controller.getStage());
            controller.handleLoadedFile(selectedFile);

        });


        this.saveFileItem.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();

            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Seriallized files (*.ser)", "*.ser");
            fileChooser.getExtensionFilters().add(extFilter);

            File file = fileChooser.showSaveDialog(controller.getStage());
            controller.handleSaveToFile(file);
        });
    }
}
