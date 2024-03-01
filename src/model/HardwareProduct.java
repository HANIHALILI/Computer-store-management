package model;

import java.io.Serializable;

public class HardwareProduct extends Product implements Serializable {
    private int warrantyPeriod;

    public HardwareProduct( String name, String description, float pricePerUnit, int warrantyPeriod) {
        super( name, description, pricePerUnit);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public float getPrice() {
        return this.getPricePerUnit();
    }

    @Override
    public String toString() {
        return "HardwareProduct{" +
                "warrantyPeriod=" + warrantyPeriod +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", pricePerUnit=" + pricePerUnit +
                '}';
    }
}
