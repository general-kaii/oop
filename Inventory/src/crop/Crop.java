package crop;

import inventoryitem.InventoryItem;

public class Crop extends InventoryItem {
    private final String growingSeason;

    public Crop(String name, int quantity, String unit, String growingSeason) {
        super(name, quantity, unit);
        this.growingSeason = growingSeason;
    }

    @Override
    public String getCategory() {
        return "Crop";
    }

    @Override
    protected String getDetails() {
        return "Season: " + growingSeason;
    }
}