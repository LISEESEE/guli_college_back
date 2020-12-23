package com.lss.study.java8;

import org.junit.Test;

import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestOptional {
    /**
     Optional容器类的常用方法：
     Optional.of(T t)：创建一个Optional实例
     Optional.empty()：创建一个空的Optional实例
     Optional.ofNullable(T t)：若t不为null，创建Optional实例，否则创建空实例
     ifPresent()：判断是否包含值
     orElse(T t)：如果调用对象包含值，返回该值，否则返回s获取的值
     map(Function f)：如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()
     flatMap(Function mapper)：与map类似，要求返回值必须是Optional
     */
    @Test
    public void test1(){
        Optional<Employee> op = Optional.of(null);
        Employee emp = op.get();
        System.out.println(emp);

        Optional<Employee> empty = Optional.empty();

        Optional<Employee> employee = Optional.ofNullable(new Employee());

        if (employee.isPresent()){
            System.out.println(employee.get());
        }
        Employee employee1 = employee.orElse(new Employee("张三", 18, 9999.99, Employee.Status.FREE));
        System.out.println(employee1);

        op.orElseGet(Employee::new);
    }
    @Test
    public void test2(){
        Optional<Employee> op = Optional.ofNullable(new Employee("张三",18,9999.99, Employee.Status.FREE));
        Optional<String> str = op.map((employee -> employee.getName()));
        System.out.println(str.get());
        Optional<String> s = op.flatMap(employee -> Optional.of(employee.getName()));
        System.out.println(s.get());
    }
}
