package com.rojonovick.companies_crud.controllers;

import com.rojonovick.companies_crud.entities.Company;
import com.rojonovick.companies_crud.services.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping(path = "company")
@Tag(name="Companies resource")
public class CompanyController {
    private final CompanyService companyService;
    private static final Logger log = LoggerFactory.getLogger(CompanyController.class);

    @Operation(summary="Get a company given a company name")
    @GetMapping(path = "{name}")
    public ResponseEntity<Company> get(@PathVariable String name) {
        log.info("GET: Company {}", name);
        return ResponseEntity.ok(this.companyService.readByName(name));
    }
    @Operation(summary="Publish in DB a company given your info")
    @PostMapping
    public ResponseEntity<Company> post(@RequestBody Company company) {
        log.info("POST: Company {}", company.getName());
        return ResponseEntity.created(URI.create(this.companyService.create(company).getName())).build();
//        return null;
    }

    @Operation(summary="Update in DB a company given your info")
    @PutMapping(path = "{name}")
    public ResponseEntity<Company> put(@RequestBody Company company, @PathVariable String name) {
        log.info("PUT: Company {}", name);
        return ResponseEntity.ok(this.companyService.update(company, name));
    }
    @Operation(summary="Delete in DB a company given your name")
    @DeleteMapping(path = "{name}")
    public ResponseEntity<?> delete (@PathVariable String name){
        log.info("DELETE: Company {}", name);
        this.companyService.delete(name);
        return ResponseEntity.noContent().build();
    }

}
