package com.mucahitarslan.challenge.dto.mapper;

import com.mucahitarslan.challenge.dto.request.EmployeeRequest;
import com.mucahitarslan.challenge.dto.response.EmployeeResponse;
import com.mucahitarslan.challenge.model.Employee;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Using {@link Mapper} annotation for mapping process
 */
@Mapper(implementationName = "EmployeeMapperImpl", componentModel = "spring")
public interface EmployeeMapper {
    /**
     * Mapping {@link Employee} to {@link EmployeeResponse}
     *
     * @param employee has all field of employee
     * @return {@link EmployeeResponse}
     */
    EmployeeResponse toEmployeeResponse(Employee employee);

    /**
     * Mapping {@link EmployeeRequest} to {@link Employee}
     *
     * @param employeeRequest {@link EmployeeRequest}
     * @return {@link EmployeeResponse}
     */
    Employee toEmployee(EmployeeRequest employeeRequest);

    /**
     * Mapping to {@link Employee} using {@link EmployeeRequest} and {@link Employee} that retrieves by its id
     * {@link BeanMapping} annotation is used for {@literal null} fields for update
     *
     * @param id must not be {@literal null}
     * @param employee {@link Employee}
     * @param employeeRequest {@link EmployeeRequest}
     * @return {@link Employee}
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Employee toEmployeeForUpdate(int id, @MappingTarget Employee employee, EmployeeRequest employeeRequest);
}
