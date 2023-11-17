package com.dealer.data.sorters;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.sorters.impl.EmployeeNameSorter;
import com.dealer.models.people.Employee;

public class EmployeeNameSorterTest {
    @Test
    public void sorts_ascending() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Bob", "9999999999", 100000));
        employees.add(new Employee("Adam", "99999999990", 100000));
        AbstractEmployeeSorter sorter = new EmployeeNameSorter(Order.ASCENDING);
        sorter.sortEmployees(employees);
        assertTrue(employees.get(0).getName().equals("Adam"));
    }

    @Test
    public void sorts_descending() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Adam", "99999999990", 100000));
        employees.add(new Employee("Bob", "9999999999", 100000));
        AbstractEmployeeSorter sorter = new EmployeeNameSorter(Order.DESCENDING);
        sorter.sortEmployees(employees);
        assertTrue(employees.get(0).getName().equals("Bob"));
    }
}
