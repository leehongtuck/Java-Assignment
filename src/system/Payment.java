package system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment implements ActionListener{
    JFrame frame;
    JTextField txtRM100,txtRM50,txtRM20,txtRM10,txtRM5,txtRM1,txtSen50,txtSen20,txtSen10;
    JButton btnPay, btnBack;
    Payment() {
        //Frame
        frame = new JFrame();
        frame.setResizable(false);
        frame.setLocation(600,300);
        frame.setSize(300, 300);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title Panel
        JPanel pnlTitle = new JPanel();
        pnlTitle.setLayout(new FlowLayout());
        JLabel lblTitle = new JLabel("Make Payment", SwingConstants.CENTER);
        pnlTitle.add(lblTitle);

        //Form Panel
        JPanel pnlForm = new JPanel();
        pnlForm.setLayout(new GridLayout(0, 3, 10, 10));
        pnlForm.setBorder(new EmptyBorder(10, 5, 10, 5));
        JPanel pnlRM100 = new JPanel();
        JLabel lblRM100 = new JLabel("RM100");
        txtRM100 = new JTextField("0",5);
        pnlRM100.add(lblRM100);
        pnlRM100.add(txtRM100);
        JPanel pnlRM50 = new JPanel();
        JLabel lblRM50 = new JLabel("RM50");
        txtRM50 = new JTextField("0",5);
        pnlRM50.add(lblRM50);
        pnlRM50.add(txtRM50);
        JPanel pnlRM20 = new JPanel();
        JLabel lblRM20 = new JLabel("RM20");
        txtRM20 = new JTextField("0",5);
        pnlRM20.add(lblRM20);
        pnlRM20.add(txtRM20);
        JPanel pnlRM10 = new JPanel();
        JLabel lblRM10 = new JLabel("RM10");
        txtRM10 = new JTextField("0",5);
        pnlRM10.add(lblRM10);
        pnlRM10.add(txtRM10);
        JPanel pnlRM5 = new JPanel();
        JLabel lblRM5 = new JLabel("RM5");
        txtRM5 = new JTextField("0",5);
        pnlRM5.add(lblRM5);
        pnlRM5.add(txtRM5);
        JPanel pnlRM1 = new JPanel();
        JLabel lblRM1 = new JLabel("RM1");
        txtRM1 = new JTextField("0",5);
        pnlRM1.add(lblRM1);
        pnlRM1.add(txtRM1);
        JPanel pnlSen50 = new JPanel();
        JLabel lblSen50 = new JLabel("50 sen");
        txtSen50 = new JTextField("0",5);
        pnlSen50.add(lblSen50);
        pnlSen50.add(txtSen50);
        JPanel pnlSen20 = new JPanel();
        JLabel lblSen20 = new JLabel("20 sen");
        txtSen20 = new JTextField("0",5);
        pnlSen20.add(lblSen20);
        pnlSen20.add(txtSen20);
        JPanel pnlSen10 = new JPanel();
        JLabel lblSen10 = new JLabel("10 sen");
        txtSen10 = new JTextField("0",5);
        pnlSen10.add(lblSen10);
        pnlSen10.add(txtSen10);


        pnlForm.add(pnlRM100);
        pnlForm.add(pnlRM50);
        pnlForm.add(pnlRM20);
        pnlForm.add(pnlRM10);
        pnlForm.add(pnlRM5);
        pnlForm.add(pnlRM1);
        pnlForm.add(pnlSen50);
        pnlForm.add(pnlSen20);
        pnlForm.add(pnlSen10);


        //Button panel
        JPanel pnlButton = new JPanel();
        pnlButton.setLayout(new FlowLayout());
        btnPay = new JButton("Pay");
        btnBack = new JButton("Cancer Order");
        btnPay.addActionListener(this);
        btnBack.addActionListener(this);
        pnlButton.add(btnBack);
        pnlButton.add(btnPay);

        //add panels to frame
        frame.add(pnlTitle, BorderLayout.NORTH);
        frame.add(pnlForm, BorderLayout.CENTER);
        frame.add(pnlButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void show() {
        new Payment();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnPay)) {
            String totalAmount[] = {
                txtRM100.getText(), txtRM50.getText(), txtRM20.getText(), txtRM10.getText(), txtRM5.getText(),
                txtRM1.getText(), txtSen50.getText(), txtSen20.getText(), txtSen10.getText()
            };

            Operation.processPayment(frame, totalAmount);
        }else if (e.getSource().equals(btnBack)){
            Operation.clearOrderList();
            frame.setVisible(false);
            Index.frame.setVisible(true);
        }
    }
}
