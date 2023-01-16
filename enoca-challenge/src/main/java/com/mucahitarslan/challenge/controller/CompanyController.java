package com.mucahitarslan.challenge.controller;

import com.mucahitarslan.challenge.dto.request.CompanyRequest;
import com.mucahitarslan.challenge.dto.response.CompanyResponse;
import com.mucahitarslan.challenge.service.abstracts.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The controller for Company REST endpoints and web UI.
 * This class handles the CRUD operations for Company, via HTTP actions.
 * Use the endpoint that written in {@link RequestMapping} for sending requests.
 *
 * @author Mücahit Arslan
 */
@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * HTTP request endpoint
     * Deletes a given entity with the given id
     *
     * @param id must not be {@literal null}
     * @return HTTP status code after process
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        companyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * HTTP request endpoint
     * Returns list of all instances of the type
     *
     * @return list of all companies from database and HTTP status code
     */
    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getAll() {
        return new ResponseEntity<>(companyService.getAll(), HttpStatus.OK);
    }

    /**
     * HTTP request endpoint
     * Retrieves an entity by its id
     *
     * @param id must not be {@literal null}
     * @return company with the given id from database and HTTP status code
     */
    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> getById(@PathVariable int id) {
        return new ResponseEntity<>(companyService.getById(id), HttpStatus.OK);
    }

    /**
     * HTTP request endpoint
     * Saves a given entity
     *
     * @param companyRequest fields for entity
     * @return company that saved. HTTP status code
     */
    @PostMapping
    public ResponseEntity<CompanyResponse> save(@RequestBody CompanyRequest companyRequest) {
        return new ResponseEntity<>(companyService.save(companyRequest), HttpStatus.CREATED);
    }

    /**
     * HTTP request endpoint
     * Updates entity with the given entity and id
     *
     * @param id             must not be {@literal null}
     * @param companyRequest fields for entity
     * @return company that updated. HTTP status code
     */
    @PutMapping("/{id}")
    public ResponseEntity<CompanyResponse> updateById(@PathVariable int id,
                                                      @RequestBody CompanyRequest companyRequest) {
        return new ResponseEntity<>(companyService.updateById(id, companyRequest), HttpStatus.OK);
    }
}
