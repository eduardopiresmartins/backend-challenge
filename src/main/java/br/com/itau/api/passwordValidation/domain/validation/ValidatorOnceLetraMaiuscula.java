package br.com.itau.api.passwordValidation.domain.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorOnceLetraMaiuscula implements ConstraintValidator<OnceLetraMaiuscula, String> {
  private String regex = ".*[A-Z].*";

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    boolean check = ValidatorRegexRunner.check(regex, value);
    return check;
  }
}
