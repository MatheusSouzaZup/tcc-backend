package com.TCC.TCC.repository;

import com.TCC.TCC.model.Function;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FunctionRepository extends JpaRepository<Function, Long> {
    public Function findByNameEquals(String name);
}
