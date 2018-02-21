package system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Operation {

    private static NumberFormat formatter = NumberFormat.getCurrencyInstance();
    private static ArrayList<Staff> staffList = new ArrayList<Staff>();
    private static ArrayList<Customer> customerList = new ArrayList<Customer>();
    private static ArrayList<Order> orderList = new ArrayList<Order>();
    private static Customer currentCustomer;
    private static PrintWriter p;

    public static void login(JFrame frame, String staffUsername, String staffPw) {
        boolean status = false;
        try {
            Scanner sc = new Scanner(new File("staff.txt"));
            while (sc.hasNext()) {
                String username = sc.nextLine();
                String pw = sc.nextLine();
                sc.nextLine();
                Staff s = new Staff(username, pw);
                staffList.add(s);
            }
        } catch (IOException ex) {
            System.out.println("File not found!");
            JOptionPane.showMessageDialog(frame,
                    "There are currently no staff records, please register a staff before using this system.");
            return;
        }

        for (Staff s : staffList)
            if ((staffUsername.equals(s.getUsername())) && (staffPw.equals(s.getPw()))) {
                status = true;
            }

        if (status) {
            JOptionPane.showMessageDialog(frame,
                    "Login successful.");
            Index.show();
            frame.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(frame,
                    "Username or Password do not match.");
        }
    }


    public static void load() {
        try {
            Scanner sc = new Scanner(new File("customer.txt"));
            while (sc.hasNext()) {
                String id = sc.nextLine();
                String name = sc.nextLine();
                sc.nextLine();
                Customer c = new Customer(id, name);
                customerList.add(c);
            }
        } catch (IOException ex) {
            System.out.println("File not found!");
            File file = new File("customer.txt");

            // if file doesnt exists, then create it
            try {
                file.createNewFile();

            } catch (IOException e) {
                System.out.println("File cant be created.");
            }

        }
    }

    public static void registerStaff(JFrame frame, String id, String password) {
        try {
            p = new PrintWriter(new FileWriter("staff.txt", true));

        } catch (IOException e) {
            System.out.println("File not found");
            File file = new File("staff.txt");
            // if file doesnt exists, then create it
            try {
                file.createNewFile();
                p = new PrintWriter("staff.txt");

            } catch (IOException ex) {
                System.out.println("File cant be created.");
            }
        } finally {
            p.println(id);
            p.println(password);
            p.println();
            p.close();
            JOptionPane.showMessageDialog(frame,
                    "You have successfully registered as a staff.");
            frame.setVisible(false);
            Login.frame.setVisible(true);
        }
    }

    public static void register(JFrame frame, String id, String name) {

        try {
            for (Customer c : customerList) {
                if (id.equals(c.getId())) {
                    JOptionPane.showMessageDialog(frame,
                            "This student Id has been registered. Please use a different one.");
                    return;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("No records");
        }
        Customer c = new Customer(id, name);
        customerList.add(c);
        JOptionPane.showMessageDialog(frame,
                "You have successfully registered a customer.");
        frame.setVisible(false);
        new Index();
    }

    public static void logout(JFrame frame) {
        try {
            p = new PrintWriter("customer.txt");

            for (Customer c : customerList) {
                p.println(c.getId());
                p.println(c.getName());
                p.println();
            }
            p.close();
        } catch (IOException e) {

        }
        frame.setVisible(false);
        Login.frame.setVisible(true);
    }

    public static void order(String menuItems[], double menuPrice[], int menuQty[]) {
        for (int i = 0; i < menuItems.length; i++) {
            if (menuQty[i] > 0) {
                Order o = new Order(menuItems[i], menuQty[i], menuPrice[i]);
                orderList.add(o);
            }
        }
    }

    public static void loadOrder(JPanel pnlOrderDetails) {
        pnlOrderDetails.setLayout(new BoxLayout(pnlOrderDetails, BoxLayout.PAGE_AXIS));
        pnlOrderDetails.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel lbl;
        double totalPrice = 0;
        for (Order o : orderList) {
            lbl = new JLabel(o.getItem() + ": " + formatter.format(o.getTotalPrice()));
            pnlOrderDetails.add(lbl);
            totalPrice += o.getTotalPrice();
        }
        lbl = new JLabel("Total Price: " + formatter.format((totalPrice)));
        pnlOrderDetails.add(lbl);

    }

    public static void processPayment(JFrame frame, String totalAmount[]) {
        double[] value = {
                100, 50, 20, 10, 5, 1, 0.5, 0.2, 0.1
        };

        double totalPaid = 0;
        double totalPrice = 0;

        for (int i = 0; i < totalAmount.length; i++) {
            try {
                totalPaid += Integer.parseInt(totalAmount[i]) * value[i];
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame,
                        "Please make sure all fields are filled with numbers, put a 0 for notes/coins that are not paid with.");
                return;
            }
        }

        ArrayList<String> orderItems = new ArrayList<String>();
        for (Order o : orderList) {
            totalPrice += o.getTotalPrice();
            orderItems.add(o.getItem());
        }

        Transaction t = new Transaction(currentCustomer.getId(), orderItems);

        if (totalPaid > totalPrice) {
            t.write();
            JOptionPane.showMessageDialog(frame,
                    "Thank you for your payment. Your change is " + formatter.format(totalPaid - totalPrice));
            orderList.clear();
            frame.setVisible(false);
            Index.show();

        } else if (totalPaid == totalPrice) {
            t.write();
            JOptionPane.showMessageDialog(frame,
                    "Thank you for your payment.");
            orderList.clear();
            frame.setVisible(false);
            Index.show();
        } else {
            JOptionPane.showMessageDialog(frame,
                    "Your payment is not sufficient.Please top up additional " + formatter.format(totalPrice - totalPaid));
        }
    }

    public static void validateCustomer(JFrame frame, String id) {
        try {
            for (Customer c : customerList) {
                if (id.equals(c.getId())) {
                    currentCustomer = c;
                    Menu.show();
                    frame.setVisible(false);
                    return;
                }
            }
        } catch (NullPointerException e) {
            return;
        }
        JOptionPane.showMessageDialog(frame,
                "Your record does not exist, please register as a customer.");

    }

    public static void clearOrderList() {
        orderList.clear();
    }

}

