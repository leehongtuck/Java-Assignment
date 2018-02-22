package system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmOrder implements ActionListener {
    static JFrame frame;
    JButton btnCancel, btnBack, btnPurchase;
    ConfirmOrder(){
        //Frame
        frame = new JFrame();
        frame.setResizable(false);
        frame.setLocation(600, 300);
        frame.setSize(400,233);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title Panel
        JPanel pnlTitle = new JPanel();
        pnlTitle.setLayout(new FlowLayout());
        JLabel lblTitle = new JLabel("Confirm Order",SwingConstants.CENTER);
        pnlTitle.add(lblTitle);

        //Form Panel
        JPanel pnlOrderDetails = new JPanel();
        Operation.loadOrder(pnlOrderDetails);

        //Button panel
        JPanel pnlButton = new JPanel();
        pnlButton.setLayout(new FlowLayout());
        btnBack = new JButton("Edit Order");
        btnCancel = new JButton("Cancel Order");
        btnPurchase = new JButton("Purchase");
        btnBack.addActionListener(this);
        btnCancel.addActionListener(this);
        btnPurchase.addActionListener(this);
        pnlButton.add(btnCancel);
        pnlButton.add(btnBack);
        pnlButton.add(btnPurchase);

        //add panels to frame
        frame.add(pnlTitle, BorderLayout.NORTH);
        frame.add(pnlOrderDetails, BorderLayout.CENTER);
        frame.add(pnlButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    public static void show(){
        new ConfirmOrder();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnCancel){
            Operation.clearOrderList();
            Menu.frame.dispose();
            frame.dispose();
            Index.frame.setVisible(true);
        } else if(e.getSource()==btnPurchase){
            frame.setVisible(false);
            Payment.show();
        } else if(e.getSource().equals(btnBack)){
            Operation.clearOrderList();
            frame.dispose();
            Menu.frame.setVisible(true);
        }
    }
}
