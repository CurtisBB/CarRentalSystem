package carrentalsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *car booking class
 * @author Curtis
 */
public class CarBooking {
    
    // booking start date
    private LocalDate startDate;
    
    // booking end date
    private LocalDate endDate;
    
    // ID number of car
    private int carNumber;
    
    // total booking days
    private long totalDays;
    
    // calculated booking rate
    private  double newRate;
    
    // total cost of booking
    private double cost;
    
    // car associated with booking
    private Car car;
    
    
    // constructor to initialise instance variables
    public CarBooking(LocalDate startDate, LocalDate endDate, int carNumber) 
            throws FileNotFoundException {
        super();
        this.startDate = startDate;
        this.endDate = endDate;
        this.carNumber = carNumber;
        makeBooking();    
    }
    
    // reads file and stores car details in array
    public void makeBooking() {
	try {
            String carFile = MenuDisplay.CarListFile;
            File file = new File(carFile);
            BufferedReader r = new BufferedReader(new FileReader(file));
            String line;
            while((line = r.readLine()) != null) {
		String[] p = line.split(",");
		
                if(Integer.valueOf(p[0]) == carNumber){
                    // make premium car
                    if(p[4].trim().equals("Premium"))
			car = new PremiumCar(Double.valueOf(p[5].trim()),p[1]);
                    else
			car = new Car(Double.valueOf(p[5].trim()), p[1]);
			
                    newRate = car.getCarRate();
                    totalDays = calculateTotalDays();
                    calculateCost(newRate, totalDays);
                    r.close();
                    return;
		}
            }

            System.out.println("No such car exists.");
            r.close();
            System.exit(0);

	} catch(IOException e) {
            System.out.println("Invalid file.");
            System.exit(0);
        }
    }
    
    // returns days between start and end date
    public long calculateTotalDays() {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }
    
    // calculates cost of car
    public void calculateCost(double newRate, long totalDays) {
        cost = newRate * totalDays;
    }
    
    // returns cost of car
    public double getCost() {
        return cost;
    }
    
    // returns booking start date
    public LocalDate getStartDate() {
        return startDate;
    }
    
    // returns booking end date
    public LocalDate getEndDate() {
        return endDate;
    }
    
    // returns total days
    public long getTotalDays() {
        return totalDays;
    }
    
    // returns cars ID number
    public int getCarNumber() {
        return carNumber;
    }
    
    // returns car rate
    public double getNewRate() {
        return newRate;
    }
    
    // returns car for booking
    public Car getCar() {
        return car;
    }
}
