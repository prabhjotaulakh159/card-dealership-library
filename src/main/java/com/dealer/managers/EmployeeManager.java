package com.dealer.managers;

import java.util.InputMismatchException;

import com.dealer.data.loaders.IDataLoader;

/**
 * Manager class for employees
 */
public class EmployeeManager extends AbstractManager {
    private final int EXTRA_FEATURE = 3;
    private final int QUIT = 4;
    public EmployeeManager(IDataLoader dataLoader) {
        super(dataLoader);
    }

    @Override
    public void run() {
    System.out.println("Welcome To The Car Inventory Manager Fellow Employee! Here are you options below:");
    while(true){
        System.out.println(this.CAR_OPTION + ": view cars");
        System.out.println(this.CAR_FILTER_OPTION + ": filter cars");
        System.out.println(this.EXTRA_FEATURE + ": How to Become a Great Salesperson");
        System.out.println(this.QUIT + ": quit");
        System.out.print("Please choose an option from above >>> ");
        try{
            int input = Integer.parseInt(this.scanner.nextLine());
            if(input == this.CAR_OPTION){
                this.queryCars();
            }else if(input == this.CAR_FILTER_OPTION){
                this.filterCars();
            }
            

        }catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Please enter a valid option !");
        } 
      }   
    }

    private void becomeGreatSaleSperson(){
        System.out.println("Link to blogpost we took ideas from: https://blog.hubspot.com/sales/how-to-be-a-good-car-salesperson");
        System.out.println("Welcome to the BB Dealership, we have officially sold your soul for 62 cents and now there is no going back");
        System.out.println("Unless you pass this quiz and understand how we run this place and prioritize customers, you may have your soul back, but you're still working with us.");
        System.out.println("");
        
        
    }
    
    
    private void employeeQuiz(){
        final int TRUE= 1;
        final int FALSE = 2;
        int counter=0;

        System.out.println("Good Luck on our quiz! if you get 6/10 you pass! The Questions are True[1] or False[2].");
        System.out.println("1. You can yell at an angry customer. T/F? Enter 1 for True, 2 for False");
        int ans1= Integer.parseInt(this.scanner.nextLine());
        if(ans1 == FALSE){
            counter++;
        }
    }
}
