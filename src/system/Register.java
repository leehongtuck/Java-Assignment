package system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register implements ActionListener {
    JFrame frame;
    JTextField txtId, txtName;

    Register(){
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
        JPanel pnlId = new JPanel();
        JLabel lblId= new JLabel("Student ID");
        txtId = new JTextField(20);
        pnlId.add(lblId);
        pnlId.add(txtId);
        JPanel pnlName = new JPanel();
        JLabel lblName = new JLabel("Name");
        txtName = new JTextField(20);
        pnlName.add(lblName);
        pnlName.add(txtName);
        pnlForm.add(pnlId);
        pnlForm.add(pnlName);

        //Button panel
        JPanel pnlButton = new JPanel();
        pnlButton.setLayout(new FlowLayout());
        JButton btnLogin = new JButton("Register");
        btnLogin.addActionListener(this);
        pnlButton.add(btnLogin);

        //add panels to frame
        frame.add(pnlTitle, BorderLayout.NORTH);
        frame.add(pnlForm, BorderLayout.CENTER);
        frame.add(pnlButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void show(){
        new Register();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = txtId.getText();
        String name = txtName.getText();
        Operation.register(frame, id, name);
    }
}
