package com.wlu.barkas.domain;

import com.wlu.barkas.domain.attributes.Manufacturer;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class Product {

    protected String name;
    protected int quantity;
    protected long price;
    protected String model;
    protected String code;
    @OneToOne(targetEntity = Manufacturer.class)
    protected Manufacturer manufacturer;
    protected String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Product(String name, int quantity, long price, String model, String code, Manufacturer manufacturer, String description) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.model = model;
        this.code = code;
        this.manufacturer = manufacturer;
        this.description = description;
    }

    public Product() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", model='" + model + '\'' +
                ", code='" + code + '\'' +
                ", manufacturer=" + manufacturer +
                ", description='" + description + '\'' +
                '}';
    }
}
