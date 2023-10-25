package br.com.elias.gestaovagas.modules.candidate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class CandidateEntity {
    private UUID id;
    private String name;

    @Pattern(regexp = "\\S+", message = "o campo username não pode conter espaços")
    private String username;

    @Email(message = "invalid field error")
    private String email;

    @Length(min = 8, max = 100)
    private String password;
    private String description;
    private String curriculum;
}
