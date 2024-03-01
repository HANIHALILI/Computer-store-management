package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
public class PurchaseOrder   implements Serializable {
    Customer orderingCustomer;
    private List<Product> listProd;
    private LocalDate orderDate = LocalDate.from(LocalDateTime.now());

    public PurchaseOrder() {
    }

    public PurchaseOrder(Customer orderingCustomer, List<Product> listProd) {
        this.orderingCustomer = orderingCustomer;
        this.listProd = listProd;
    }

    public Customer getOrderingCustomer() {
        return orderingCustomer;
    }

    public List<Product> getListProd() {
        return listProd;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderingCustomer(Customer orderingCustomer) {
        this.orderingCustomer = orderingCustomer;
    }

    public void setListProd(List<Product> listProd) {
        this.listProd = listProd;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "orderingCustomer=" + orderingCustomer +
                ", listProd=" + listProd +
                ", orderDate=" + orderDate +
                '}';
    }
}
