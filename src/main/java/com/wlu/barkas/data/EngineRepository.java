package com.wlu.barkas.data;

import com.wlu.barkas.domain.attributes.Manufacturer;
import com.wlu.barkas.domain.products.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineRepository extends JpaRepository<Engine, Long> {
    List<Engine> findEnginesByManufacturer(Manufacturer manufacturer);
}
