/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import javafx.application.Application;
import javafx.stage.Stage;

public class InventoryManagementApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        //create an instance of Scenemanager.
        SceneManager myScene = new SceneManager();
        //call the load method.
        myScene.load();
        primaryStage.setScene(myScene.getScene("InventoryController"));
        primaryStage.setTitle("Inventory Manager");
        primaryStage.show();
    }
}