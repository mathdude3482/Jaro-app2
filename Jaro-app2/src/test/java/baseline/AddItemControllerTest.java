/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AddItemControllerTest {
    @Test
    void add_item_adds_new_item_name() {
        InventoryModel im = new InventoryModel();
        SceneManager sm = new SceneManager();
        AddItemController aic = new AddItemController(im, sm);
        aic.addItem("Test", "XXXXXXXXXX", 123.45);
        String expected = "Test";
        String actual = im.getItem().get(0).getName();
        assertEquals(expected, actual);
    }

    @Test
    void add_item_adds_new_item_serial_number() {
        InventoryModel im = new InventoryModel();
        SceneManager sm = new SceneManager();
        AddItemController aic = new AddItemController(im, sm);
        aic.addItem("Test", "XXXXXXXXXX", 123.45);
        String expected = "XXXXXXXXXX";
        String actual = im.getItem().get(0).getSerial();
        assertEquals(expected, actual);
    }

    @Test
    void add_item_adds_new_item_value() {
        InventoryModel im = new InventoryModel();
        SceneManager sm = new SceneManager();

        AddItemController aic = new AddItemController(im, sm);

        aic.addItem("Test", "XXXXXXXXXX", 123.45);

        double expected = 123.45;
        double actual = im.getItem().get(0).getValue();

        assertEquals(expected, actual);
    }
}