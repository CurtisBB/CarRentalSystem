package carrentalsystem;

import java.time.LocalDate;
import java.time.Year;
import java.util.Scanner;


/**
 * class that creates the booking date
 * @author Curtis
 */
public class CarAndBookingDates {
    
    private int year;
    private int month;
    private int day;
    
    // default constructor methods
    public CarAndBookingDates() {
        this.year = 0;
        this.month = 0;
        this.day = 0;
    }
    
    public CarAndBookingDates(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    // prompts user to select car from list and checks if valid choice    
    public int carSelection(int carsAvailiable){
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        int carSelection;
        
        System.out.println("\nTo make a booking:");
        System.out.print(" ".repeat(8) + "Select the car number from the "
                    + "car list: ");
        
        while(valid != true){
            if(input.hasNextInt()){
                carSelection = input.nextInt();
                valid = true;
                
                if(carSelection > carsAvailiable || carSelection <= 0){
                    System.out.print(" ".repeat(8) + 
                            "Invalid car selection, try again: ");
                    valid = false;
                }
            }else{
                System.out.print(" ".repeat(8) + 
                        "Invalid car selection, try again: ");
                input.next();
            }
        }
        
        return carsAvailiable;
    }
        
    // returns year, month, and day of booking date
    public LocalDate getCarBookingDateFull() {
        return LocalDate.of(year, month, day);
    }
    
    // prompt user for year
    public int promptForYear(){
        Scanner input = new Scanner(System.in);
        System.out.print(" ".repeat(8) + "Please enter the year - for example"
                + " '2022': ");
        try {
            year = input.nextInt();
            return year;
        } catch(Exception e) {
            System.out.println("Invalid year entry, try again: ");
            return promptForYear();
        }
    }
    
    // prompt user for month
    public int promptForMonth(){
        Scanner input = new Scanner(System.in);
        System.out.print(" ".repeat(8) + "Please enter the month number"
                + " - for example '6': ");
        try {
            month = input.nextInt();
            return month;
        } catch(Exception e) {
            System.out.println("Invalid month entry, try again: ");
            return promptForMonth();
        }
    }
    
    // prompt user for day
    public int promptForDay(){
        Scanner input = new Scanner(System.in);
        System.out.print(" ".repeat(8) + "Please enter the day number"
                + " - for example '21': ");
        try {
            day = input.nextInt();
            return day;
        } catch(Exception e) {
            System.out.println("Invalid day entry, try again: ");
            return promptForDay();
        }
    }
    
    // check year is valid
    public boolean validateYearString(String year) {
        int yearNow = Year.now().getValue();
        int yr = Integer.parseInt(year);
        
        if(yr < yearNow || yr > yearNow + 50) {
            return false;
        }
        
        return true;    
    }
    
    // check month is valid
    public boolean validateMonthString(String month) {
        int mth = Integer.parseInt(month);
        
        if(mth > 12 || mth <= 0) {
            return false;
        }
        
        return true;    
    }
    
    // check day is valid
    public boolean validateDayString(String day) {
        int dy = Integer.parseInt(day);
        int dayMax = 30;
        
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8
               || month == 10 || month == 12) {
            dayMax = 31;
        }
        if(month == 2) {
            dayMax = 28;
        }
        if(dy <=0 || dy > dayMax){
            return false;
        }
        
        return true;    
    }    
}
