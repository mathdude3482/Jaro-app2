/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ValidatorTest {
    @Test
    void is_valid_serial_returns_true_for_valid_serial_number() {
        InventoryModel inventoryModel = new InventoryModel();
        Validator validator = new Validator(inventoryModel);
        assertTrue(validator.isValidSerial("1234567890"));
    }

    @Test
    void is_valid_serial_returns_false_for_invalid_serial_number_1() {
        InventoryModel inventoryModel = new InventoryModel();
        Validator validator = new Validator(inventoryModel);
        assertFalse(validator.isValidSerial("1234"));
    }

    @Test
    void is_valid_serial_returns_false_for_invalid_serial_number_2() {
        InventoryModel inventoryModel = new InventoryModel();
        Validator validator = new Validator(inventoryModel);
        assertFalse(validator.isValidSerial("ABC~'\"1234"));
    }

    @Test
    void is_valid_serial_returns_false_for_invalid_serial_number_3() {
        InventoryModel inventoryModel = new InventoryModel();
        SceneManager sceneManager = new SceneManager();
        AddItemController addItemController = new AddItemController(inventoryModel, sceneManager);
        addItemController.addItem("Test1", "AAAAAAAAAA", 123.45);
        Validator validator = new Validator(inventoryModel);
        assertFalse(validator.isValidSerial("AAAAAAAAAA"));
    }

    @Test
    void is_valid_name_returns_true_for_valid_name() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        assertTrue(validator.isValidName("AA"));
    }

    @Test
    void is_valid_name_returns_false_for_invalid_name_1() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        assertFalse(validator.isValidName("A"));
    }

    @Test
    void is_valid_name_returns_false_for_invalid_name_2() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        assertFalse(validator.isValidName(""));
    }

    @Test
    void is_valid_name_returns_false_for_invalid_name_3() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        String name = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

        assertFalse(validator.isValidName(name));
    }

    @Test
    void is_valid_value_returns_true_for_valid_value() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        assertTrue(validator.isValidValue("123.45"));
    }

    @Test
    void is_valid_value_returns_false_for_invalid_value_1() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        assertFalse(validator.isValidValue("A2C.45"));
    }

    @Test
    void is_valid_value_returns_false_for_invalid_value_2() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        assertFalse(validator.isValidValue("123.3479"));
    }

    @Test
    void is_valid_serial_length_returns_true_for_valid_length() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        assertTrue(validator.isValidSerialLength("1234567890"));
    }

    @Test
    void is_valid_serial_length_returns_false_for_invalid_length() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        assertFalse(validator.isValidSerialLength("1234"));
    }

    @Test
    void is_valid_serial_characters_returns_true_for_valid_characters() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        assertTrue(validator.isValidSerialCharacters("ABCDE12345"));
    }

    @Test
    void is_valid_serial_characters_returns_false_for_invalid_characters() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        assertFalse(validator.isValidSerialCharacters("ABC~'\"1234"));
    }

    @Test
    void is_unique_serial_number_returns_true_for_unique_number() {
        InventoryModel inventoryModel = new InventoryModel();
        SceneManager sceneManager = new SceneManager();

        AddItemController addItemController = new AddItemController(inventoryModel, sceneManager);

        addItemController.addItem("Test1", "AAAAAAAAAA", 123.45);

        Validator validator = new Validator(inventoryModel);

        assertTrue(validator.isUniqueSerialNumber("BBBBBBBBBB"));
    }

    @Test
    void is_unique_serial_number_returns_false_for_non_unique_number() {
        InventoryModel inventoryModel = new InventoryModel();
        SceneManager sceneManager = new SceneManager();

        AddItemController addItemController = new AddItemController(inventoryModel, sceneManager);
        addItemController.addItem("Test1", "AAAAAAAAAA", 123.45);

        Validator validator = new Validator(inventoryModel);

        assertFalse(validator.isUniqueSerialNumber("AAAAAAAAAA"));
    }

    @Test
    void is_valid_name_length_returns_true_for_valid_length_1() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        assertTrue(validator.isValidNameLength("AA"));
    }

    @Test
    void is_valid_name_length_returns_true_for_valid_length_2() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        String name = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

        assertTrue(validator.isValidNameLength(name));
    }

    @Test
    void is_valid_name_length_returns_false_for_invalid_length_1() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        assertFalse(validator.isValidNameLength("A"));
    }

    @Test
    void is_valid_name_length_returns_false_for_invalid_length_2() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        assertFalse(validator.isValidNameLength(""));
    }

    @Test
    void is_valid_name_length_returns_false_for_invalid_length_3() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        String name = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

        assertFalse(validator.isValidNameLength(name));
    }

    @Test
    void is_valid_numeric_value_returns_true_for_valid_value() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        assertTrue(validator.isValidNumericValue("123.45"));
    }

    @Test
    void is_valid_numeric_value_returns_false_for_invalid_value() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        assertFalse(validator.isValidNumericValue("A2C.45"));
    }

    @Test
    void is_valid_us_value_returns_true_for_valid_value() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        assertTrue(validator.isValidUSValue("123.45"));
    }

    @Test
    void is_valid_us_value_returns_false_for_invalid_value() {
        InventoryModel inventoryModel = new InventoryModel();

        Validator validator = new Validator(inventoryModel);

        assertFalse(validator.isValidUSValue("123.3479"));
    }
}