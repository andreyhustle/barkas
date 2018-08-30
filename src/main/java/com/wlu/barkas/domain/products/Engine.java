package com.wlu.barkas.domain.products;

import com.wlu.barkas.domain.Product;

import javax.persistence.*;

@Entity(name = "engine")
@Inheritance
public class Engine extends Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", model='" + model + '\'' +
                ", vendorCode='" + vendorCode + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
