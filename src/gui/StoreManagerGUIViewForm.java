package gui;

import controller.Backend_DAO_List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class StoreManagerGUIViewForm {
        private JButton AddCustomer;
        private JPanel Home;
        private JButton Products;
        private JButton NewOrder;
        private JButton Orders;




    public StoreManagerGUIViewForm() {

            AddCustomer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AddCustomer form = null;
                    try {
                        form = new AddCustomer();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    form.setVisible(true);
                }
            });
            Products.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame frame = new JFrame("ManageCatalogForm");
                    frame.setContentPane(new ManageCatalogForm().panel);
                    frame.setPreferredSize(new Dimension(650, 650));
                    frame.pack();
                    frame.setVisible(true);
                }
            });
            Orders.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame frame = new JFrame("ViewPurchasesForm");
                    frame.setContentPane(new ViewPurchasesForm().jpanel);
                    frame.setPreferredSize(new Dimension(800, 800));
                    frame.pack();
                    frame.setVisible(true);
                }
            });
            NewOrder.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame frame = new JFrame("PlaceOrderForm");
                    frame.setContentPane(new PlaceOrderForm().jpanel);
                    frame.setPreferredSize(new Dimension(800, 800));
                    frame.pack();
                    frame.setVisible(true);
                }
            });


    }

        public static void main(String[] args) {
            JFrame frame = new JFrame("חנות מחשבים");
            frame.setContentPane(new StoreManagerGUIViewForm().Home);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowOpened(WindowEvent e) {
                    Backend_DAO_List.get().loadDataFromFile();
                }

                @Override
                public void windowClosing(WindowEvent e) {
                    // Save data when the window is closing
                    Backend_DAO_List.get().saveDataToFile();
                }
            });

            frame.setPreferredSize(new Dimension(1000, 1000));
            frame.pack();
            frame.setVisible(true);
        }
    }



