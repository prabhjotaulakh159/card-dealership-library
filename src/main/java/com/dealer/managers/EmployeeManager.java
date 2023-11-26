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
        System.out.println("Link to blogpost we took inspiration from: https://blog.hubspot.com/sales/how-to-be-a-good-car-salesperson");
        System.out.println("Welcome to the BB Dealership, we have officially sold your soul for 62 cents and now there is no going back");
        System.out.println("Unless you pass this quiz and understand how we run this place and prioritize customers, you may have your soul back, but you're still working with us.");
        System.out.println("Failure in passing our quiz will lead you to immediate termination of your job. Be aware of that, HAVE FUN READING! make us proud :3");

        System.out.println();
        System.out.println("10 tips to know when becoming a greate Car Salesman!");
        System.out.println("1. Always remember your clients names, to build general respect and courtesy when discussing about a potential vehicle");
        System.out.println("2. Ask the Right Questions! Asking the right questions will provide yourself context on the car that the customer is wanting to buy. \n A good question to a customer may be: \"What are your must-haves in a car?\" ");
        System.out.println("3. Build Rapport. If someones feeling overwhelmed, be sure to talk about other things that they enjoy that steers back to the sale, making them feel more comftorable");
        System.out.println("4. Listen as Much as you can talk. Don't start rambling about the sales and asking a lot of questions to the customer. It feel disingenuin and gives them a bad remark. Take the time to listen and pause 1-2 seconds after the customer stops talking and reflect.");
        System.out.println("5. Treat customers equally. ");
        
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
