package br.com.elias.gestaovagas.modules.company.useCases;

import br.com.elias.gestaovagas.exceptions.UserFoundException;
import br.com.elias.gestaovagas.modules.company.entities.CompanyEntity;
import br.com.elias.gestaovagas.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    private void execute(CompanyEntity companyEntity){
        this.companyRepository
                .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        this.companyRepository.save(companyEntity);
    }
}
