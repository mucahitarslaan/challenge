package com.mucahitarslan.challenge.service.abstracts;

import com.mucahitarslan.challenge.dto.request.CompanyRequest;
import com.mucahitarslan.challenge.dto.response.CompanyResponse;
import com.mucahitarslan.challenge.model.Company;

import java.util.List;

/**
 * Interface created for dependency and method signature of
 * {@link com.mucahitarslan.challenge.service.impl.CompanyServiceImpl}
 */
public interface CompanyService {
    List<CompanyResponse> getAll();

    CompanyResponse getById(int id);

    Company getCompanyById(int id);

    CompanyResponse save(CompanyRequest companyRequest);

    CompanyResponse updateById(int id, CompanyRequest companyRequest);

    void deleteById(int id);
}
