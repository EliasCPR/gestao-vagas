package br.com.elias.gestaovagas.modules.company.controllers;

import br.com.elias.gestaovagas.modules.company.entities.JobEntity;
import br.com.elias.gestaovagas.modules.company.useCases.CreateJobUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping
    public ResponseEntity<JobEntity> createJob(@Valid @RequestBody JobEntity jobEntity){
        var result = this.createJobUseCase.execute(jobEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
