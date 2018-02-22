package system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditCustomer implements ActionListener{
    private String id;
    JFrame frame;
    JTextField txtId, txtName, txtPhone;
    JButton btnBack, btnUpdate;

    EditCustomer(String id, String name, String phone) {
        this.id = id;
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
        JLabel lblTitle = new JLabel("Edit Customer Details", SwingConstants.CENTER);
        pnlTitle.add(lblTitle);

        //Form Panel
        JPanel pnlForm = new JPanel();
        pnlForm.setLayout(new GridLayout(0, 2, 0, 10));
        pnlForm.setBorder(new EmptyBorder(10, 5, 10, 5));
        JPanel pnlId = new JPanel();
        JLabel lblName = new JLabel("Name");
        txtName = new JTextField(name, 15);
        JLabel lblPhone = new JLabel("Phone Number");
        txtPhone = new JTextField(phone,15);
        pnlForm.add(lblName);
        pnlForm.add(txtName);
        pnlForm.add(lblPhone);
        pnlForm.add(txtPhone);

        //Button panel
        JPanel pnlButton = new JPanel();
        pnlButton.setLayout(new FlowLayout());
        btnBack = new JButton("Cancel");
        btnUpdate = new JButton("Update Details");
        btnUpdate.addActionListener(this);
        btnBack.addActionListener(this);
        pnlButton.add(btnBack);
        pnlButton.add(btnUpdate);

        //add panels to frame
        frame.add(pnlTitle, BorderLayout.NORTH);
        frame.add(pnlForm, BorderLayout.CENTER);
        frame.add(pnlButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void show(String id, String name, String phone) {
        new EditCustomer(id, name, phone);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(btnUpdate)) {
            String name = txtName.getText();
            String phone = txtPhone.getText();
            if ((name.equals("")) || (phone.equals(""))) {
                JOptionPane.showMessageDialog(frame,
                        "Please fill up the text fields.");
            } else
                Operation.updateCustomer(frame, id, name, phone);
        } else if (e.getSource().equals(btnBack)) {
            frame.dispose();
            Index.frame.setVisible(true);
        }
    }
}
