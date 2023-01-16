package com.mucahitarslan.challenge.repository;

import com.mucahitarslan.challenge.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Extending {@link JpaRepository} for CRUD operations and Spring bean creation
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
