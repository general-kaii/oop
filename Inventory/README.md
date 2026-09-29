# Farmer Inventory

A small console inventory tracker for farm goods. It can record crops, livestock, and farm supplies, list current stock, and add or remove quantities.

## Inheritance

`InventoryItem` is the abstract parent class. `Crop`, `Livestock`, and `FarmSupply` inherit its shared name, quantity, unit, and stock operations. Each child overrides category and detail methods, so the inventory list can display different item types through the same `InventoryItem` collection.

Each Java source file is in its own folder under `src`, named for its class. For example, `Main.java` is in `src/main`.

## Run

Requires JDK 17 or newer. From the `Inventory` folder, compile and run:

```powershell
javac -d bin --source-path src src/main/Main.java
java -cp bin main.Main
```

The data is kept in memory while the program runs and is cleared when it exits.
