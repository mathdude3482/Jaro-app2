/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddItemController {
    @FXML
    public GridPane gridPane;
    @FXML
    public TextField nameDisplay;
    @FXML
    public TextField serialDisplay;
    @FXML
    public TextField valueDisplay;

    private InventoryModel inventoryModel;
    private SceneManager sceneManager;

    @FXML
    public void initialize() {
        gridPane.getStyleClass().add("grid-pane");
    }

    public AddItemController(InventoryModel inventoryModel, SceneManager sceneManager) {
        this.inventoryModel = inventoryModel;
        this.sceneManager = sceneManager;
    }
    @FXML
    public void addClicked(MouseEvent event) {
        //call a method called checkItem to check that all parts are valid.
        //if all parts are valid, add the item.
        //then, close the GUI.
        if (checkItem()) {
            addItem(nameDisplay.getText().trim(), serialDisplay.getText(),
                    Double.parseDouble(valueDisplay.getText()));
            cancel();
        }
    }
    @FXML
    public void cancelClicked(MouseEvent event) {
        //in the event that the user does not want to add anything, this method will call another method
        //called cancel that closes the GUI.
        cancel();
    }
    public boolean checkItem(){
        //check if each part of the item is valid.
        //if at any point a part is invalid, return false.
        //otherwise, return true.
        Validator validator = new Validator(inventoryModel);
        //check if the name is valid.
        if (!validator.isValidName(nameDisplay.getText().trim())) {
            showError("An item's name must be between 2 and 256 characters (inclusive).");
            return false;
        }
        //check if the serial number is valid.
        if (!validator.isValidSerial(serialDisplay.getText())) {
            showError("An item's serial number must be unique and in the format XXXXXXXXXX and consist of only letters and digits.");
            return false;
        }
        //check if the value is valid.
        if (!validator.isValidValue(valueDisplay.getText())) {
            showError("An item's value must represent a monetary value in US dollars.");
            return false;
        }
        return true;
    }
    public void addItem(String name, String serialNumber, double value) {
        //create a new inventory item with the parameters.
        Inventory newItem = new Inventory(name, serialNumber, value);
        //add the item.
        inventoryModel.getItem().add(newItem);
    }

    private void showError(String contextText) {
        //display an error message.
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("Input not valid");
        errorAlert.setContentText(contextText);
        errorAlert.initModality(Modality.APPLICATION_MODAL);
        errorAlert.showAndWait();
    }
    private void cancel(){
        //close the GUI application.
        nameDisplay.clear();
        serialDisplay.clear();
        valueDisplay.clear();
        Stage stage = (Stage) gridPane.getScene().getWindow();
        stage.hide();
    }
}
