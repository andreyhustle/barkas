package com.wlu.barkas.services.impl;

import com.wlu.barkas.data.ManufacturerRepository;
import com.wlu.barkas.domain.attributes.Manufacturer;
import com.wlu.barkas.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    ManufacturerRepository repo;

    public List<Manufacturer> findManufacturerByCountry (String country) {
       return repo.findManufacturersByCountry(country);
    }

    public void addManufacturer(String name, String country) {
        Manufacturer man = new Manufacturer(name, country, "desc,", "url", "phone");
        repo.save(man);
    }

}
