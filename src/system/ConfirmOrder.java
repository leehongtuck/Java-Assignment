package system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmOrder implements ActionListener {
    JFrame frame;
    JButton btnReturn, btnPurchase;
    ConfirmOrder(){
        //Frame
        frame = new JFrame();
        frame.setSize(300,233);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title Panel
        JPanel pnlTitle = new JPanel();
        pnlTitle.setLayout(new FlowLayout());
        JLabel lblTitle = new JLabel("Payment",SwingConstants.CENTER);
        pnlTitle.add(lblTitle);

        //Form Panel
        JPanel pnlOrderDetails = new JPanel();
        Operation.loadOrder(pnlOrderDetails);

        //Button panel
        JPanel pnlButton = new JPanel();
        pnlButton.setLayout(new FlowLayout());
        btnReturn = new JButton("Edit Order");
        btnPurchase = new JButton("Purchase");
        btnReturn.addActionListener(this);
        btnPurchase.addActionListener(this);
        pnlButton.add(btnReturn);
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
        if(e.getSource() == btnReturn){
            Menu.back();
        } else if(e.getSource()==btnPurchase){
            frame.setVisible(false);
            Payment.show();
        }
    }
}
