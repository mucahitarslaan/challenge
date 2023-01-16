package com.mucahitarslan.challenge.dto.request;

/**
 * {@link CompanyRequest} using for Company HTTP request body
 *
 * @param companyName company name for company
 * @param address     address for company
 * @param phoneNumber phone number for company
 * @param email       e-mail for company
 */
public record CompanyRequest(
        String companyName,
        String address,
        String phoneNumber,
        String email
) {
}
