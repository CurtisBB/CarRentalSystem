package carrentalsystem;

import java.time.LocalDate;

/**
 *prints final output of booking details
 * @author Curtis
 */
public class PrintBookingDetails {
    
    // displays details of customer booking
    public static void printBookingDetails(CarBooking carBooking, 
            Customer customer) {
        System.out.println("\n-----------------------------------"
                + "-----------------------------------");
        System.out.print(" ".repeat(8) + "Thanks for your booking " 
                + customer.getCustomerName());
        System.out.print("\n" + " ".repeat(8) + "Email" + " ".repeat(25)  
                + customer.getCustomerEmail());
        System.out.print("\n" + " ".repeat(8) + "Address" + " ".repeat(23)  
                + customer.getCustomerAddress());
        System.out.print("\n" + " ".repeat(8) + "..............................."
                + ".................\n");
        System.out.println(" ".repeat(8) + "Booking Confirmed\n");
        System.out.println(" ".repeat(8) + "Here's your booking summary");
        System.out.println(" ".repeat(8) + "..............................."
                + ".................");
        System.out.print(" ".repeat(8) + "Car Selected" + " ".repeat(18) 
                + carBooking.getCar().getCarName());
        System.out.print("\n" + " ".repeat(8) + "Start Date" + " ".repeat(20)
                + getDate(carBooking.getStartDate()));
        System.out.print("\n" + " ".repeat(8) + "End Date" + " ".repeat(22)
                + getDate(carBooking.getEndDate()));
        System.out.print("\n" + " ".repeat(8) + "Number of days booked" 
                + " ".repeat(9) + carBooking.getTotalDays());
        System.out.print("\n" + " ".repeat(8) + "Car rate per day" 
                + " ".repeat(14) + carBooking.getNewRate());
        System.out.println("\n" + " ".repeat(8) + "________________________________"
                + "_______________\n");
        System.out.print(" ".repeat(8) + "Total cost" + " ".repeat(20)
                + carBooking.getCost());
        System.out.print("\n-----------------------------------"
                + "-----------------------------------");
        
    }
    
    private static String getDate(LocalDate date) {
		return date.toString();
	}
    
}
