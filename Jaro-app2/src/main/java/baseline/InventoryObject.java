/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import java.util.ArrayList;
import java.util.List;

public class InventoryObject {
    private List<Inventory> items = new ArrayList<>();

    //get the list of items.
    public List<Inventory> getItems() {
        return items;
    }
    //set the list of items.
    public void setItems(List<Inventory> items) {
        this.items = items;
    }
}
