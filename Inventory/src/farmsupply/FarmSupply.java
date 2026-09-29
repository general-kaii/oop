package farmsupply;

import inventoryitem.InventoryItem;

public class FarmSupply extends InventoryItem {
    private final String purpose;

    public FarmSupply(String name, int quantity, String unit, String purpose) {
        super(name, quantity, unit);
        this.purpose = purpose;
    }

    @Override
    public String getCategory() {
        return "Farm supply";
    }

    @Override
    protected String getDetails() {
        return "Use: " + purpose;
    }
}