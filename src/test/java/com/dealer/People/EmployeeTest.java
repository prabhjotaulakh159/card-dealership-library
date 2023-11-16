package com.dealer.People;

import com.dealer.models.people.Employee;
import com.dealer.models.people.Person;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

@SuppressWarnings("unused")
public class EmployeeTest {
    @Test
    public void employee_constructor_works(){
        Person person= new Employee("Jake", " 877-627-5757", 70000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void consutrctor_invalid_salary(){
        Person person= new Employee("Jake", " 877-627-5757", -70000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void consutrctor_invalid_name_null(){
        Person person= new Employee(null, " 877-627-5757", 70000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void consutrctor_invalid_name_emptyString(){
        Person person= new Employee("", " 877-627-5757", 70000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void consutrctor_invalid_name_blankString(){
        Person person= new Employee("   ", " 877-627-5757", 70000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void consutrctor_invalid_phoneNumber_null(){
        Person person= new Employee("Jake", null , 70000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void consutrctor_invalid_phoneNumber_emptyString(){
        Person person= new Employee("Jake", "" , 70000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void consutrctor_invalid_phoneNumber_BlankString(){
        Person person= new Employee("Jake", "   " , 70000);
    }

    @Test
    public void equals_method_works(){
        Person person1= new Employee("Jake", "877-627-5757" , 70000);
        Person person2= new Employee("Jake", "877-627-5757" , 70000);
        assertTrue(person1.equals(person2));
    }

    @Test
    public void equals_method_not_Work(){
        Person person1= new Employee("Mason", "877-627-5757" , 70000);
        Person person2= new Employee("Jake", "877-627-5757" , 75000);
        assertFalse(person1.equals(person2));
    }
}
