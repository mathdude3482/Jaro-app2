/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;

public class InventoryModel {
    //create a observable list to keep track of changes.
    private ObservableList<Inventory> items;
    private int editIndex;

    public InventoryModel() {
        //initializing values.
        this.items = FXCollections.observableArrayList();
        editIndex = -1;
    }

    public void setList(List<Inventory> list) {
        //clear whatever what was previously in the list of items.
        items.clear();
        //add the list to the observable ArrayList item.
        items.addAll(list);
    }

    public ObservableList<Inventory> getItem() {
        //get the list of items.
        return items;
    }

    public void setEditIndex(int editIndex) {
        //return the index that the user wants to edit.
        this.editIndex = editIndex;
    }

    public int getEditIndex() {
        //get the index that the user wants to edit.
        return editIndex;
    }
}
