package model;

import java.io.Serializable;

public abstract class  Product  implements Serializable {
    long id;
    String name;
    String description;
    float pricePerUnit;

     static int cnt =0;
    public Product() {
    }

    public Product( String name, String description, float pricePerUnit) {
        this.id = cnt ++;;
        this.name = name;
        this.description = description;
        this.pricePerUnit = pricePerUnit;

    }



    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPricePerUnit(float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPricePerUnit() {
        return pricePerUnit;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", pricePerUnit=" + pricePerUnit +
                '}';
    }
    public abstract float getPrice();
}
