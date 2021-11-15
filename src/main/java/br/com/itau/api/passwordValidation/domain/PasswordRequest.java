package br.com.itau.api.passwordValidation.domain;

import br.com.itau.api.passwordValidation.domain.validation.*;
import lombok.*;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class PasswordRequest {

  @Size(min = 9, message = "A senha deve conter ao menos 9 caracteres")
  @NotBlank(message = "O campo senha deve ser preenchido")
  @OnceLetraMaiuscula(message = "A senha deve conter ao menos uma letra maiúscula")
  @OnceLetraMinuscula(message = "A senha deve conter ao menos uma letra minuscula")
  @OnceCaracterEspecial(message = "A senha deve conter ao menos um caractere especial")
  @CaracterRepetido(message = "A senha não deve conter caracteres repetidos")
  @NonEspaco(message = "A senha não deve conter espaços")
  @OnceNumero(message = "A senha deve conter ao menos um digito")
  private String password;

}
