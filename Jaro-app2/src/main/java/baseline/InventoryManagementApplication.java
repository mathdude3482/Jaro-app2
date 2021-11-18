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
        //SceneManager myScene = new SceneManager();
        //myScene.load();

        //primaryStage.setScene(sm.getScene("InventoryController"));
        primaryStage.setTitle("Inventory Manager");
        primaryStage.show();
    }
}