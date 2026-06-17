import java.util.*;

abstract class Library {

    int id;
    String name;
    private double price;

    Library(int id, String name, double price) {
        this.id = id;
        this.name = name;
        setPrice(price);
    }

    abstract void issueItem();

    void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Invalid Price");
        }
    }

    double getPrice() {
        return price;
    }

    void display() {
        System.out.println("Id      : " + id);
        System.out.println("Name    : " + name);
        System.out.println("Price   : Rs." + getPrice());
    }
}

class Book extends Library {

    Book(int id, String name, double price) {
        super(id, name, price);
    }

    void issueItem() {
        System.out.println(name + " Book Issued Successfully");
    }
}

class Magazine extends Library {

    Magazine(int id, String name, double price) {
        super(id, name, price);
    }

    void issueItem() {
        System.out.println(name + " Magazine Issued Successfully");
    }
}

public class LibraryManagementSystem {

    static ArrayList<Library> items = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void searchItem(int itemId) {

        for (Library item : items) {
            if (item.id == itemId) {
                System.out.println("\nItem Found");
                item.display();
                return;
            }
        }

        System.out.println("Item Not Found");
    }

    static void issueItem(int itemId) {

        for (Library item : items) {
            if (item.id == itemId) {
                item.issueItem();
                return;
            }
        }

        System.out.println("Item Not Found");
    }

    static Book createBook() {

        System.out.print("Enter Book Id : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Book Price : ");
        double price = sc.nextDouble();

        return new Book(id, name, price);
    }

    static Magazine createMagazine() {

        System.out.print("Enter Magazine Id : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Magazine Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Magazine Price : ");
        double price = sc.nextDouble();

        return new Magazine(id, name, price);
    }

    public static void main(String[] args) {

        items.add(new Book(101, "Wings of Fire", 700));
        items.add(new Magazine(201, "India Today", 200));

        while (true) {
            System.out.println("------------------------------------");
            System.out.println("             Library Menu           ");
            System.out.println("------------------------------------");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Issue Item");
            System.out.println("4. Search Item");
            System.out.println("5. Display All Items");
            System.out.println("6. Exit");
            System.out.print("Enter Choice : ");

            int op = sc.nextInt();

            switch (op) {

                case 1:

                    items.add(createBook());
                    System.out.println("Book Added Successfully!");
                    break;

                case 2:

                    items.add(createMagazine());
                    System.out.println("Magazine Added Successfully!");
                    break;

                case 3:

                    System.out.print("Enter Item Id : ");
                    int issueId = sc.nextInt();
                    issueItem(issueId);
                    break;

                case 4:

                    System.out.print("Enter Item Id : ");
                    int searchId = sc.nextInt();
                    searchItem(searchId);
                    break;

                case 5:

                    for (Library item : items) {
                        System.out.println();
                        item.display();
                    }
                    break;

                case 6:

                    System.out.println("Thank You");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}