package inventoryitem;

public abstract class InventoryItem {
    private final String name;
    private final String unit;
    private int quantity;

    protected InventoryItem(String name, int quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public abstract String getCategory();

    protected abstract String getDetails();

    public void addStock(int amount) {
        quantity += amount;
    }

    public boolean removeStock(int amount) {
        if (amount > quantity) {
            return false;
        }
        quantity -= amount;
        return true;
    }

    @Override
    public String toString() {
        return getCategory() + " | " + name + " | " + quantity + " " + unit + " | " + getDetails();
    }
}