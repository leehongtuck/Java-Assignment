package system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener{
    static JFrame frame;
    JTextField txtUsername;
    JPasswordField txtPw;
    JButton btnLogin, btnRegister;
   Login(){
       //Frame
       frame = new JFrame();
       frame.setResizable(false);
       frame.setLocation(600,300);
       frame.setSize(350,230);
       frame.setLayout(new BorderLayout());
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       //Title Panel
       JPanel pnlTitle = new JPanel();
       pnlTitle.setLayout(new FlowLayout());
       JLabel lblTitle = new JLabel("Cafeteria Ordering System",SwingConstants.CENTER);
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
       btnLogin = new JButton("Login");
       btnLogin.addActionListener(this);
       btnRegister = new JButton("Register Staff");
       btnRegister.addActionListener(this);
       pnlButton.add(btnRegister);
       pnlButton.add(btnLogin);

       //add panels to frame
       frame.add(pnlTitle, BorderLayout.NORTH);
       frame.add(pnlForm, BorderLayout.CENTER);
       frame.add(pnlButton, BorderLayout.SOUTH);
       frame.setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnLogin)) {
            String staffUsername = txtUsername.getText();
            String staffPw = String.valueOf(txtPw.getPassword());
            if ((staffUsername.equals("")) || (staffPw.equals(""))) {
                JOptionPane.showMessageDialog(frame,
                        "Please fill up the text fields.");
            }else
            Operation.login(frame, staffUsername, staffPw);

        }else if (e.getSource().equals(btnRegister)){
            frame.setVisible(false);
            RegisterStaff.show();
        }

    }
}
