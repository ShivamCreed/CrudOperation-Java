import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    private int id;
    public String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class CRUDApplication {
    private List<Item> itemList;
    private int nextItemId;

    public CRUDApplication() {
        itemList = new ArrayList<>();
        nextItemId = 1;
    }

    public void addItem(String name) {
        Item item = new Item(nextItemId, name);
        itemList.add(item);
        nextItemId++;
        System.out.println("Item added successfully.");
    }

    public void updateItem(int id, String newName) {
        for (Item item : itemList) {
            if (item.getId() == id) {
                item.name = newName;
                System.out.println("Item updated successfully.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    public void deleteItem(int id) {
        for (Item item : itemList) {
            if (item.getId() == id) {
                itemList.remove(item);
                System.out.println("Item deleted successfully.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    public void displayItems() {
        if (itemList.isEmpty()) {
            System.out.println("No items found.");
        } else {
            for (Item item : itemList) {
                System.out.println("ID: " + item.getId() + ", Name: " + item.getName());
            }
        }
    }

    public static void main(String[] args) {
        CRUDApplication app = new CRUDApplication();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an operation:");
            System.out.println("1. Add item");
            System.out.println("2. Update item");
            System.out.println("3. Delete item");
            System.out.println("4. Display items");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    app.addItem(name);
                    break;
                case 2:
                    System.out.print("Enter item ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    app.updateItem(id, newName);
                    break;
                case 3:
                    System.out.print("Enter item ID: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    app.deleteItem(deleteId);
                    break;
                case 4:
                    app.displayItems();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

            System.out.println();
        }
    }
}