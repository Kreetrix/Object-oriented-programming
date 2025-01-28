package Task4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroceryListManager {
    private Map<String, List<Item>> groceryList;

    public GroceryListManager() {
        groceryList = new HashMap<>();
    }

    private static class Item {
        String name;
        double cost;
        String category;
        int quantity;

        Item(String name, double cost, String category, int quantity) {
            this.name = name;
            this.cost = cost;
            this.category = category;
            this.quantity = quantity;
        }
    }

    public void addItem(String item, double cost, String category, int quantity) {
        Item newItem = new Item(item, cost, category, quantity);
        groceryList.putIfAbsent(category, new ArrayList<>());
        groceryList.get(category).add(newItem);
    }

    public void removeItem(String item){
        groceryList.remove(item);
    }

    public void displayList(){
        groceryList.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public void displayByCategory(String category) {
        if (groceryList.containsKey(category)) {
            System.out.printf("Items in category '%s': ", category);
            for (Item item : groceryList.get(category)) {
                System.out.printf("- %s cost: %.2f", item.name, item.cost);
            }
        } else {
            System.out.printf("No items found in category %s\n", category);
        }
    }

    public boolean checkItem(String item){
        return groceryList.containsKey(item);
    }

    public void updateQuantity(String item, int quantity) {
        for (List<Item> items : groceryList.values()) {
            for (Item i : items) {
                if (i.name.equals(item)) {
                    i.quantity = quantity;
                    return;
                }
            }
        }
    }

    public void displayAvailableItems() {
        System.out.println("Available Items:");
        for (Map.Entry<String, List<Item>> entry : groceryList.entrySet()) {

            String category = entry.getKey();
            System.out.printf("Category: %s ", category);

            for (Item item : entry.getValue()) {
                if (item.quantity > 0) {
                    System.out.printf("- %s cost: %.2f quantity: %d\n", item.name, item.cost, item.quantity);
                }
            }
        }
    }



    public static void main(String[] args) {
        GroceryListManager groceryListManager = new GroceryListManager();

        groceryListManager.addItem("bun", 12.0, "Fish", 20);
        groceryListManager.addItem("grass", 1.0, "Vegetables", 5);
        groceryListManager.addItem("banana", 33.0, "Fruits", 10);
        groceryListManager.addItem("lemon", 9.9, "Fruits", 20);

        groceryListManager.displayByCategory("Fish");
        groceryListManager.updateQuantity("lemon", 10);
        groceryListManager.displayAvailableItems();
//        groceryListManager.displayList();
//        String itemCheck = "lemon";
//        System.out.printf("Item %s %s present\n", itemCheck, groceryListManager.checkItem(itemCheck) ? "is" : "is not");
//
//        groceryListManager.removeItem("bun");
//
//        groceryListManager.displayList();
    }
}