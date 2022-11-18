import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class BookManager {
    // TODO: your code here
    // attribute books
    ArrayList<Book> books = new ArrayList<>();

    public BookManager() {
        // TODO: your code here
        loadFromFile();
    }

    public ArrayList<Book> getBooks() {
        // TODO: your code here
        return books;
    }

    /**
     * update this.books by reading books from file books.txt
     */
    public void loadFromFile() {
        System.out.println("Loading books...");
        // TODO: your code here
        try {
            File file = new File("books.txt");
            Scanner sc = new Scanner(file);
            ArrayList<String> content = new ArrayList<>();
            while (sc.hasNext()) {
                content.add(sc.nextLine());
            }
            for (String s : content) {
                if (!s.isEmpty()) {
                    String name = s.substring(6, 51).trim();
                    int id = Integer.parseInt(s.substring(0, 5).trim());
                    double price = Double.parseDouble(s.substring(51).trim());
                    Book b = new Book(id, name, price);
                    books.add(b);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can not access to the file \"books.txt\"");
        }

    }

    /**
     * print books (one/line) in required format
     */
    public void printBooks(ArrayList<Book> books) {
        // TODO: your code here
        if (!books.isEmpty()) {
            System.out.printf("%-5s %-45s %-10s\n", "ID", "Name", "Price");
            for (int i = 0; i < books.size(); i++) {
                System.out.println(books.get(i));
            }
        } else {
            System.out.println("(empty)");
        }
    }

    /**
     * if book.id is not duplicated, add book to this.books
     * return whether added or not
     */
    public boolean add(Book book) {
        // TODO: your code here
        for (int i = 0; i < books.size(); i++) {
            if (book.getId() == books.get(i).getId()) {
                System.out.println("Duplicated ID!");
                return false;
            }
        }
        books.add(book);
        System.out.println("Added successfully.");
        return true;
    }

    /**
     * return book specified by id, null if not found
     */
    public Book getBookById(int id) {
        // TODO: your code here
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        System.out.println("Invalid ID!");
        return null;
    }

    /**
     * remove book from this.books
     */
    public void remove(Book book) {
        // TODO: your code here
        for (int i = 0; i < books.size(); i++) {
            if (books.remove(book)) {
                System.out.println("Deleted successfully.");
                return;
            }
        }
    }

    /**
     * update this.books to be sorted by price from high -> low
     */
    public void sortDescByPrice() {
        // TODO: your code here
        ArrayList<Book> list = books;
        list.sort(Comparator.comparing(Book::getPrice).reversed());
        System.out.println("After sorting:");
        System.out.printf("%-5s %-45s %-10s\n", "ID", "Name", "Price");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }

    /**
     * return all books having name contains keyword (case in-sensitive)
     */
    public ArrayList<Book> searchByName(String keyword) {
        ArrayList<Book> matches = new ArrayList<>();
        // TODO: your code here
        for (Book book : books) {
            if (book.name.toLowerCase().contains(keyword.toLowerCase())) {
                matches.add(book);
            }
        }
        return matches;
    }

    /**
     * write this.books to file books.txt in required format
     */
    public void saveToFile() {
        // TODO: your code here
        try {
            File file = new File("books.txt");
            PrintWriter printWriter = new PrintWriter(file);
            for (Book book : books) {
                printWriter.println(book);
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Saving to file...");
        System.out.println("Bye!");
    }
}