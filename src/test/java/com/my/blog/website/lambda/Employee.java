package com.my.blog.website.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.function.Predicate;

@Data
@AllArgsConstructor
public class Employee {

    private Integer age;

    private String gender;

    private BigDecimal money;

    public  static Predicate<Employee> ageGreaterThan70 = x->x.age>70;

}
