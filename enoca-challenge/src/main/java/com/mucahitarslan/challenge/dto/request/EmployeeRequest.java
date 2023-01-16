package com.mucahitarslan.challenge.dto.request;

/**
 * {@link EmployeeRequest} using for Employee HTTP request body
 *
 * @param firstName   first name for employee
 * @param lastName    last name for employee
 * @param address     address for employee
 * @param phoneNumber phone number for employee
 * @param email       e-mail for employee
 * @param companyId   company id for mapping with company
 */
public record EmployeeRequest(
        String firstName,
        String lastName,
        String address,
        String phoneNumber,
        String email,
        int companyId
) {
}