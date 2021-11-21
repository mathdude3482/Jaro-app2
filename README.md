# Inventory Manager

## Description

This inventory manager is a GUI-based application which allows for the management 
of at least 100 inventory items consisting of a monetary value in US dollars, a 
unique serial number in the format of A-XXX-XXX-XXX, where A must be a letter and X can be a letter or a 
digit, as well as an item name of a length between 2 and 256 characters in length (inclusive).

## Maneuvering the Inventory Manager

This application consists of three windows: the main "Inventory Manager" window, the "Add New Item" window,
and the "Edit Item" window. This section will discuss how to maneuver the "Inventory Manager" window
while the "Add New Item" window will be discussed in the "Adding an Item" section, and the "Edit Item"
window will be discussed in the "Editing an Item" section.

The "Inventory Manager" window consists of:
- A menu bar with a dropdown "File" with the options:
  - Save as...
  - Load
  - Close
- An item table with three columns:
  - Value
  - Serial Number
  - Name
- A text field labeled "Search here..." to find a specific item.
- Three buttons:
    - Add New Item
    - Remove Selected Item
    - Edit Selected Item
    
From the "File" menu button, a user is able to save, load, and close the application with the corresponding
options.

The item table displays all the inventory items added into the inventory and their value, serial number,
and name. A user is able to select any item by clicking on it which will allow for them to remove and edit
the selected item with the "Remove Selected Item" and "Edit Selected Item" buttons. The table can be sorted
by value, serial number, and name by clicking on the column headers.

The "Search here..." text field can be edited and allows for a dynamic search of the inventory's serial
numbers and names.

The "Add New Item" button opens up the "Add New Item" window where a user can add a new item into the inventory.

The "Remove Selected Item" button will remove an item that has been selected in an inventory, and will do nothing
if an item is not selected.

The "Edit Selected Item" button will open up the "Edit Item" window, and will do nothing if an item is not selected.

## Adding an Item

A user can add an item to the inventory by clicking on the "Add New Item button on the bottom"
of the screen. This opens a separate window with three text fields and two buttons.

The first text field labeled "Item Name" is where the user may put the name of the new inventory item.
This name must fit within the constraints of 2 and 256 characters inclusive (ignoring 
any extra whitespace characters at the beginning and end of the inserted name).

The second text field labeled "Serial Number" is where the user may put the unique serial number of
the new inventory item. This serial number must be in the format of A-XXX-XXX-XXX where X can be a letter
or a digit and A must be a letter.

The third text field labeled "Item Value" is where the user may put the monetary value of the new inventory
item. This monetary value must be a valid monetary value in US dollars.

At the bottom of the window is the "Add" button which will add the values entered into the three fields
as a new inventory item and close the window. If an invalid name, serial number, or monetary value is
entered, an error message will pop up displaying the respective value's constraints.

Also at the bottom of the window is the "Cancel" button which will discard all values entered into the
three text fields and close the window.

## Removing an Item

A user can remove an item from the inventory by selecting an item in the item table and by clicking the
"Remove Selected Item" button.

## Editing an Item

A user can edit an item from the inventory by selecting an item in the item table and by clicking the
"Edit Selected Item" button. This will pop up a new window with three text fields and two buttons.

The first text field labeled "Item Name" is where the user may put the edited name of the inventory item.
This name must fit within the constraints of 2 and 256 characters inclusive (ignoring any extra 
whitespace characters at the beginning and end of the inserted name).

The second text field labeled "Serial Number" is where the user may put the edited and unique
serial number of the inventory item. This serial number must be in the format of A-XXX-XXX-XXX where
X can be a letter or a digit and A must be a letter.

The third text field labeled "Item Value" is where the user may put new monetary value of the inventory
item. This monetary value must be a valid monetary value in US dollars.

At the bottom of the window is the "Edit" button which will set the values entered into the three fields
into the selected inventory item and close the window. A text field that is left empty will not be changed. 
If an invalid name, serial number, or monetary value is entered, an error message will pop up 
displaying the respective value's constraints.

Also at the bottom of the window is the "Cancel" button which will discard all values entered into the
three text fields and close the window.

## Sorting an Inventory

A user can sort the item table by clicking on any of the three column headers which will be able to sort
the table ascending & descending by monetary value, serial number, and by name.

## Searching the Inventory

A user can search through the inventory using the "Search here..." text field in the bottom left of the
screen. When a user types into this text field, the table will dynamically search for serial numbers
and names that contain the text entered into the "Search here..." text field.

## Saving an Inventory

A user can save the inventory by clicking on the "File" menu button and then clicking on "Save as...".
This will make a window pop-up in the user's C-drive from where the user can navigate to the location
where they want to save their inventory. The inventory can be saved as a TSV (.txt) file, an HTML (.html)
file, and as a JSON (.json) file.

## Loading an Inventory

A user can load a saved inventory by clicking on the "File" menu button and then clicking on "Load".
This will make a window pop-up in the user's C-drive from where the user can navigate to the location
where they want to load from. The only valid files that can be loaded are TSV (.txt) files, HTML (.html) files,
and JSON (.json) files.
