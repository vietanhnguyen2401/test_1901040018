import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO: your code here
        BookManager bookMan = new BookManager();
        Scanner sc = new Scanner(System.in);
        int option;
        while (true) {
            System.out.println("----------------------------------");
            System.out.println("1. list all books");
            System.out.println("2. add a new book");
            System.out.println("3. edit book");
            System.out.println("4. delete a book");
            System.out.println("5. search book by name");
            System.out.println("6. sort book descending by price");
            System.out.println();
            System.out.println("0. save and exit");
            System.out.println("----------------------------------");
            System.out.print("Your option: ");
            try {
                option = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid option!");
                sc.nextLine();
                continue;
            }
            switch (option) {
                case 0:
                    bookMan.saveToFile();
                    return;
                case 1:
                    bookMan.printBooks(bookMan.getBooks());
                    break;
                case 2:
                    try {
                        int id2;
                        String name2;
                        double price2;
                        System.out.print("Enter book id: ");
                        id2 = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter book name: ");
                        name2 = sc.nextLine();
                        System.out.print("Enter book price: ");
                        price2 = sc.nextDouble();
                        Book book2 = new Book(id2, name2, price2);
                        bookMan.add(book2);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input!");
                        sc.nextLine();
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Enter book id: ");
                        int id3 = sc.nextInt();
                        sc.nextLine();
                        Book book3 = bookMan.getBookById(id3);
                        if (book3 != null) {
                            System.out.print("Enter book name: ");
                            String name3 = sc.nextLine();
                            System.out.print("Enter book price: ");
                            double price3 = sc.nextDouble();
                            book3.setName(name3);
                            book3.setPrice(price3);
                            System.out.println("Updated successfully.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input!");
                        sc.nextLine();
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Enter book id: ");
                        int id4 = sc.nextInt();
                        bookMan.remove(bookMan.getBookById(id4));
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input!");
                        sc.nextLine();
                    }
                    break;
                case 5:
                    try {
                        System.out.print("Enter keyword: ");
                        String keyword = sc.nextLine();
                        ArrayList<Book> book5 = bookMan.searchByName(keyword);
                        bookMan.printBooks(bookMan.searchByName(keyword));
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input!");
                        sc.nextLine();
                    }
                    break;
                case 6:
                    bookMan.sortDescByPrice();
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}
