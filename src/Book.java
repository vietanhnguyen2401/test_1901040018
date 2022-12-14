import java.io.File;
import java.io.Serializable;
import java.util.Scanner;

import static java.lang.System.out;

public class Book {
    // TODO: your code here
    // attributes id, name, price
    int id;
    String name;
    double price;

    // constructor
    public Book(int id, String name, double price) {
        // TODO: your code here
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        // TODO: your code here
        this.name = name;
    }

    public void setPrice(double price) {
        // TODO: your code here
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /**
     * return this as a String in the required format
     */
    @Override
    public String toString() {
        // TODO: your code here
        return String.format("%5d %-45s %10.2f", id, name, price);
    }
}