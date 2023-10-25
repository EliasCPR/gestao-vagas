package br.com.elias.gestaovagas.modules.company.controllers;

import br.com.elias.gestaovagas.modules.company.entities.CompanyEntity;
import br.com.elias.gestaovagas.modules.company.useCases.CreateCompanyUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CreateCompanyUseCase createCompanyUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> createCompany(@Valid  @RequestBody CompanyEntity companyEntity){
        try{
            var result = this.createCompanyUseCase.execute(companyEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception err) {
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }
}
