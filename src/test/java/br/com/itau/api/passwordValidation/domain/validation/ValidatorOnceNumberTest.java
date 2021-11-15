package br.com.itau.api.passwordValidation.domain.validation;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintValidatorContext;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class ValidatorOnceNumberTest {
  @Mock
  ConstraintValidatorContext context;

  @Test
  void validObject() {
    String password = "AbTp9!fok";

    ValidatorOnceNumero validator = new ValidatorOnceNumero();
    boolean response = validator.isValid(password, context);
    assertEquals(true, response);
  }

  @Test
  void invalidObject() {
    String password = "AbTpn!fok";

    ValidatorOnceNumero validator = new ValidatorOnceNumero();
    boolean response = validator.isValid(password, context);
    assertEquals(false, response);
  }
}
