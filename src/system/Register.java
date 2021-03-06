package system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register implements ActionListener {
    JFrame frame;
    JTextField txtId, txtName, txtPhone;
    JButton btnBack, btnRegister;

    Register() {
        //Frame
        frame = new JFrame();
        frame.setResizable(false);
        frame.setLocation(600, 300);
        frame.setSize(350, 230);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title Panel
        JPanel pnlTitle = new JPanel();
        pnlTitle.setLayout(new FlowLayout());
        JLabel lblTitle = new JLabel("Register Customer", SwingConstants.CENTER);
        pnlTitle.add(lblTitle);

        //Form Panel
        JPanel pnlForm = new JPanel();
        pnlForm.setLayout(new GridLayout(0, 2, 0, 10));
        pnlForm.setBorder(new EmptyBorder(10, 5, 10, 5));
        JPanel pnlId = new JPanel();
        JLabel lblId = new JLabel("Customer ID");
        txtId = new JTextField(15);

        JLabel lblName = new JLabel("Name");
        txtName = new JTextField(15);
        JLabel lblPhone = new JLabel("Phone Number");
        txtPhone = new JTextField(15);
        pnlForm.add(lblId);
        pnlForm.add(txtId);
        pnlForm.add(lblName);
        pnlForm.add(txtName);
        pnlForm.add(lblPhone);
        pnlForm.add(txtPhone);

        //Button panel
        JPanel pnlButton = new JPanel();
        pnlButton.setLayout(new FlowLayout());
        btnBack = new JButton("Cancel");
        btnRegister = new JButton("Register");
        btnRegister.addActionListener(this);
        btnBack.addActionListener(this);
        pnlButton.add(btnBack);
        pnlButton.add(btnRegister);

        //add panels to frame
        frame.add(pnlTitle, BorderLayout.NORTH);
        frame.add(pnlForm, BorderLayout.CENTER);
        frame.add(pnlButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void show() {
        new Register();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(btnRegister)) {
            String id = txtId.getText();
            String name = txtName.getText();
            String phone = txtPhone.getText();
            if ((id.equals("")) || (name.equals("")) || (phone.equals(""))) {
                JOptionPane.showMessageDialog(frame,
                        "Please fill up the text fields.");
            } else
                Operation.register(frame, id, name, phone);
        } else if (e.getSource().equals(btnBack)) {
            frame.dispose();
            Index.frame.setVisible(true);
        }
    }
}

