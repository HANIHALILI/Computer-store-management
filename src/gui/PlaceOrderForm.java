package gui;

import controller.Backend_DAO_List;
import model.Customer;
import model.Product;
import model.ProductType;
import model.PurchaseOrder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlaceOrderForm {
    private JComboBox jcmbCustomers;
    private JComboBox jcmbProducts;
    private JButton jbtnAddToOrder;
    private JList jdetailsOrder;
    public JPanel jpanel;
    private JButton jbtnRemoveItem;
    private JButton jbtnSumbitOrder;
    private JButton jbtnTotal;
    private JLabel jlableTotal;

    Backend_DAO_List bdl;
    public PlaceOrderForm() {
        bdl = Backend_DAO_List.get();
        DefaultListModel SelectedProductsListModel = new DefaultListModel();
        jdetailsOrder.setModel(SelectedProductsListModel);
        try {
            DefaultComboBoxModel modelCustomer = new DefaultComboBoxModel();
            modelCustomer.addAll(bdl.getAllCustomers().values());
            jcmbCustomers.setModel(modelCustomer);

            DefaultComboBoxModel modelProduct = new DefaultComboBoxModel();
            modelProduct.addAll(bdl.getAllProducts());
            jcmbProducts.setModel(modelProduct);

            } catch (Exception ex) {
            Logger.getLogger(PlaceOrderForm.class.getName()).log(Level.SEVERE,null, ex);
        }

        jbtnAddToOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jcmbCustomers.getSelectedIndex()>=0)
                   SelectedProductsListModel.addElement((Product)jcmbProducts.getSelectedItem());
                else
                    JOptionPane.showMessageDialog(jpanel,"חובה לבחור לקוח");

            }
        });
        jbtnRemoveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<Product> selectedValuesList = jdetailsOrder.getSelectedValuesList();
                for (Product p :selectedValuesList) {
                    SelectedProductsListModel.removeElement(p);
                }

            }
        });
        jbtnTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Product[] products = new Product[SelectedProductsListModel.size()];
                    SelectedProductsListModel.copyInto(products);
                    Float total = bdl.CalcProductsTotalCost(products);
                    jlableTotal.setText(total.toString());
                } catch (Exception ex) {
                    Logger.getLogger(PlaceOrderForm.class.getName()).log(Level.SEVERE,null, ex);
                }
            }
        });
        jbtnSumbitOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jcmbProducts.getSelectedIndex()>=0 && jcmbCustomers.getSelectedIndex()>=0){
                    try {
                        PurchaseOrder newOrder = new PurchaseOrder();
                        newOrder.setListProd(new ArrayList(Arrays.asList(SelectedProductsListModel.toArray())));
                        newOrder.setOrderingCustomer((Customer) jcmbCustomers.getSelectedItem());
                        bdl.PlaceOrder(newOrder);
                        JOptionPane.showMessageDialog(jpanel, "הזמנה נוספה בהצלחה");
                        SelectedProductsListModel.clear();

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error Placing order", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(PlaceOrderForm.class.getName()).log(Level.SEVERE,null, ex);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(jpanel,"חובה לבחור לקוח ומוצר");

                }
            }
        });
    }


}
