package com.wlu.barkas.services;

import com.wlu.barkas.domain.attributes.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManufacturerService {
    List<Manufacturer> findManufacturerByCountry (String country);
    void addManufacturer(String name, String country);
}
