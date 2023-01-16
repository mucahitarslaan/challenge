package com.mucahitarslan.challenge.dto.response;

/**
 * {@link CompanyResponse} using for Company HTTP response body
 *
 * @param id          company's id
 * @param companyName company's name
 * @param address     company's address
 * @param phoneNumber company's phone number
 * @param email       company's e-mail
 */
public record CompanyResponse(
        int id,
        String companyName,
        String address,
        String phoneNumber,
        String email
) {
}
