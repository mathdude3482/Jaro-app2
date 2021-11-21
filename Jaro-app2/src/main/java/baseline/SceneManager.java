/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class SceneManager {
    private final Map<String, Scene> scenes = new HashMap<>();
    public void load() {
        //load the scene.
        InventoryModel inventoryModel = new InventoryModel();
        InventoryController inventoryController = new InventoryController(inventoryModel, this);
        AddItemController addItemController = new AddItemController(inventoryModel, this);
        EditItemController editItemController = new EditItemController(inventoryModel, this);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InventoryController.fxml"));
        loader.setController(inventoryController);
        loadScene("InventoryController", loader);
        loader = new FXMLLoader(getClass().getResource("AddItemController.fxml"));
        loader.setController(addItemController);
        loadScene("AddItemController", loader);
        loader = new FXMLLoader(getClass().getResource("EditItemController.fxml"));
        loader.setController(editItemController);
        loadScene("EditItemController", loader);
    }

    private void loadScene(String controllerName, FXMLLoader loader) {
        //try to load the scene. If not found, catch an exception.
        try {
            Scene myscene = new Scene(loader.load());
            scenes.put(controllerName, myscene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Scene getScene(String sceneName) {
        //return the scene.
        return scenes.get(sceneName);
    }
}
