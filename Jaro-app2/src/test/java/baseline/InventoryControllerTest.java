/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryControllerTest {
    @Test
    void remove_item_removes_an_item() {
        InventoryModel im = new InventoryModel();
        SceneManager sm = new SceneManager();

        InventoryController ic = new InventoryController(im, sm);
        AddItemController aic = new AddItemController(im, sm);

        aic.addItem("Test", "XXXXXXXXXX", 123.45);

        ic.removeItem(0);

        assertEquals(0, im.getItem().size());
    }

    @Test
    void remove_item_removes_chosen_item() {
        InventoryModel im = new InventoryModel();
        SceneManager sm = new SceneManager();

        InventoryController ic = new InventoryController(im, sm);
        AddItemController aic = new AddItemController(im, sm);

        aic.addItem("Test1", "XXXXXXXXXX", 123.45);
        aic.addItem("Test2", "XXXXXXXXXX", 123.45);
        aic.addItem("Test3", "XXXXXXXXXX", 123.45);
        aic.addItem("Test4", "XXXXXXXXXX", 123.45);
        aic.addItem("Test5", "XXXXXXXXXX", 123.45);
        ic.removeItem(2);
        String expected = "Test4";
        String actual = im.getItem().get(2).getName();
        assertEquals(expected, actual);
    }
}