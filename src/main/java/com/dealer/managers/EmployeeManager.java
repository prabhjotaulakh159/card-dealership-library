package com.dealer.managers;

import java.util.InputMismatchException;

import com.dealer.data.loaders.IDataLoader;

import java.util.Scanner;

/**
 * Manager class for employees
 */
@SuppressWarnings("unused")
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Link to blogpost we took inspiration from: https://blog.hubspot.com/sales/how-to-be-a-good-car-salesperson");
        System.out.println("Welcome to the BB Dealership, we have officially sold your soul for 62 cents and now there is no going back");
        System.out.println("Unless you pass this quiz and understand how we run this place and prioritize customers, you may have your soul back, but you're still working with us.");
        System.out.println("Failure in passing our quiz will lead you to immediate termination of your job. Be aware of that, HAVE FUN READING! make us proud :3");

        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println("10 tips to know when becoming a greate Car Salesman!");
        System.out.println("1. Always remember your clients names, to build general respect and courtesy when discussing about a potential vehicle");
        System.out.println("2. Ask the Right Questions! Asking the right questions will provide yourself context on the car that the customer is wanting to buy. \n -A good question to a customer may be: \"What are your must-haves in a car?\" ");
        System.out.println("3. Build Rapport. If someones feeling overwhelmed, be sure to talk about other things that they enjoy that steers back to the sale, making them feel more comftorable");
        System.out.println("4. Listen as Much as you can talk. Don't start rambling about the sales and asking a lot of questions to the customer. It feel disingenuin and gives them a bad remark. Take the time to listen and pause 1-2 seconds after the customer stops talking and reflect.");
        System.out.println("5. Treat customers equally. When you are working with multiple people trying to look for a car, akways bring both of them in he mix and not just one of them. It will indiciate that you care abou them, in which you should be. ");
        System.out.println("6. Don't disparage other dealers. So when talking about pricing an deals, don't go bashing other dealers about their deals so you can pursuade them in choosing ours, it's petty and not a good look. ");
        System.out.println("7. Don't be Pushy. When smenes doing multiple test drives, it feels frustrating repeating the same question of i they want to buy it. Say something like \" Is this a car you would buy today?\". \n This will make the buyers not cornered");
        System.out.println("8. Make eye Contact. When the customer is speaking, look a their gaze for a couple of seconds, change expressions and whatnot and altering the gaze. Or else they think you're creepy. You don't want us to tarnish out reputation no?");
        System.out.println("9. Avoid Using unrustworthy language. sentences like \" With all due respect \" are the most obnoxious sentences ever, use something like \"I see where you're coming from. Would you mind if I offered a different opinion?\" \n It's best you be honest with your client to get your message through");
        System.out.println("10. Don't look bored. Have fun and be interesting! Use the times when no clients come to strenghten your skills and become great!");
        System.out.println("------------------------------------------------------------");
        System.out.println();

        System.out.println("Are you ready to take the Quiz? y/n");
        String ans= sc.nextLine().toLowerCase();

        if(ans.equals("y")){
            employeeQuiz();
        }else{
            System.out.println("Alright then, see you soon when you're ready! Sike, you're doing it teehee");
            employeeQuiz();
        }
    }
    
    
    private void employeeQuiz(){
        final int TRUE= 1;
        final int FALSE = 2;
        int counter=0;

        System.out.println("Good Luck on our quiz! if you get 7/10 you pass! The Questions are True[1] or False[2].");
        System.out.println("1. You can yell at an angry customer. T/F? Enter 1 for True, 2 for False");
        int ans1= Integer.parseInt(this.scanner.nextLine());
        if(ans1 == FALSE){
            counter++;
        }

        System.out.println("2. When the buisness is being slow, it is advised to still keep your head up when a potential client comes over, even if none comes today T/F?");
        int ans2 = Integer.parseInt(this.scanner.nextLine());
        if(ans2 == TRUE){
            counter++;
        }

        System.out.println("3. Be desperate when selling a car to a client T/F");
        int ans3 = Integer.parseInt(this.scanner.nextLine());
        if(ans3 == FALSE){
            counter++;
        }

        System.out.println("4. Talk more and listen less T/F?");
        int ans4 = Integer.parseInt(this.scanner.nextLine());
        if(ans4 == FALSE){
            counter++;
        }

        System.out.println("5. When a married couple are trying to buy a car. Talk to both intead of 1 of them. T/F?");
        int ans5 = Integer.parseInt(this.scanner.nextLine());
        if(ans5 == TRUE){
            counter++;
        }

        System.out.println("6. Always remember the clients name T/F?");
        int ans6= Integer.parseInt(this.scanner.nextLine());
        if(ans6 == TRUE){
            counter++;
        }

        System.out.println("7 When you're talking about comparing prices with other dealers, always downplay other dealerships deals");
        int ans7 = Integer.parseInt(this.scanner.nextLine());
        if(ans7 == FALSE){
            counter++;
        }

        System.out.println("8. A good question may be \"What is something you are looking for in your car?\" T/F?");
        int ans8 = Integer.parseInt(this.scanner.nextLine());
        if(ans8 == TRUE){
            counter++;
        }

        System.out.println("9. Always have fun and enjoy your job T/F?");
        int ans9 = Integer.parseInt(this.scanner.nextLine());
        if(ans9 == TRUE){
            counter++;
        }

        System.out.println("You can use obnoxious sentences to get your point through T/F?");
        int ans10 = Integer.parseInt(this.scanner.nextLine());
        if(ans10 == FALSE){
            counter++;
        }

        if(counter >=7){
            System.out.println("Congrats on Passing! Your soul will be given back, have fun working!");
        }
    }
}