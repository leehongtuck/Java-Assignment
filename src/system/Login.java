package system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Login implements ActionListener{
    JFrame frame;
    JTextField txtUsername;
    JPasswordField txtPw;
   Login(){
       //Frame
       frame = new JFrame();
       frame.setSize(300,233);
       frame.setLayout(new BorderLayout());
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       //Title Panel
       JPanel pnlTitle = new JPanel();
       pnlTitle.setLayout(new FlowLayout());
       JLabel lblTitle = new JLabel("Staff Login System",SwingConstants.CENTER);
       pnlTitle.add(lblTitle);

       //Form Panel
       JPanel pnlForm = new JPanel();
       pnlForm.setLayout(new GridLayout(2,1));
       pnlForm.setBorder(new EmptyBorder(10,5,10,5));
       JPanel pnlUsername = new JPanel();
       JLabel lblUsername= new JLabel("Username");
       txtUsername = new JTextField(20);
       pnlUsername.add(lblUsername);
       pnlUsername.add(txtUsername);
       JPanel pnlPw = new JPanel();
       JLabel lblPw = new JLabel("Password");
       txtPw = new JPasswordField(20);
       pnlPw.add(lblPw);
       pnlPw.add(txtPw);
       pnlForm.add(pnlUsername);
       pnlForm.add(pnlPw);

       //Button panel
       JPanel pnlButton = new JPanel();
       pnlButton.setLayout(new FlowLayout());
       JButton btnLogin = new JButton("Login");
       btnLogin.addActionListener(this);
       pnlButton.add(btnLogin);

       //add panels to frame
       frame.add(pnlTitle, BorderLayout.NORTH);
       frame.add(pnlForm, BorderLayout.CENTER);
       frame.add(pnlButton, BorderLayout.SOUTH);
       frame.setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        String staffUsername = txtUsername.getText();
        String staffPw = String.valueOf(txtPw.getPassword());
        boolean login = Operation.login(staffUsername, staffPw);
        if(login){
            JOptionPane.showMessageDialog(frame,
                    "Login successful.");
            Index.show();
            frame.setVisible(false);

        }else{
            JOptionPane.showMessageDialog(frame,
                    "Username or Password do not match.");
        }

    }
}
