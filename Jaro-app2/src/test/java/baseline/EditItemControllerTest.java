/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditItemControllerTest {
    @Test
    void edit_item_edits_selected_item_1() {
        InventoryModel inventoryModel = new InventoryModel();
        SceneManager sceneManager = new SceneManager();

        AddItemController addItemController = new AddItemController(inventoryModel, sceneManager);
        addItemController.addItem("Test1", "XXXXXXXXXX", 123.45);

        inventoryModel.setEditIndex(0);

        EditItemController editItemController = new EditItemController(inventoryModel, sceneManager);
        editItemController.editItem("Change", "XXXXXLLLLL", "987.65");

        String newName = inventoryModel.getItems().get(0).getName();

        assertEquals("Change", newName);
    }

    @Test
    void edit_item_edits_selected_item_2() {
        InventoryModel inventoryModel = new InventoryModel();
        SceneManager sceneManager = new SceneManager();

        AddItemController addItemController = new AddItemController(inventoryModel, sceneManager);
        addItemController.addItem("Test1", "XXXXXXXXXX", 123.45);

        inventoryModel.setEditIndex(0);

        EditItemController editItemController = new EditItemController(inventoryModel, sceneManager);
        editItemController.editItem("Change", "XXXXXLLLLL", "987.65");

        String newSerial = inventoryModel.getItems().get(0).getSerialNumber();

        assertEquals("XXXXXLLLLL", newSerial);
    }

    @Test
    void edit_item_edits_selected_item_3() {
        InventoryModel inventoryModel = new InventoryModel();
        SceneManager sceneManager = new SceneManager();

        AddItemController addItemController = new AddItemController(inventoryModel, sceneManager);
        addItemController.addItem("Test1", "XXXXXXXXXX", 123.45);

        inventoryModel.setEditIndex(0);

        EditItemController editItemController = new EditItemController(inventoryModel, sceneManager);
        editItemController.editItem("Change", "XXXXXLLLLL", "987.65");

        double newValue = inventoryModel.getItems().get(0).getValue();

        assertEquals(987.65, newValue);
    }
}