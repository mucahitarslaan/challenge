package com.mucahitarslan.challenge.controller;

import com.mucahitarslan.challenge.dto.request.EmployeeRequest;
import com.mucahitarslan.challenge.dto.response.EmployeeResponse;
import com.mucahitarslan.challenge.service.impl.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The controller for Employee REST endpoints and web UI.
 * This class handles the CRUD operations for Employee, via HTTP actions.
 * Use the endpoint that written in {@link RequestMapping} for sending requests.
 *
 * @author Mücahit Arslan
 */
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
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
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * HTTP request endpoint
     * Returns list of all instances of the type
     *
     * @return list of all employees from database and HTTP status code
     */
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAll() {
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    /**
     * HTTP request endpoint
     * Retrieves an entity by its id
     *
     * @param id must not be {@literal null}
     * @return employee with the given id from database and HTTP status code
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getById(@PathVariable int id) {
        return new ResponseEntity<>(employeeService.getById(id), HttpStatus.OK);
    }

    /**
     * HTTP request endpoint
     * Saves a given entity
     *
     * @param employeeRequest fields for entity
     * @return employee that saved. HTTP status code
     */
    @PostMapping
    public ResponseEntity<EmployeeResponse> save(@RequestBody EmployeeRequest employeeRequest) {
        return new ResponseEntity<>(employeeService.save(employeeRequest), HttpStatus.CREATED);
    }

    /**
     * HTTP request endpoint
     * Updates entity with the given entity and id
     *
     * @param id              id must not be {@literal null}
     * @param employeeRequest fields for entity
     * @return employee that updated. HTTP status code
     */
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateById(@PathVariable int id,
                                                       @RequestBody EmployeeRequest employeeRequest) {
        return new ResponseEntity<>(employeeService.updateById(id, employeeRequest), HttpStatus.OK);
    }
}
