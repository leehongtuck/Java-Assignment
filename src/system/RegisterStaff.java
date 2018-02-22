package system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterStaff extends JFrame implements ActionListener {
    JTextField txtId;
    JPasswordField txtPw, txtCfmPw;
    JButton btnBack, btnRegister;

    RegisterStaff() {
        //Frame
        super();
        setResizable(false);
        setLocation(600, 300);
        setSize(350, 230);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title Panel
        JPanel pnlTitle = new JPanel();
        pnlTitle.setLayout(new FlowLayout());
        JLabel lblTitle = new JLabel("Register Staff", SwingConstants.CENTER);
        pnlTitle.add(lblTitle);

        //Form Panel
        JPanel pnlForm = new JPanel();
        pnlForm.setLayout(new GridLayout(0, 2, 0, 10));
        pnlForm.setBorder(new EmptyBorder(10, 5, 10, 5));
        JLabel lblId = new JLabel("Username");
        txtId = new JTextField(15);

        JLabel lblPw = new JLabel("Password");
        txtPw = new JPasswordField(15);
        JLabel lblCfmPw = new JLabel("Confirm Password");
        txtCfmPw = new JPasswordField(15);
        pnlForm.add(lblId);
        pnlForm.add(txtId);
        pnlForm.add(lblPw);
        pnlForm.add(txtPw);
        pnlForm.add(lblCfmPw);
        pnlForm.add(txtCfmPw);

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
        add(pnlTitle, BorderLayout.NORTH);
        add(pnlForm, BorderLayout.CENTER);
        add(pnlButton, BorderLayout.SOUTH);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegister)) {
            String id = txtId.getText();
            String password =  String.valueOf(txtPw.getPassword());
            String cfmPassword = String.valueOf(txtCfmPw.getPassword());
            if ((id.equals("")) || (password.equals("")) || (cfmPassword.equals(""))) {
                JOptionPane.showMessageDialog(this,
                        "Please fill up the text fields.");
            } else{
                if(password.equals(cfmPassword)){
                    Operation.registerStaff(this, id, password);
                }
                else {
                    JOptionPane.showMessageDialog(this,
                            "Passwords dont match.");
                }
            }

        } else if (e.getSource().equals(btnBack)) {
            this.setVisible(false);
            Login.frame.setVisible(true);
        }
    }
}
