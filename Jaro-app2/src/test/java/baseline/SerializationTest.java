/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
class SerializationTest {
    @Test
    void save_tsv_creates_txt_file() {
        InventoryModel im = new InventoryModel();
        SceneManager sm = new SceneManager();

        AddItemController aic = new AddItemController(im, sm);
        Serialization serialization = new Serialization(im);

        aic.addItem("Test", "XXXXXXXXXX", 123.45);

        File toSave = new File("src/test/resources/test1.txt");

        serialization.saveTSV(toSave.getPath());

        assertTrue(toSave.exists());
    }

    @Test
    void save_html_creates_html_file() {
        InventoryModel im = new InventoryModel();
        SceneManager sm = new SceneManager();

        AddItemController aic = new AddItemController(im, sm);
        Serialization serialization = new Serialization(im);

        aic.addItem("Test", "XXXXXXXXXX", 123.45);

        File toSave = new File("src/test/resources/test2.html");

        serialization.saveHTML(toSave.getPath());

        assertTrue(toSave.exists());
    }

    @Test
    void save_json_creates_json_file() {
        InventoryModel im = new InventoryModel();
        SceneManager sm = new SceneManager();

        AddItemController aic = new AddItemController(im, sm);
        Serialization serialization = new Serialization(im);

        aic.addItem("Test", "XXXXXXXXXX", 123.45);

        File toSave = new File("src/test/resources/test3.json");

        serialization.saveJSON(toSave.getPath());

        assertTrue(toSave.exists());
    }

    @Test
    void save_tsv_saves_content_1() {
        InventoryModel inventoryModel = new InventoryModel();
        SceneManager sceneManager = new SceneManager();

        Serialization serialization = new Serialization(inventoryModel);
        AddItemController addItemController = new AddItemController(inventoryModel, sceneManager);

        addItemController.addItem("Item 1", "AAAAAAAAAA", 123.45);
        addItemController.addItem("Item 2", "BBBBBBBBBB", 987.65);
        addItemController.addItem("Item 3", "CCCCCCCCCC", 345.67);

        File toSave = new File("src/test/resources/test4.txt");

        serialization.saveTSV(toSave.getPath());
        serialization.loadTSV(toSave);

        assertEquals(3, inventoryModel.getItem().size());
    }

    @Test
    void save_tsv_saves_content_2() {
        InventoryModel inventoryModel = new InventoryModel();
        SceneManager sceneManager = new SceneManager();

        Serialization serialization = new Serialization(inventoryModel);
        AddItemController addItemController = new AddItemController(inventoryModel, sceneManager);

        addItemController.addItem("Item 1", "AAAAAAAAAA", 123.45);
        addItemController.addItem("Item 2", "BBBBBBBBBB", 987.65);

        File toSave = new File("src/test/resources/test5.txt");

        serialization.saveTSV(toSave.getPath());
        serialization.loadTSV(toSave);

        assertEquals("Item 1", inventoryModel.getItem().get(0).getName());
        assertEquals("AAAAAAAAAA", inventoryModel.getItem().get(0).getSerial());
        assertEquals(123.45, inventoryModel.getItem().get(0).getValue());
    }

    @Test
    void save_tsv_saves_content_3() {
        InventoryModel inventoryModel = new InventoryModel();
        SceneManager sceneManager = new SceneManager();

        Serialization serialization = new Serialization(inventoryModel);
        AddItemController addItemController = new AddItemController(inventoryModel, sceneManager);

        addItemController.addItem("Item 1", "AAAAAAAAAA", 123.45);
        addItemController.addItem("Item 2", "BBBBBBBBBB", 987.65);

        File toSave = new File("src/test/resources/test6.txt");

        serialization.saveTSV(toSave.getPath());
        serialization.loadTSV(toSave);

        assertEquals("Item 2", inventoryModel.getItem().get(1).getName());
        assertEquals("BBBBBBBBBB", inventoryModel.getItem().get(1).getSerial());
        assertEquals(987.65, inventoryModel.getItem().get(1).getValue());
    }

    @Test
    void save_html_saves_content_1() {
        InventoryModel inventoryModel = new InventoryModel();
        SceneManager sceneManager = new SceneManager();

        Serialization serialization = new Serialization(inventoryModel);
        AddItemController addItemController = new AddItemController(inventoryModel, sceneManager);

        addItemController.addItem("Item 1", "AAAAAAAAAA", 123.45);
        addItemController.addItem("Item 2", "BBBBBBBBBB", 987.65);
        addItemController.addItem("Item 3", "CCCCCCCCCC", 345.67);

        File toSave = new File("src/test/resources/test7.html");

        serialization.saveHTML(toSave.getPath());
        serialization.loadHTML(toSave);

        assertEquals(3, inventoryModel.getItem().size());
    }

    @Test
    void save_html_saves_content_2() {
        InventoryModel inventoryModel = new InventoryModel();
        SceneManager sceneManager = new SceneManager();

        Serialization serialization = new Serialization(inventoryModel);
        AddItemController addItemController = new AddItemController(inventoryModel, sceneManager);

        addItemController.addItem("Item 1", "AAAAAAAAAA", 123.45);
        addItemController.addItem("Item 2", "BBBBBBBBBB", 987.65);

        File toSave = new File("src/test/resources/test8.html");

        serialization.saveHTML(toSave.getPath());
        serialization.loadHTML(toSave);

        assertEquals("Item 1", inventoryModel.getItem().get(0).getName());
        assertEquals("AAAAAAAAAA", inventoryModel.getItem().get(0).getSerial());
        assertEquals(123.45, inventoryModel.getItem().get(0).getValue());
    }

    @Test
    void save_html_saves_content_3() {
        InventoryModel inventoryModel = new InventoryModel();
        SceneManager sceneManager = new SceneManager();

        Serialization serialization = new Serialization(inventoryModel);
        AddItemController addItemController = new AddItemController(inventoryModel, sceneManager);

        addItemController.addItem("Item 1", "AAAAAAAAAA", 123.45);
        addItemController.addItem("Item 2", "BBBBBBBBBB", 987.65);

        File toSave = new File("src/test/resources/test9.html");

        serialization.saveHTML(toSave.getPath());
        serialization.loadHTML(toSave);

        assertEquals("Item 2", inventoryModel.getItem().get(1).getName());
        assertEquals("BBBBBBBBBB", inventoryModel.getItem().get(1).getSerial());
        assertEquals(987.65, inventoryModel.getItem().get(1).getValue());
    }

    @Test
    void save_json_saves_content_1() {
        InventoryModel inventoryModel = new InventoryModel();
        SceneManager sceneManager = new SceneManager();

        Serialization serialization = new Serialization(inventoryModel);
        AddItemController addItemController = new AddItemController(inventoryModel, sceneManager);

        addItemController.addItem("Item 1", "AAAAAAAAAA", 123.45);
        addItemController.addItem("Item 2", "BBBBBBBBBB", 987.65);
        addItemController.addItem("Item 3", "CCCCCCCCCC", 345.67);

        File toSave = new File("src/test/resources/test10.json");

        serialization.saveJSON(toSave.getPath());
        serialization.loadJSON(toSave);

        assertEquals(3, inventoryModel.getItem().size());
    }

    @Test
    void save_json_saves_content_2() {
        InventoryModel inventoryModel = new InventoryModel();
        SceneManager sceneManager = new SceneManager();

        Serialization serialization = new Serialization(inventoryModel);
        AddItemController addItemController = new AddItemController(inventoryModel, sceneManager);

        addItemController.addItem("Item 1", "AAAAAAAAAA", 123.45);
        addItemController.addItem("Item 2", "BBBBBBBBBB", 987.65);

        File toSave = new File("src/test/resources/test11.json");

        serialization.saveJSON(toSave.getPath());
        serialization.loadJSON(toSave);

        assertEquals("Item 1", inventoryModel.getItem().get(0).getName());
        assertEquals("AAAAAAAAAA", inventoryModel.getItem().get(0).getSerial());
        assertEquals(123.45, inventoryModel.getItem().get(0).getValue());
    }

    @Test
    void save_json_saves_content_3() {
        InventoryModel inventoryModel = new InventoryModel();
        SceneManager sceneManager = new SceneManager();

        Serialization serialization = new Serialization(inventoryModel);
        AddItemController addItemController = new AddItemController(inventoryModel, sceneManager);

        addItemController.addItem("Item 1", "AAAAAAAAAA", 123.45);
        addItemController.addItem("Item 2", "BBBBBBBBBB", 987.65);

        File toSave = new File("src/test/resources/test12.json");

        serialization.saveJSON(toSave.getPath());
        serialization.loadJSON(toSave);

        assertEquals("Item 2", inventoryModel.getItem().get(1).getName());
        assertEquals("BBBBBBBBBB", inventoryModel.getItem().get(1).getSerial());
        assertEquals(987.65, inventoryModel.getItem().get(1).getValue());
    }

    @Test
    void load_tsv_loads_file_content_1() {
        InventoryModel inventoryModel = new InventoryModel();

        Serialization serialization = new Serialization(inventoryModel);

        File toLoad = new File("src/test/resources/test13.txt");

        serialization.loadTSV(toLoad);

        assertEquals(2, inventoryModel.getItem().size());
    }

    @Test
    void load_tsv_loads_file_content_2() {
        InventoryModel inventoryModel = new InventoryModel();

        Serialization serialization = new Serialization(inventoryModel);

        File toLoad = new File("src/test/resources/test13.txt");

        serialization.loadTSV(toLoad);

        assertEquals("Item 1", inventoryModel.getItem().get(0).getName());
        assertEquals("AAAAAAAAAA", inventoryModel.getItem().get(0).getSerial());
        assertEquals(123.45, inventoryModel.getItem().get(0).getValue());
    }

    @Test
    void load_tsv_loads_file_content_3() {
        InventoryModel inventoryModel = new InventoryModel();

        Serialization serialization = new Serialization(inventoryModel);

        File toLoad = new File("src/test/resources/test13.txt");

        serialization.loadTSV(toLoad);

        assertEquals("Item 2", inventoryModel.getItem().get(1).getName());
        assertEquals("BBBBBBBBBB", inventoryModel.getItem().get(1).getSerial());
        assertEquals(987.65, inventoryModel.getItem().get(1).getValue());
    }

    @Test
    void load_html_loads_file_content_1() {
        InventoryModel inventoryModel = new InventoryModel();

        Serialization serialization = new Serialization(inventoryModel);

        File toLoad = new File("src/test/resources/test14.html");

        serialization.loadHTML(toLoad);

        assertEquals(2, inventoryModel.getItem().size());
    }

    @Test
    void load_html_loads_file_content_2() {
        InventoryModel inventoryModel = new InventoryModel();

        Serialization serialization = new Serialization(inventoryModel);

        File toLoad = new File("src/test/resources/test14.html");

        serialization.loadHTML(toLoad);

        assertEquals("Item 1", inventoryModel.getItem().get(0).getName());
        assertEquals("AAAAAAAAAA", inventoryModel.getItem().get(0).getSerial());
        assertEquals(123.45, inventoryModel.getItem().get(0).getValue());
    }

    @Test
    void load_html_loads_file_content_3() {
        InventoryModel inventoryModel = new InventoryModel();

        Serialization serialization = new Serialization(inventoryModel);

        File toLoad = new File("src/test/resources/test14.html");

        serialization.loadHTML(toLoad);

        assertEquals("Item 2", inventoryModel.getItem().get(1).getName());
        assertEquals("BBBBBBBBBB", inventoryModel.getItem().get(1).getSerial());
        assertEquals(987.65, inventoryModel.getItem().get(1).getValue());
    }

    @Test
    void load_json_loads_file_content_1() {
        InventoryModel inventoryModel = new InventoryModel();

        Serialization serialization = new Serialization(inventoryModel);

        File toLoad = new File("src/test/resources/test15.json");

        serialization.loadJSON(toLoad);

        assertEquals(2, inventoryModel.getItem().size());
    }

    @Test
    void load_json_loads_file_content_2() {
        InventoryModel inventoryModel = new InventoryModel();

        Serialization serialization = new Serialization(inventoryModel);

        File toLoad = new File("src/test/resources/test15.json");

        serialization.loadJSON(toLoad);

        assertEquals("Item 1", inventoryModel.getItem().get(0).getName());
        assertEquals("AAAAAAAAAA", inventoryModel.getItem().get(0).getSerial());
        assertEquals(123.45, inventoryModel.getItem().get(0).getValue());
    }

    @Test
    void load_json_loads_file_content_3() {
        InventoryModel inventoryModel = new InventoryModel();

        Serialization serialization = new Serialization(inventoryModel);

        File toLoad = new File("src/test/resources/test15.json");

        serialization.loadJSON(toLoad);

        assertEquals("Item 2", inventoryModel.getItem().get(1).getName());
        assertEquals("BBBBBBBBBB", inventoryModel.getItem().get(1).getSerial());
        assertEquals(987.65, inventoryModel.getItem().get(1).getValue());
    }
}