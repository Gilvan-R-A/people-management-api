package one.digitalInnovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private Long id;

    @NotBlank(message = "First name is mandatory")
    @Size(min = 2, max = 100, message = "First name must be between 2 and 100 characters")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(min = 2, max = 100, message = "Last name must be between 2 and 100 characteres")
    private String lastName;

    @NotBlank(message = "CPF is mandatory")
    @Pattern(regexp = "\\d{11}", message = "CPF must have exactly 11 digits")
    @CPF(message = "Invalid CPF format")
    private String cpf;

    @NotNull(message = "Birth date is mandatory")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Valid
    @NotEmpty(message = "At least one phone must be provided")
    private List<PhoneDTO> phones;


    public void setCpf(String cpf) {
        this.cpf = (cpf != null) ? cpf.trim() : null;
    }
}
