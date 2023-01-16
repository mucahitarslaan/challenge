package com.mucahitarslan.challenge.repository;

import com.mucahitarslan.challenge.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Extending {@link JpaRepository} for CRUD operations and Spring bean creation
 */
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
