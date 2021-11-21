/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Serialization {
    //this class will be used to implement the save and load options for
    //JSON, TSV, and HTML files.
    private final InventoryModel myInventory;
    public Serialization(InventoryModel inventoryModel) {
        this.myInventory = inventoryModel;
    }

    public void save(File saveFile) {
        //this method will allow the user to save either as a TSV, a JSON, or a HTML file.
        String path = saveFile.getPath();
        String[] split = path.split("\\.");
        String extension = split[split.length - 1];
        switch (extension) {
            case "txt" -> saveTSV(path);
            case "html" -> saveHTML(path);
            case "json" -> saveJSON(path);
        }
    }

    public void saveTSV(String path) {
        //this method will allow the user to save as a TSV file.
        try (Formatter formatter = new Formatter(path)) {
            for (int i = 0; i < myInventory.getItems().size(); i++) {
                String serializedName = myInventory.getItems().get(i).getName().
                        replace(" ", ".");
                String output = myInventory.getItems().get(i).getValue() + "\t" +
                        myInventory.getItems().get(i).getSerialNumber() + "\t" +
                        serializedName + "\n";
                formatter.format(output);
            }
        } catch (IOException e) {
            //catch an exception.
            e.printStackTrace();
        }
    }

    public void saveHTML(String path) {
        //this method will be used to allow the user to save as a HTML file.
        try (Formatter formatter = new Formatter(path)) {
            formatter.format("<table>\n");
            formatter.format("<tr><th> Value </th><th> Serial Number </th><th> Name </th></tr>\n");
            for (int i = 0; i < myInventory.getItems().size(); i++) {
                String serializedName = myInventory.getItems().get(i).getName().replace(" ", ".");
                String output = "<tr><th> " + myInventory.getItems().get(i).getValue() + " </th><th> " +
                        myInventory.getItems().get(i).getSerialNumber() + " </th><th> " +
                        serializedName + " </th></tr>\n";
                formatter.format(output);
            }
            formatter.format("</table>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveJSON(String path) {
        //allow the user to save as a JSON file.
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        InventoryObject inventoryObject = new InventoryObject();
        for (int i = 0; i < myInventory.getItems().size(); i++) {
            inventoryObject.getItems().add(myInventory.getItems().get(i));
        }
        try (FileWriter fw = new FileWriter(path)) {
            gson.toJson(inventoryObject, fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(File toLoad) {
        //allow the user to load in either a txt (TSV) file, a HTML file, or a JSON file.
        String path = toLoad.getPath();
        String[] split = path.split("\\.");
        String extension = split[split.length - 1];
        switch (extension) {
            case "txt" -> loadTSV(toLoad);
            case "html" -> loadHTML(toLoad);
            case "json" -> loadJSON(toLoad);
        }
    }

    public void loadTSV(File toLoad) {
        //allow the user to load a TSV file.
        List<InventoryItem> myList = new ArrayList<>();
        try (Scanner scanner = new Scanner(toLoad)) {
            while (scanner.hasNext()) {
                double value = Double.parseDouble(scanner.next());
                String serialNumber = scanner.next();
                String serializedName = scanner.next();
                String name = serializedName.replace(".", " ");
                InventoryItem newItem = new InventoryItem(name, serialNumber, value);
                myList.add(newItem);
            }
        } catch (NumberFormatException | NullPointerException | FileNotFoundException e) {
            e.printStackTrace();
        }
        //set the list in the GUI to be myList.
        myInventory.setList(myList);
    }

    public void loadHTML(File toLoad) {
        //allow the user to load in a HTML file.
        List<InventoryItem> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(toLoad)) {
            scanner.nextLine();
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                scanner.next();
                if (scanner.hasNext()) {
                    double value = Double.parseDouble(scanner.next());
                    scanner.next();
                    String serialNumber = scanner.next();
                    scanner.next();
                    String serializedName = scanner.next();
                    scanner.next();
                    String name = serializedName.replace(".", " ");
                    if (value != 0 && serialNumber != null && name != null) {
                        InventoryItem newItem = new InventoryItem(name, serialNumber, value);
                        list.add(newItem);
                    }
                }
            }
        } catch (NoSuchElementException | NumberFormatException | NullPointerException | FileNotFoundException e) {
            e.printStackTrace();
        }
        //set the list to be the loaded list.
        myInventory.setList(list);
    }

    public void loadJSON(File toLoad) {
        //allow the user to load in a JSON file.
        Gson gson = new Gson();
        InventoryObject inventoryObject = new InventoryObject();
        try (FileReader myFile = new FileReader(toLoad)) {
            inventoryObject = gson.fromJson(myFile, InventoryObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //set the list to be the loaded list.
        myInventory.setList(inventoryObject.getItems());
    }
}
