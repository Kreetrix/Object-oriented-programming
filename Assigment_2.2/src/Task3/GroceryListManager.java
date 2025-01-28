package Task3;

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

        Item(String name, double cost, String category) {
            this.name = name;
            this.cost = cost;
            this.category = category;
        }
    }

    public void addItem(String item, double cost, String category) {
        Item newItem = new Item(item, cost, category);
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



    public static void main(String[] args) {
        GroceryListManager groceryListManager = new GroceryListManager();

        groceryListManager.addItem("bun", 12.0, "Fish");
        groceryListManager.addItem("grass", 1.0, "Vegetables");
        groceryListManager.addItem("banana", 33.0, "Fruits");
        groceryListManager.addItem("lemon", 9.9, "Fruits");

        groceryListManager.displayByCategory("Fish");

//        groceryListManager.displayList();
//        String itemCheck = "lemon";
//        System.out.printf("Item %s %s present\n", itemCheck, groceryListManager.checkItem(itemCheck) ? "is" : "is not");
//
//        groceryListManager.removeItem("bun");
//
//        groceryListManager.displayList();
    }
}