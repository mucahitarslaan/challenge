package com.mucahitarslan.challenge.dto.mapper;

import com.mucahitarslan.challenge.dto.request.CompanyRequest;
import com.mucahitarslan.challenge.dto.response.CompanyResponse;
import com.mucahitarslan.challenge.model.Company;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Using {@link Mapper} annotation for mapping process
 */
@Mapper(implementationName = "CompanyMapperImpl", componentModel = "spring")
public interface CompanyMapper {
    /**
     * Mapping {@link Company} to {@link CompanyResponse}
     *
     * @param company has all field of company
     * @return {@link CompanyResponse}
     */
    CompanyResponse toCompanyResponse(Company company);

    /**
     * Mapping {@link CompanyRequest} to {@link Company}
     *
     * @param companyRequest {@link CompanyRequest}
     * @return {@link Company}
     */
    Company toCompany(CompanyRequest companyRequest);

    /**
     * Mapping to {@link Company} using {@link CompanyRequest} and {@link Company} that retrieves by its id
     * {@link BeanMapping} annotation is used for {@literal null} fields for update
     *
     * @param id             must not be {@literal null}
     * @param company        {@link Company}
     * @param companyRequest {@link CompanyRequest}
     * @return {@link Company}
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Company toCompanyForUpdate(int id, @MappingTarget Company company, CompanyRequest companyRequest);
}
