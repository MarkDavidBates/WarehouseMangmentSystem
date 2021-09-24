# Warehouse Mangment System
Date Structures Assignment using Generic Lists to create a warehouse stock management system

## How it works
This Assignment combines knowlege i learned in my module Data Structures and Algorithms 1 where
learned about the use of Linked and Generic Lists and how they are implemented. This project
takes what was taught in that module and applied to this assignment.

![alt text](https://github.com/MarkDavidBates/WarehouseMangmentSystem/blob/main/images/warehouse%20GUI.png)

The Warehouse is broken into 4 parts:
- Floor
- Aisle
- Shelf
- Pallet

The project builds on a simple CRUD design that links every node of the Aisles, Shelves and Pallets
to the inital Floor node. This allows for there to be a Reset Warehouse method that deletes all
nodes in the list by only deleting the generic list of Floors.
It also has a save/load method implemented that allows you to keep the setup you have ina an xml
file.
Additionally, You can view all of the stock listings all at once or individually.

## Tools Used
- Intellij
- Scene Builder
