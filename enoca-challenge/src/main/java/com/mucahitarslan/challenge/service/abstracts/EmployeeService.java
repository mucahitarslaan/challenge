package com.mucahitarslan.challenge.service.abstracts;

import com.mucahitarslan.challenge.dto.request.EmployeeRequest;
import com.mucahitarslan.challenge.dto.response.EmployeeResponse;

import java.util.List;

/**
 * Interface created for dependency and method signature of
 * {@link com.mucahitarslan.challenge.service.impl.EmployeeServiceImpl}
 */
public interface EmployeeService {
    List<EmployeeResponse> getAll();

    EmployeeResponse getById(int id);

    EmployeeResponse save(EmployeeRequest employeeRequest);

    EmployeeResponse updateById(int id, EmployeeRequest employeeRequest);

    void deleteById(int id);
}
