package com.mercadona.rrhh.evaluation.application.services;

import com.mercadona.rrhh.evaluation.domain.employee.Employee;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.Arrays;

@Service
public class EmployeeUserIdService {
  public String calculate(Employee employee) {
    if (employee == null) return null;

    String name = employee.getName();
    String firstSurname = employee.getFirstSurname();
    String secondSurname = employee.getSecondSurname();

    if (name == null || firstSurname == null || secondSurname == null) {
      return null;
    }

    String cleanName = normalize(name);
    String cleanFirstSurname = normalize(firstSurname);
    String cleanSecondSurname = normalize(secondSurname);

    String[] names = cleanName.trim().split("\\s+");

    String initials = Arrays.stream(names)
      .filter(n -> !n.isBlank())
      .map(n -> String.valueOf(n.charAt(0)))
      .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
      .toString()
      .toLowerCase();

    if (names.length == 1) {
      String firstPart = cleanFirstSurname.length() >= 5
        ? cleanFirstSurname.substring(0, 5)
        : cleanFirstSurname;
      String secondPart = cleanSecondSurname.length() >= 2
        ? cleanSecondSurname.substring(0, 2)
        : cleanSecondSurname;
      return initials + firstPart + secondPart;
    } else {
      return initials + cleanFirstSurname;
    }
  }

  private String normalize(String input) {
    return Normalizer.normalize(input, Normalizer.Form.NFD)
      .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
      .toLowerCase();
  }
}
