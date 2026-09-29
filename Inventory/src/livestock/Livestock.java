package livestock;

import inventoryitem.InventoryItem;

public class Livestock extends InventoryItem {
    private final String breedOrType;

    public Livestock(String name, int quantity, String unit, String breedOrType) {
        super(name, quantity, unit);
        this.breedOrType = breedOrType;
    }

    @Override
    public String getCategory() {
        return "Livestock";
    }

    @Override
    protected String getDetails() {
        return "Breed/type: " + breedOrType;
    }
}