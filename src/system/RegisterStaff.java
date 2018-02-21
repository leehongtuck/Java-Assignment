package system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterStaff implements ActionListener {
    JFrame frame;
    JTextField txtId, txtPw;
    JButton btnBack, btnRegister;

    RegisterStaff() {
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
        JLabel lblTitle = new JLabel("Register Staff", SwingConstants.CENTER);
        pnlTitle.add(lblTitle);

        //Form Panel
        JPanel pnlForm = new JPanel();
        pnlForm.setLayout(new GridLayout(0, 2, 0, 10));
        pnlForm.setBorder(new EmptyBorder(10, 5, 10, 5));
        JPanel pnlId = new JPanel();
        JLabel lblId = new JLabel("Username");
        txtId = new JTextField(15);

        JLabel lblPw = new JLabel("Password");
        txtPw = new JTextField(15);
        pnlForm.add(lblId);
        pnlForm.add(txtId);
        pnlForm.add(lblPw);
        pnlForm.add(txtPw);

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

    public static void show(){
        new RegisterStaff();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegister)) {
            String id = txtId.getText();
            String password = txtPw.getText();
            if ((id.equals("")) || (password.equals(""))) {
                JOptionPane.showMessageDialog(frame,
                        "Please fill up the text fields.");
            } else
                Operation.registerStaff(frame, id, password);
        } else if (e.getSource().equals(btnBack)) {
            frame.setVisible(false);
            Login.frame.setVisible(true);
        }
    }
}
