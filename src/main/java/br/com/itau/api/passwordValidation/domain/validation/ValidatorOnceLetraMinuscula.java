package br.com.itau.api.passwordValidation.domain.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorOnceLetraMinuscula implements ConstraintValidator<OnceLetraMinuscula, String> {
  private String regex = ".*[a-z].*";

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    boolean check = ValidatorRegexRunner.check(regex, value);
    return check;
  }

}
