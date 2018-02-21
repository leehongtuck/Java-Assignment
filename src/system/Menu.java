package system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {
    Menu m;
    static JFrame frame;
    JTextField txtNasiLemak, txtRotiCanai, txtAsamLaksa, txtNasiGoreng;
    JButton btnOrder, btnBack;

    public Menu() {
        //Frame
        frame = new JFrame();
        frame.setResizable(false);
        frame.setLocation(600, 300);
        frame.setTitle("Menu");
        frame.setSize(300, 260);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title Panel
        JPanel pnlTitle = new JPanel();
        pnlTitle.setLayout(new FlowLayout());
        JLabel lblTitle = new JLabel("Food Menu", SwingConstants.CENTER);
        pnlTitle.add(lblTitle);

        //Items Panel
        JPanel pnlItems = new JPanel();
        pnlItems.setLayout(new GridLayout(3, 0, 10, 10));
        JPanel pnlNasiLemak = new JPanel();
        JLabel lblNasiLemak = new JLabel("Nasi Lemak");
        txtNasiLemak = new JTextField("0", 10);
        pnlNasiLemak.add(lblNasiLemak);
        pnlNasiLemak.add(txtNasiLemak);
        JPanel pnlRotiCanai = new JPanel();
        JLabel lblRotiCanai = new JLabel("Roti Canai");
        txtRotiCanai = new JTextField("0", 10);
        pnlRotiCanai.add(lblRotiCanai);
        pnlRotiCanai.add(txtRotiCanai);
        JPanel pnlAsamLaksa = new JPanel();
        JLabel lblAsamLaksa = new JLabel("Asam Laksa");
        txtAsamLaksa = new JTextField("0", 10);
        pnlAsamLaksa.add(lblAsamLaksa);
        pnlAsamLaksa.add(txtAsamLaksa);
        JPanel pnlNasiGoreng = new JPanel();
        JLabel lblNasiGoreng = new JLabel("Nasi Goreng");
        txtNasiGoreng = new JTextField("0", 10);
        pnlNasiGoreng.add(lblNasiGoreng);
        pnlNasiGoreng.add(txtNasiGoreng);

        pnlItems.add(pnlNasiLemak);
        pnlItems.add(pnlRotiCanai);
        pnlItems.add(pnlAsamLaksa);
        pnlItems.add(pnlNasiGoreng);

        //Button Panel
        JPanel pnlBtn = new JPanel();
        btnOrder = new JButton("Order");
        btnBack = new JButton("Cancel");
        btnOrder.addActionListener(this);
        btnBack.addActionListener(this);
        pnlBtn.add(btnBack);
        pnlBtn.add(btnOrder);


        frame.add(pnlTitle, BorderLayout.NORTH);
        frame.add(pnlItems, BorderLayout.CENTER);
        frame.add(pnlBtn, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnOrder)) {
            String menuItems[] = {
                    "Nasi Lemak", "Roti Canai", "Asam Laksa", "Nasi Goreng"
            };
            double menuPrice[] = {
                    1.5, 1.2, 2.0, 1.8
            };
            int menuQty[] = new int[menuItems.length];
            try {
                menuQty[0] = Integer.parseInt(txtNasiLemak.getText());
                menuQty[1] = Integer.parseInt(txtRotiCanai.getText());
                menuQty[2] = Integer.parseInt(txtAsamLaksa.getText());
                menuQty[3] = Integer.parseInt(txtNasiGoreng.getText());

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                        "Please make sure all fields are filled with numbers, put a 0 for items you do not want.");
                return;
            }
            int total = 0;
            for (int i : menuQty) {
                total += i;
            }
            if (total == 0) {
                JOptionPane.showMessageDialog(frame,
                        "Please enter the quantity for items you want.");
            } else {
                Operation.order(menuItems, menuPrice, menuQty);
                frame.setVisible(false);
                ConfirmOrder.show();
            }
        } else if (e.getSource().equals(btnBack)) {
            frame.setVisible(false);
            Index.frame.setVisible(true);
        }


    }

    public static void show() {
        new Menu();
    }

    public static void back() {

    }
}
