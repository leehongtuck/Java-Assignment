package system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Index implements ActionListener {
    JFrame frame;
    JButton btnOrder, btnRegister, btnLogout;

    Index() {
        frame = new JFrame();
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
        pnlItems.setLayout(new GridLayout(2, 1, 10, 10));
        pnlItems.setBorder(new EmptyBorder(10, 10, 10, 10));
        btnOrder = new JButton("Take Order");
        btnRegister = new JButton("Register Customer");
        btnLogout = new JButton("Logout");
        btnOrder.addActionListener(this);
        btnRegister.addActionListener(this);
        btnLogout.addActionListener(this);
        pnlItems.add(btnRegister);
        pnlItems.add(btnOrder);
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
            String id;
                id = JOptionPane.showInputDialog(
                        frame, "Enter Customer Id");

            Operation.validateCustomer(frame, id);
        } else if (e.getSource().equals(btnRegister)) {
            Register.show();
            frame.setVisible(false);
        } else if (e.getSource().equals(btnLogout)) {
            Operation.logout(frame);
        }
    }

}
