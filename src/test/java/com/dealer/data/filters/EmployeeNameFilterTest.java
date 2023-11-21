package com.dealer.data.filters;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.filters.impl.EmployeeNameFilter;
import com.dealer.models.people.Employee;

public class EmployeeNameFilterTest {
    @Test
    public void filter_is_equal_to_name(){
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("John", "5149999999", 1000));
        employees.add(new Employee("Jane", "5149999999", 1000));
        employees.add(new Employee("John", "5149999999", 1000));
        IEmployeeFilter filter = new EmployeeNameFilter("John");
        List<Employee> filtered = filter.filterEmployees(employees);
        assertEquals(2, filtered.size());
    }

    @Test
    public void filter_returns_empty(){
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("John", "5149999999", 1000));
        employees.add(new Employee("Jane", "5149999999", 1000));
        employees.add(new Employee("John", "5149999999", 1000));
        IEmployeeFilter filter = new EmployeeNameFilter("Jot");
        List<Employee> filtered = filter.filterEmployees(employees);
        assertEquals(0, filtered.size());
    }
}
