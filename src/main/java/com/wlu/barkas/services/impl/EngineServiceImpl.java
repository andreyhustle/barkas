package com.wlu.barkas.services.impl;

import com.wlu.barkas.data.EngineRepository;
import com.wlu.barkas.domain.attributes.Manufacturer;
import com.wlu.barkas.domain.products.Engine;
import com.wlu.barkas.services.EngineService;
import com.wlu.barkas.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EngineServiceImpl implements EngineService {
    @Autowired
    EngineRepository repo;
    @Autowired
    ManufacturerService manufacturerService;

    @Override
    public void addEngine() {

    }

    @Override
    public List<Engine> findEngineByCountry(String country) {
        List<Manufacturer> manufacturersByCountry = manufacturerService.findManufacturerByCountry(country);
        List<Engine> result = repo.findEnginesByManufacturer(manufacturersByCountry.get(0));
        return result;
    }
}
