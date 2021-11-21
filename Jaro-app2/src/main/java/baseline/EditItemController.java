/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class EditItemController {
    @FXML
    public GridPane gridPane;
    @FXML
    public TextField nameDisplay;
    @FXML
    public TextField serialDisplay;
    @FXML
    public TextField valueDisplay;
    @FXML
    private InventoryModel myInventory;
    private SceneManager sceneManager;

    public EditItemController(InventoryModel inventoryModel, SceneManager sceneManager) {
        this.myInventory = inventoryModel;
        this.sceneManager = sceneManager;
    }
    @FXML
    public void initialize() {
        gridPane.getStyleClass().add("grid-pane");
    }
    @FXML
    public void cancelClicked(MouseEvent event) {
        //in the event that the user does not want to add anything, this method will call another method
        //called cancel that closes the GUI.
        cancel();
    }
    @FXML
    public void editClicked(MouseEvent event) {
        //call a method called checkEdit to check that all parts are valid.
        //if all parts are valid, edit the item.
        //then, close the GUI.
        if (checkEdit(nameDisplay.getText().trim(), serialDisplay.getText(), valueDisplay.getText()))
        {
            editItem(nameDisplay.getText().trim(), serialDisplay.getText(), valueDisplay.getText());
            cancel();
        }
    }
    public void editItem(String name, String serialNumber, String value) {
        //edit the information based on user input if the user did not leave anything blank.
        if (!name.isEmpty()) {
            myInventory.getItem().get(myInventory.getEditIndex()).setName(name);
        }

        if (!serialNumber.isEmpty()) {
            myInventory.getItem().get(myInventory.getEditIndex()).setSerial(serialNumber);
        }

        if (!value.isEmpty()) {
            myInventory.getItem().get(myInventory.getEditIndex()).setValue(Double.parseDouble(value));
        }
    }
    public boolean checkEdit(String name, String serialNumber, String value){
        //check if each part of the item is valid.
        //if at any point a part is invalid, return false.
        //otherwise, return true.
        Validator validator = new Validator(myInventory);
        if (!name.isEmpty()) {
            if (!validator.isValidName(name)) {
                showError("An item's name must be between 2 and 256 characters (inclusive).");
                return false;
            }
        }
        if (!serialNumber.isEmpty()) {
            if (!validator.isValidSerial(serialNumber)) {
                showError("An item's serial number must be unique and in the format XXXXXXXXXX and consist of only letters and digits.");
                return false;
            }
        }
        if (!value.isEmpty()) {
            if (!validator.isValidValue(value)) {
                showError("An item's value must represent a monetary value in US dollars.");
                return false;
            }
        }
        return true;
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
        Stage toClose = (Stage) gridPane.getScene().getWindow();
        toClose.close();
    }
}
