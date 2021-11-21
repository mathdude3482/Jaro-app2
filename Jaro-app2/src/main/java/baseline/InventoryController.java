/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.File;
import java.text.NumberFormat;
public class InventoryController {
    @FXML
    public GridPane gridPane;
    @FXML
    public TableView<InventoryItem> itemTable;
    @FXML
    public TableColumn<InventoryItem, Double> valueDisplay;
    @FXML
    public TableColumn<InventoryItem, String> serialDisplay;
    @FXML
    public TableColumn<InventoryItem, String> nameDisplay;
    @FXML
    public TextField searchField;

    private InventoryModel inventoryModel;
    private SceneManager sceneManager;

    public InventoryController(InventoryModel inventoryModel, SceneManager sceneManager) {
        this.inventoryModel = inventoryModel;
        this.sceneManager = sceneManager;
    }

    @FXML
    public void initialize() {
        gridPane.getStyleClass().add("grid-pane");
        nameDisplay.prefWidthProperty().bind(itemTable.widthProperty().subtract(valueDisplay.widthProperty().add(serialDisplay.widthProperty().add(2))));
        nameDisplay.setCellValueFactory(new PropertyValueFactory<>("name"));
        serialDisplay.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        valueDisplay.setCellValueFactory(new PropertyValueFactory<>("value"));
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        valueDisplay.setCellFactory(tableColumn -> new TableCell<InventoryItem, Double>() {
            @Override
            protected void updateItem(Double value, boolean empty) {
                super.updateItem(value, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(currencyFormat.format(value));
                }
            }
        });

        //implementing the search bar...
        FilteredList<InventoryItem> filteredList = new FilteredList<>(inventoryModel.getItems(), p-> true);
        searchField.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredList.setPredicate(inventoryItem -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (inventoryItem.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (inventoryItem.getSerialNumber().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }

                return false;
            });
        }));
        SortedList<InventoryItem> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(itemTable.comparatorProperty());
        itemTable.setItems(sortedList);
    }

    @FXML
    public void addItemClicked(MouseEvent mouseEvent) {
        //Open a new controller that allows the user to add a new item.
        openNewController("Add New Item", "AddItemController");
    }

    @FXML
    public void removeItemClicked(MouseEvent mouseEvent) {
        //this method will remove the item selected.
        int currentIndex = itemTable.getSelectionModel().getSelectedIndex();
        if (currentIndex != -1) {
            removeItem(currentIndex);
        }
    }

    @FXML
    public void editItemClicked(MouseEvent mouseEvent) {
        //this method will allow the user to open up another GUI to edit an item's description.
        if (itemTable.getSelectionModel().getSelectedIndex() != -1) {
            inventoryModel.setEditIndex(itemTable.getSelectionModel().getSelectedIndex());
            openNewController("Edit Item", "EditItemController");
            itemTable.refresh();
            inventoryModel.setEditIndex(-1);
        }
    }

    @FXML
    public void saveClicked(ActionEvent actionEvent) {
        //this method will allow the user to save the file.
        //create an instance of the Serialization class.
        Serialization serialization = new Serialization(inventoryModel);
        File saveFile = openSaveFileChooser();
        //if the name of the file is not empty, save it.
        if (saveFile != null) {
            serialization.save(saveFile);
        }
    }

    @FXML
    public void loadClicked(ActionEvent actionEvent) {
        //this method will allow the user to load the file.
        //Create an instance of the Serialization class.
        Serialization serialization = new Serialization(inventoryModel);
        File loadFile = openLoadFileChooser();
        //if the name of the file is not empty, load it.
        if (loadFile != null) {
            serialization.load(loadFile);
        }
    }

    @FXML
    public void closeClicked(ActionEvent actionEvent) {
        //close the GUI.
        close();
    }

    public void removeItem(int currentIndex) {
        inventoryModel.getItems().remove(currentIndex);
    }

    private void openNewController(String title, String sceneName) {
        Scene itemScene = sceneManager.getScene(sceneName);

        Stage stage = new Stage();

        stage.setScene(itemScene);
        stage.setTitle(title);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();
    }

    private File openSaveFileChooser() {
        //allow the user to choose either a HTML file, a TSV file, or a JSON file to save the list.
        FileChooser fileChooser = new FileChooser();
        Stage stage = new Stage();
        fileChooser.setInitialDirectory(new File("C://"));
        fileChooser.setInitialFileName("ItemInventory");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML File", "*.html"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TSV File", "*.txt"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON File", "*.json"));

        return fileChooser.showSaveDialog(stage);
    }

    private File openLoadFileChooser() {
        //allow the user to load either a HTML file, a TSV file, or a JSON file.
        FileChooser fileChooser = new FileChooser();
        Stage stage = new Stage();
        fileChooser.setInitialDirectory(new File("C://"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML File", "*.html"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TSV File", "*.txt"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON File", "*.json"));

        return fileChooser.showOpenDialog(stage);
    }

    private void close() {
        //close the GUI.
        Stage toClose = (Stage) gridPane.getScene().getWindow();
        toClose.close();
    }
}