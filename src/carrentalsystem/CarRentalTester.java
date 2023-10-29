package carrentalsystem;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *Main class for the application
 * @author Curtis
 */
public class CarRentalTester {
    
    // Variable for MenuDisplay instance
    private static MenuDisplay menu;
    
    // Variable for Customer instance 
    private static Customer customer;
    
    // Variable for CarBooking instance
    private static CarBooking carBooking;
    
    // Variable for CarAndBookingDates instance
    private static CarAndBookingDates carAndBookingDates;
    
    // main testing point of app    
    public static void main(String[] args) throws FileNotFoundException {
       
        menu = new MenuDisplay();
        
        int cars = menu.displayCarList();
        
        System.out.println("___________________________________"
                + "___________________________________"
                + "\n Total " + cars + " cars available"
                + "\n" + "\n**Note for premium cars, there's an additional"
                + " 5% insurance excess \n  applied to the car rate");
        int choice = MenuDisplay.getSelection();
        
        if(choice == 1) {
            bookCar(cars);
        }
    }
    
    private static void bookCar(int cars) throws FileNotFoundException {
        LocalDate startDate;
        LocalDate endDate;
        Scanner input = new Scanner(System.in);
        int carNumber = 0;
        boolean choice = false;
        boolean date = false;
        System.out.println("\nTo make a booking");
        System.out.print(" ".repeat(8) + "Select the car number"
                        + " from the car list: ");
        
        while(!choice) {
            if(input.hasNextInt()){ 
                carNumber = input.nextInt();
                choice = true;
                
                if(carNumber > cars || carNumber <= 0 ){
                    System.out.print(" ".repeat(8) + "Invalid car selection,"
                        + " try again: ");
                    choice = false;
                }
            }else{
                System.out.print(" ".repeat(8) + "Invalid car selection,"
                        + " try again: ");
                input.next();
            }            
        } 
        
        do {
            System.out.println("\n" + " ".repeat(8) + "Enter booking start"
                    + " date.");
            startDate = getDate();

            System.out.println("\n" + " ".repeat(8) + "Enter booking"
                    + " end date.");
            endDate = getDate();

            if(startDate.compareTo(endDate) > 0){
                System.out.println("Start date can't be greater"
                        + " than the end date.");
            date = false;
            } else 
                date = true;
        } while(!date);
        
        //consumes empty line
        input.nextLine();
        
        System.out.print("\n" + " ".repeat(8) + "Your name: ");
	String customerName = input.nextLine();

	System.out.print("\n" + " ".repeat(8) + "Your Email: ");
	String customerEmail = input.nextLine();

	System.out.print("\n" + " ".repeat(8) + "Your residential address: ");
	String customerAddress = input.nextLine();

	carBooking = new CarBooking(startDate, endDate, carNumber);
	customer = new Customer(customerName, customerEmail, customerAddress);

	PrintBookingDetails.printBookingDetails(carBooking, customer); 
    }
    
    // user input for car booking dates, returns dates
    private static LocalDate getDate() {
        carAndBookingDates = new CarAndBookingDates();
        int year;
        int month;
        int day;
        boolean valid = false;
        
        do{
            year = carAndBookingDates.promptForYear();
            valid = carAndBookingDates.validateYearString(String.valueOf(year));
	} while(!valid);

	do{
            month = carAndBookingDates.promptForMonth();
            valid = carAndBookingDates.validateMonthString(String.valueOf(month));
	} while(!valid);

	do{
            day = carAndBookingDates.promptForDay();
            valid = carAndBookingDates.validateDayString(String.valueOf(day));
	} while(!valid);

	return carAndBookingDates.getCarBookingDateFull();
    }
}
