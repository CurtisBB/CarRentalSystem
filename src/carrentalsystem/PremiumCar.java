package carrentalsystem;

/**
 * class for the premium cars
 * @author Curtis
 */
public class PremiumCar extends Car {
    // insurance rate
    private static final double INSURANCERATE = 0.05;
    
    // premium car constructor
    public PremiumCar(double carRate, String carName) {
        super(carRate, carName);
    }
    
    // return premium car with insurace rate
    @Override
    public double getCarRate() {
        return (super.getCarRate() * INSURANCERATE) + super.getCarRate();
    }
}
