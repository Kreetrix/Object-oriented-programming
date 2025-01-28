package Task2;

import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {
    private HashMap<String, Double> groceryList = new HashMap<>();

    public void addItem(String item, double cost){
        groceryList.put(item, cost);
    }

    public void removeItem(String item){
        groceryList.remove(item);
    }

    public void displayList(){
        groceryList.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public boolean checkItem(String item){
        return groceryList.containsKey(item);
    }

    public double calculateTotalCost(){
        double cost = 0.0;
        for (Map.Entry<String, Double> entry : groceryList.entrySet()) {
            cost += entry.getValue();
        }
        return cost;
    }

    public static void main(String[] args) {
        GroceryListManager groceryListManager = new GroceryListManager();

        groceryListManager.addItem("bun", 12.0);
        groceryListManager.addItem("grass", 1.0);
        groceryListManager.addItem("banana", 33.0);
        groceryListManager.addItem("lemon", 9.9);

        groceryListManager.displayList();
        String itemCheck = "lemon";
        System.out.printf("Item %s %s present\n", itemCheck, groceryListManager.checkItem(itemCheck) ? "is" : "is not");

        groceryListManager.removeItem("bun");

        groceryListManager.displayList();
    }
}