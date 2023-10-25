package br.com.elias.gestaovagas.modules.company.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "company")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @Email(message = "invalid field error")
    private String email;

    @Length(min = 8, max = 100)
    private String password;
    private String website;

    @NotBlank
    @Pattern(regexp = "\\S+", message = "o campo username não pode conter espaços")
    private String username;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
