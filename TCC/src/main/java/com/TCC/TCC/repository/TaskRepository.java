package com.TCC.TCC.repository;

import com.TCC.TCC.model.Function;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Function, Long> {
}
