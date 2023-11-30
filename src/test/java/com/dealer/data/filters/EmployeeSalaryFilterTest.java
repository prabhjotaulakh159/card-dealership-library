package com.dealer.data.filters;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.filters.impl.EmployeeSalaryFilter;
import com.dealer.data.models.people.Employee;

public class EmployeeSalaryFilterTest {
    @Test
    public void filter_is_equal_to_salary(){
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("John", "5149999999", 1000));
        employees.add(new Employee("Jane", "5149999999", 1000));
        employees.add(new Employee("John", "5149999999", 1000));
        IEmployeeFilter filter = new EmployeeSalaryFilter(ListFilter.EQUALS, 1000);
        List<Employee> filtered = filter.filterEmployees(employees);
        assertEquals(3, filtered.size());
    }

    @Test
    public void filter_is_greater_than_salary() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("John", "5149999999", 1000));
        employees.add(new Employee("Jane", "5149999999", 1500));
        employees.add(new Employee("John", "5149999999", 2000));
        IEmployeeFilter filter = new EmployeeSalaryFilter(ListFilter.GREATERTHAN, 1000);
        List<Employee> filtered = filter.filterEmployees(employees);
        assertEquals(2, filtered.size());
    }

    @Test
    public void filter_is_less_than_salary() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("John", "5149999999", 1000));
        employees.add(new Employee("Jane", "5149999999", 1500));
        employees.add(new Employee("John", "5149999999", 2000));
        IEmployeeFilter filter = new EmployeeSalaryFilter(ListFilter.LESSTHAN, 2000);
        List<Employee> filtered = filter.filterEmployees(employees);
        assertEquals(2, filtered.size());
    }

    @Test
    public void filter_is_greater_equals_than_salary() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("John", "5149999999", 1000));
        employees.add(new Employee("Jane", "5149999999", 1500));
        employees.add(new Employee("John", "5149999999", 2000));
        IEmployeeFilter filter = new EmployeeSalaryFilter(ListFilter.GREATEREQUALS, 1000);
        List<Employee> filtered = filter.filterEmployees(employees);
        assertEquals(3, filtered.size());
    }

    @Test
    public void filter_is_less_equals_than_salary() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("John", "5149999999", 1000));
        employees.add(new Employee("Jane", "5149999999", 1500));
        employees.add(new Employee("John", "5149999999", 2000));
        IEmployeeFilter filter = new EmployeeSalaryFilter(ListFilter.LESSEQUALS, 1500);
        List<Employee> filtered = filter.filterEmployees(employees);
        assertEquals(2, filtered.size());
    }
}
