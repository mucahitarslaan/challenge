package com.mucahitarslan.challenge.service.impl;

import com.mucahitarslan.challenge.dto.mapper.CompanyMapper;
import com.mucahitarslan.challenge.dto.request.CompanyRequest;
import com.mucahitarslan.challenge.dto.response.CompanyResponse;
import com.mucahitarslan.challenge.model.Company;
import com.mucahitarslan.challenge.repository.CompanyRepository;
import com.mucahitarslan.challenge.service.abstracts.CompanyService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class performs operations on queries from {@link com.mucahitarslan.challenge.controller.CompanyController},
 * acting on {@link CompanyRepository}
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    /**
     * Deletes a data by giving a parameter to {@link CompanyRepository}
     *
     * @param id must not be {@literal null}
     */
    @Override
    public void deleteById(int id) {
        companyRepository.deleteById(id);
    }

    /**
     * Returns list of all instances of the type via {@link CompanyRepository}
     *
     * @return list of all {@link CompanyResponse}
     */
    @Override
    public List<CompanyResponse> getAll() {
        return companyRepository.findAll().stream()
                .map(companyMapper::toCompanyResponse)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves an entity by its id via {@link CompanyRepository}
     *
     * @param id must not be {@literal null}
     * @return {@link CompanyResponse}
     */
    @Override
    public CompanyResponse getById(int id) {
        return companyMapper.toCompanyResponse(companyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Invalid id")));
    }

    /**
     * Retrieves an entity by its id via {@link CompanyRepository}
     *
     * @param id must not be {@literal null}
     * @return {@link Company}
     */
    @Override
    public Company getCompanyById(int id) {
        return companyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("not found"));
    }

    /**
     * Saves a given entity via {@link CompanyRepository}
     *
     * @param companyRequest {@link CompanyRequest}
     * @return {@link CompanyResponse}
     */
    @Override
    public CompanyResponse save(CompanyRequest companyRequest) {
        return companyMapper.toCompanyResponse(companyRepository.save(companyMapper.toCompany(companyRequest)));
    }

    /**
     * Updates entity with the given entity and id via {@link CompanyRepository}
     *
     * @param id             must not be {@literal null}
     * @param companyRequest {@link CompanyRequest}
     * @return {@link CompanyResponse}
     */
    @Override
    public CompanyResponse updateById(int id, CompanyRequest companyRequest) {
        var company = companyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Company not found"));
        return companyMapper.toCompanyResponse(
                companyRepository.save(companyMapper.toCompanyForUpdate(id, company, companyRequest)));
    }
}
