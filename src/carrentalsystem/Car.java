
package carrentalsystem;

/**
 * A car class that creates a car
 * @author Curtis
 */
public class Car {

    // car rate for day
    private double carRate;
    
    // car name
    private String carName;
    
    //Initialises car class 
    public Car(double carRate, String carName) {
        super();
        this.carRate = carRate;
        this.carName = carName;
    }
    
    // Returns car rate for the day
    public double getCarRate() {
        return carRate;
    }
    
    // Returns car name
    public String getCarName() {
        return carName;
    }
    
    // update car name with passed value
    public void setCarName(String carName) {
        this.carName = carName;
    } 
    
}
