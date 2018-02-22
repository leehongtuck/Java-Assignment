package system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Index implements ActionListener {
    static JFrame frame;
    JButton btnOrder, btnRegister, btnLogout, btnEdit;

    Index() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setLocation(600, 300);
        frame.setTitle("Index");
        frame.setSize(300, 233);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title Panel
        JPanel pnlTitle = new JPanel();
        pnlTitle.setLayout(new FlowLayout());
        pnlTitle.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel lblTitle = new JLabel("Index", SwingConstants.CENTER);
        pnlTitle.add(lblTitle);

        //Items Panel
        JPanel pnlItems = new JPanel();
        pnlItems.setLayout(new GridLayout(4, 0, 10, 10));
        pnlItems.setBorder(new EmptyBorder(10, 10, 10, 10));
        btnOrder = new JButton("Take Order");
        btnRegister = new JButton("Register Customer");
        btnEdit = new JButton("Edit Customer Details");
        btnLogout = new JButton("Logout");
        btnOrder.addActionListener(this);
        btnRegister.addActionListener(this);
        btnLogout.addActionListener(this);
        btnEdit.addActionListener(this);
        pnlItems.add(btnOrder);
        pnlItems.add(btnRegister);
        pnlItems.add(btnEdit);
        pnlItems.add(btnLogout);

        frame.add(pnlTitle, BorderLayout.NORTH);
        frame.add(pnlItems, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void show() {
        Operation.load();
        new Index();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnOrder)) {
            String id = JOptionPane.showInputDialog(
                    frame, "Enter Customer Id");
            if (id != null){
                Operation.validateCustomer(frame, id);
            }

        } else if (e.getSource().equals(btnRegister)) {
            Register.show();
            frame.setVisible(false);
        } else if (e.getSource().equals(btnLogout)) {
            Operation.logout(frame);
        } else if (e.getSource().equals(btnEdit)){
            String id = JOptionPane.showInputDialog(
                    frame, "Enter Customer Id");
            if (id != null){
                Operation.editCustomer(frame, id);
            }
        }
    }

}
