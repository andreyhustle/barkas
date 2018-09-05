package com.wlu.barkas.domain.products;

import com.wlu.barkas.domain.Product;
import com.wlu.barkas.domain.attributes.Manufacturer;

import javax.persistence.*;

@Entity(name = "engine")
@Inheritance
public class Engine extends Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double volume;
    private double weight;

    public Engine(String name, int quantity, long price, String model, String code, Manufacturer manufacturer, String description, double volume, double weight) {
        super(name, quantity, price, model, code, manufacturer, description);
        this.volume = volume;
        this.weight = weight;
    }

    public Engine() {
    }
}
