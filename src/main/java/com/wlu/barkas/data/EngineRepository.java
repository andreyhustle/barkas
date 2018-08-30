package com.wlu.barkas.data;

import com.wlu.barkas.domain.products.Engine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineRepository extends JpaRepository<Engine, Long> {
}
