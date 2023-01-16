package com.mucahitarslan.challenge.dto.response;

/**
 * {@link EmployeeResponse} using for Employee HTTP response body
 *
 * @param id          employee's id
 * @param firstName   employee's first name
 * @param lastName    employee's last name
 * @param address     employee's address
 * @param phoneNumber employee's phone number
 * @param email       employee's e-mail
 * @param company     employee's company
 */
public record EmployeeResponse(
        int id,
        String firstName,
        String lastName,
        String address,
        String phoneNumber,
        String email,
        CompanyResponse company
) {
}
