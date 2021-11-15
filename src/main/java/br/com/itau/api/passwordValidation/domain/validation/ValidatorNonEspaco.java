package br.com.itau.api.passwordValidation.domain.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorNonEspaco implements ConstraintValidator<NonEspaco, String> {
  private String regex = ".*[/\\s].*";

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    boolean check = !ValidatorRegexRunner.check(regex, value);
    return check;
  }

}
