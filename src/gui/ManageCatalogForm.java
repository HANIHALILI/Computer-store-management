package gui;

import controller.Backend_DAO_List;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageCatalogForm {
    private JList<Product> jlistProducts;
    private JButton jDeleteProduct;
    private JButton jAddProduct;
    public JPanel panel;

    DefaultListModel   AllProductsListModel;
    Backend_DAO_List bdl = Backend_DAO_List.get();
    public ManageCatalogForm()  {

        jAddProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p();
            }
        });
        AllProductsListModel =new DefaultListModel();

        jlistProducts.setModel(AllProductsListModel);

        RefreshProductList();


        jDeleteProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<Product> selectedValuesList = jlistProducts.getSelectedValuesList();
                for (Product p :selectedValuesList) {
                    AllProductsListModel.removeElement(p);
                    try {
                        Backend_DAO_List.get().RemoveProduct(p);

                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
                RefreshProductList();
            }
        });
    }


    public void RefreshProductList() {
        try {
            AllProductsListModel.clear();
            AllProductsListModel.addAll(bdl.getAllProducts());
        } catch (Exception ex) {

        }
    }
    private void p(){
    JFrame frame = new JFrame("AddNewProductForm");
    frame.setContentPane(new AddNewProductForm(this).panel);
        frame.setPreferredSize(new Dimension(500, 500));
    frame.pack();
    frame.setVisible(true);
}

}
