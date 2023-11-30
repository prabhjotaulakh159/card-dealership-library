package com.dealer.data.filters;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.filters.impl.EmployeePhoneFilter;
import com.dealer.data.models.people.Employee;

public class EmployeePhoneFilterTest {
    @Test
    public void filter_is_equal_to_phone(){
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("John", "5149999999", 1000));
        employees.add(new Employee("Jane", "5149999999", 1000));
        employees.add(new Employee("John", "5149999999", 1000));
        IEmployeeFilter filter = new EmployeePhoneFilter("5149999999");
        List<Employee> filtered = filter.filterEmployees(employees);
        assertEquals(3, filtered.size());
    }

    @Test
    public void filter_returns_empty(){
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("John", "5149999999", 1000));
        employees.add(new Employee("Jane", "5149999999", 1000));
        employees.add(new Employee("John", "5149999999", 1000));
        IEmployeeFilter filter = new EmployeePhoneFilter("4388888888");
        List<Employee> filtered = filter.filterEmployees(employees);
        assertEquals(0, filtered.size());
    }
}
