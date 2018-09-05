package com.wlu.barkas.services;

import com.wlu.barkas.domain.products.Engine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EngineService {
    void addEngine();

    List<Engine> findEngineByCountry(String country);
}
