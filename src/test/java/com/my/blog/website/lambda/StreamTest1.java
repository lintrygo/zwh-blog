package com.my.blog.website.lambda;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest1 {

    @Test
    public void test1(){
        List<String> strList = Arrays.asList("test1","1sdfsdf","dfsfs","dwwewe");
        List<String> str2list =strList.stream()
                .filter(str -> str.startsWith("d") && str.endsWith("e"))
                .map(str ->str.toUpperCase())
                .sorted()
                .collect(Collectors.toList());

        System.out.printf(str2list.toString());

        Employee test = new Employee(100,"m",BigDecimal.valueOf(100));
        Employee test1 = new Employee(80,"f",BigDecimal.valueOf(100));
        Employee test2 = new Employee(10,"m",BigDecimal.valueOf(100));
        Employee test3 = new Employee(20,"m",BigDecimal.valueOf(100));
        List<Employee> employeeList = Arrays.asList(test,test1,test2,test3);

        employeeList.stream()
                .filter(Employee.ageGreaterThan70)
                .collect(Collectors.toList());

        System.out.println(employeeList);

        //匹配规则 任意一个元素
        boolean result1 = employeeList.stream().anyMatch(Employee.ageGreaterThan70);

        //allMatch
        boolean result2 = employeeList.stream().allMatch(Employee.ageGreaterThan70);

        //noneMatch
        boolean result3 = employeeList.stream().noneMatch(Employee.ageGreaterThan70);

    }

    @Test
    public void test2(){
        String[] str = {"tom","jack","tom","array","werf"};
        List<String> stringList = Stream.of(str).limit(2).collect(Collectors.toList());
        List<String> stringList1 = Stream.of(str).skip(2).collect(Collectors.toList());
        List<String> stringList2 = Stream.of(str).distinct().collect(Collectors.toList());
        List<String> stringList3 = Stream.of(str).sorted().collect(Collectors.toList());
        System.out.println(stringList);
        System.out.println(stringList1);
        System.out.println(stringList2);
        System.out.println(stringList3);

    }

    @Test
    public void testOptional(){
        List<String> strtList = Arrays.asList("test","test1","test2");
        boolean isPresentResult = strtList.stream()
                .filter(str -> str.length()>4)
                .findFirst()
                .isPresent();
        System.out.println("isPresentResult:"+isPresentResult);

        strtList.stream()
                    .filter(str -> str.length()>8)
                    .findFirst().ifPresent(System.out::println);

        String orElseResult = strtList.stream()
                .filter(str -> str.length()>8)
                .findFirst().orElse("everything");

        Optional<String> optional = strtList.stream()
                .filter(str -> str.length()>8)
                .findFirst();

        System.out.println("orElseResult:"+orElseResult);
    }

    public void testExample(){

        List<BigDecimal> bigDecimals = Arrays.asList(BigDecimal.valueOf(100),BigDecimal.valueOf(200),BigDecimal.valueOf(400));

        List<List<BigDecimal>> lists = bigDecimals.stream()
                .map(value -> testa(value))
                .collect(Collectors.toList());
        BigDecimal taret = BigDecimal.valueOf(100);
        List<BigDecimal> returnReduceStep = lists.stream().filter(value ->
            value.contains(taret)
        ).findFirst().get();



    }

    public List<BigDecimal> testa(BigDecimal value){
        List<BigDecimal> result = Arrays.asList(value);
        return result;
    }


}
