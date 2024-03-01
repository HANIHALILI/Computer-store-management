package controller;

import model.Customer;
import model.Product;
import model.PurchaseOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public interface Backend {
    void AddCustomer(Customer c) throws  Exception;
    void AddProduct(Product p) throws  Exception;
    void PlaceOrder(PurchaseOrder p) throws  Exception;


    HashMap<Long, Customer> getAllCustomers()throws Exception;

    HashSet<Product> getAllProducts()throws  Exception;


    ArrayList<Product> getCustomersOrders(Customer c)throws  Exception;


    // מחיקה של מוצר ממערך המוצרים, (אין צורך בלולאה.)
    void RemoveProduct(Product c) throws  Exception;

    float CalcProductsTotalCost(Product [] products)throws  Exception;

}
