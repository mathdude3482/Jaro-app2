/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
public class EditItemController {
    @FXML
    private GridPane gridPane;

    @FXML
    private TextField nameDisplay;

    @FXML
    private TextField serialDisplay;

    @FXML
    private TextField valueDisplay;

    @FXML
    void cancelClicked(MouseEvent event) {
        //in the event that the user does not want to add anything, this method will call another method
        //called cancel that closes the GUI.
    }

    @FXML
    void editClicked(MouseEvent event) {
        //call a method called checkEdit to check that all parts are valid.
        //if all parts are valid, edit the item.
        //then, close the GUI.
    }
    public boolean checkEdit(){
        //check if each part of the item is valid.
        //if at any point a part is invalid, return false.
        //otherwise, return true.
        return true;
    }
    private void cancel(){
        //close the GUI application.
    }
}