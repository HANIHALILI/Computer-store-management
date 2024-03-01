package gui;

import controller.Backend_DAO_List;
import model.Customer;
import model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewPurchasesForm {
    private JComboBox jcmbCustomers;
    private JList list1;
    private JLabel jlabelTotal;
    public JPanel jpanel;
 Backend_DAO_List bdl ;

    public ViewPurchasesForm() {
 bdl=Backend_DAO_List.get();
        DefaultListModel SelectedProductsListModel = new DefaultListModel();
 try {
     DefaultComboBoxModel modelCustomer = new DefaultComboBoxModel();
     modelCustomer.addAll(bdl.getAllCustomers().values(

     ));
     jcmbCustomers.setModel(modelCustomer);
 }catch (Exception e){

 }

        jcmbCustomers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    SelectedProductsListModel.clear();
                    SelectedProductsListModel.addAll(bdl.getCustomersOrders((Customer) jcmbCustomers.getSelectedItem()));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                list1.setModel(SelectedProductsListModel);
                try {
                    Product[] products = new Product[SelectedProductsListModel.size()];
                    SelectedProductsListModel.copyInto(products);
                    Float total = bdl.CalcProductsTotalCost(products);
                    jlabelTotal.setText(total.toString());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }


}
