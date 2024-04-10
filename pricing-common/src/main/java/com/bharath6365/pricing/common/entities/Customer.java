package com.bharath6365.pricing.common.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {

 @JsonProperty("firstName")
 @NotBlank(message = "First name is mandatory")
 private String firstName;

 @JsonProperty("lastName")
 @NotBlank(message = "Last name is mandatory")
 private String lastName;

 @JsonProperty("age")
 @NotNull(message = "Age is mandatory")
 private int age;

 @JsonProperty("email")
 @Email(message = "Email should be valid")
 private String email;

 @JsonProperty("pinCode")
 @NotBlank(message = "Pin code is mandatory")
 private String pinCode;

 @JsonProperty("employmentType")
 @Valid
 @NotBlank(message = "Employment type is mandatory")
 private EmploymentType employmentType;

 @JsonProperty("cibilScore")
 @NotNull(message = "Cibil score is mandatory. Enter a value between 1-900")
 @Max(900)
 @Min(1)
 private float cibilScore;

 @JsonProperty("monthlyIncome")
 @NotNull(message = "Monthly income is mandatory")
 @Min(value = 10000, message = "Monthly income should be more than 10000")
 @Max(value=1000000, message="Monthly income should not exceed 1 million")
 private float monthlyIncome;


 @Override
 public String toString() {
  return "Customer{" +
          "firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          ", age=" + age +
          ", email='" + email + '\'' +
          ", pinCode='" + pinCode + '\'' +
          ", employmentType=" + employmentType +
          ", cibilScore=" + cibilScore +
          ", monthlyIncome=" + monthlyIncome +
          '}';
 }
}