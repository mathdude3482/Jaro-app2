/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
public class Validator {
    //this class will be used to make sure all parts of the description
    //is correct.
    private final InventoryModel myInventory;
    public Validator(InventoryModel inventoryModel) {
        //set the private variable to the parameter.
        this.myInventory = inventoryModel;
    }
    public boolean isValidSerial(String serialNumber) {
        //check if the serial number is valid. If not, return false.
        if (!isValidSerialLength(serialNumber)) {
            //check if the serial number is a valid length.
            return false;
        }

        if (!isValidSerialCharacters(serialNumber)) {
            //check if the serial number uses correct characters.
            return false;
        }

        if (!isUniqueSerialNumber(serialNumber)) {
            //check if the serial number is unique.
            return false;
        }
        //otherwise, return true.
        return true;
    }

    public boolean isValidName(String name) {
        //check if the name is valid. Return the result of isValidNameLength.
        return isValidNameLength(name);
    }

    public boolean isValidValue(String value) {
        //check if the value given is correct. If not, return false.
        if (!isValidNumericValue(value)) {
            return false;
        }

        if (!isValidUSValue(value)) {
            return false;
        }
        //otherwise, return true.
        return true;
    }

    public boolean isValidSerialLength(String serialNumber) {
        //check if the length of the serialNumber is 10 characters.
        return serialNumber.length() == 10;
    }

    public boolean isValidSerialCharacters(String serialNumber) {
        char[] allChar = serialNumber.toCharArray();
        //for every character, check if it is a digit or a letter.
        for (int i = 0; i < 10; i++) {
            if (Character.isAlphabetic(allChar[i])) {
                continue;
            }
            if (Character.isDigit(allChar[i])) {
                continue;
            }
            //if at any point the character is not a digit or a letter, return false.
            return false;
        }
        //return true.
        return true;
    }

    public boolean isUniqueSerialNumber(String serialNumber) {
        //check if the serial number is unique.
        for (int i = 0; i < myInventory.getItems().size(); i++) {
            if (i != myInventory.getEditIndex()) {
                //if the parameter matches the serial number at the specified index, return false.
                if (serialNumber.equalsIgnoreCase(myInventory.getItems().get(i).getSerialNumber())) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidNameLength(String name) {
        //ensure that the length of the name is between 2 and 256 characters.
        return name.trim().length() >= 2 && name.length() <= 256;
    }

    public boolean isValidNumericValue(String value) {
        //ensure that the value passed is a correct value.
        try {
            //try parsing the value as a double. If not, catch the errors.
            Double.parseDouble(value);
        } catch (NullPointerException | NumberFormatException e) {
            //return false if the String is not a correct value.
            return false;
        }
        return true;
    }

    public boolean isValidUSValue(String value) {
        //ensure that the value is a correct value in US dollars.
        if (value.contains(".")) {
            //split based on the "." character.
            String[] split = value.split("\\.");
            return split[1].length() <= 2;
        }
        return true;
    }
}
