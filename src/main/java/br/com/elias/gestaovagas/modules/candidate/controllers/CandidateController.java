package br.com.elias.gestaovagas.modules.candidate.controllers;


import br.com.elias.gestaovagas.modules.candidate.CandidateEntity;
import br.com.elias.gestaovagas.modules.candidate.useCases.CreateCandidateUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity){

        try {
            var result = this.createCandidateUseCase.execute(candidateEntity);

            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception err) {
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }

}
