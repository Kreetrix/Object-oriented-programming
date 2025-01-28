package Task1;

import java.util.ArrayList;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String item){
        groceryList.add(item);
    }

    public void removeItem(String item){
        groceryList.remove(item);
    }

    public void displayList(){
        groceryList.forEach(System.out::println);
    }

    public boolean checkItem(String item){
        for (String s : groceryList) {
            if (s.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GroceryListManager groceryListManager = new GroceryListManager();

        groceryListManager.addItem("bun");
        groceryListManager.addItem("grass");
        groceryListManager.addItem("banana");
        groceryListManager.addItem("lemon");

        groceryListManager.displayList();
        String itemCheck = "lemon";
        System.out.printf("Item %s %s present\n", itemCheck, groceryListManager.checkItem(itemCheck) ? "is" : "is not");

        groceryListManager.removeItem("bun");

        groceryListManager.displayList();
    }
}