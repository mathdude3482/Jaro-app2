/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class InventoryController {

    @FXML
    private GridPane gridPane;

    @FXML
    private TableView<?> itemTable;

    @FXML
    private TableColumn<?, ?> nameDisplay;

    @FXML
    private TextField searchField;

    @FXML
    private TableColumn<?, ?> serialDisplay;

    @FXML
    private TableColumn<?, ?> valueDisplay;

    @FXML
    void addItemClicked(MouseEvent event) {
        //if the button "Add New Item" is clicked, call a method which pops up the GUI created from the
        //AddItemController fxml file.
    }

    @FXML
    void closeClicked(ActionEvent event) {
        //Close the GUI.
    }

    @FXML
    void editItemClicked(MouseEvent event) {
        //if the button "Edit SelectedItem" is clicked,
        // call a method which pops up the GUI created from the
        //EditItemController fxml file.
    }

    @FXML
    void loadClicked(ActionEvent event) {
        //this method will allow the user to load a file that was previously saved that is either
        // a TSV, HTML, or a JSON file.
    }

    @FXML
    void removeItemClicked(MouseEvent event) {
        //if the button "Remove item" is clicked, it will simply remove the item selected.
    }

    @FXML
    void saveClicked(ActionEvent event) {
        //this method will allow the user to save the content as either
        //a TSV, HTML, or a JSON file.
    }
    private void cancel(){
        //close the GUI application.
    }
}
