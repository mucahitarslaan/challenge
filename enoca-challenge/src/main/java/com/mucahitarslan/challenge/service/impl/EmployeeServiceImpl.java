package com.mucahitarslan.challenge.service.impl;

import com.mucahitarslan.challenge.dto.mapper.EmployeeMapper;
import com.mucahitarslan.challenge.dto.request.EmployeeRequest;
import com.mucahitarslan.challenge.dto.response.EmployeeResponse;
import com.mucahitarslan.challenge.repository.EmployeeRepository;
import com.mucahitarslan.challenge.service.abstracts.CompanyService;
import com.mucahitarslan.challenge.service.abstracts.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class performs operations on queries from {@link com.mucahitarslan.challenge.controller.EmployeeController},
 * acting on {@link EmployeeRepository}
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final CompanyService companyService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper, CompanyService companyService) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.companyService = companyService;
    }

    /**
     * Deletes a data by giving a parameter to {@link EmployeeRepository}
     *
     * @param id must not be {@literal null}
     */
    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    /**
     * Returns list of all instances of the type via {@link EmployeeRepository}
     *
     * @return list of all {@link EmployeeResponse}
     */
    @Override
    public List<EmployeeResponse> getAll() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toEmployeeResponse)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves an entity by its id via {@link EmployeeRepository}
     *
     * @param id must not be {@literal null}
     * @return {@link EmployeeResponse}
     */
    @Override
    public EmployeeResponse getById(int id) {
        return employeeMapper.toEmployeeResponse(employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Invalid id")));
    }

    /**
     * Saves a given entity via {@link EmployeeRepository}
     *
     * @param employeeRequest {@link EmployeeRequest}
     * @return {@link EmployeeResponse}
     */
    @Override
    public EmployeeResponse save(EmployeeRequest employeeRequest) {
        var company = companyService.getCompanyById(employeeRequest.companyId());
        var employee = employeeMapper.toEmployee(employeeRequest);
        employee.setCompany(company);
        return employeeMapper.toEmployeeResponse(employeeRepository.save(employee));
    }

    /**
     * Updates entity with the given entity and id via {@link EmployeeRepository}
     *
     * @param id              must not be {@literal null}
     * @param employeeRequest {@link EmployeeRequest}
     * @return {@link EmployeeResponse}
     */
    @Override
    public EmployeeResponse updateById(int id, EmployeeRequest employeeRequest) {
        var employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        if (employeeRequest.companyId() != 0) {
            var company = companyService.getCompanyById(employeeRequest.companyId());
            employee.setCompany(company);
        }
        return employeeMapper.toEmployeeResponse(
                employeeRepository.save(employeeMapper.toEmployeeForUpdate(id, employee, employeeRequest)));
    }
}
