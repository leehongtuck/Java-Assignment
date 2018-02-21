package system;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Transaction {
    private String customer;
    private ArrayList<String> orderItems;
    private ZonedDateTime time;
    private PrintWriter p;

    public Transaction(String customer, ArrayList<String> orderItems) {
        this.customer = customer;
        this.orderItems = orderItems;
        time = ZonedDateTime.now();
    }

    public void write() {
        try {
           p = new PrintWriter(new FileWriter("transaction.txt", true));

        } catch (IOException e) {
            System.out.println("File not found");
            File file = new File("transaction.txt");
            // if file doesnt exists, then create it
            try {
                file.createNewFile();
                p = new PrintWriter("transaction.txt");

            } catch (IOException ex) {
                System.out.println("File cant be created.");
            }
        } finally {
            p.println(customer);
            p.println(orderItems);
            p.println(time);
            p.println();
            p.close();
        }
    }
}
