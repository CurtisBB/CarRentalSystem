package carrentalsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *Class that displays menu
 * @author Curtis
 */
public class MenuDisplay {
    
    public int carsAvailiable;

    //csv file variable
    static String CarListFile = "CarList.csv";

    public int displayCarList() throws FileNotFoundException {
        System.out.println("***********************************"
                + "***********************************"
                + "\n                 Welcome to the Carrington Car"
                + " Rental                 "
                + "\n***********************************"
                + "***********************************"
                + "\nCars availiable for booking:"
                + "\n___________________________________"
                + "___________________________________");
        try {
            // Open and read the csv file
            File file = new File(CarListFile);
            Scanner input = new Scanner(file);
            System.out.format("%-9s%-16s%-8s%-15s%-11s%-10s\n", "Car No.", 
                "Car Name", "Seats", "Transmission", "Car Type", "Rate/Day($)");
            System.out.format("%-9s%-16s%-8s%-15s%-11s%-10s\n", "-------",
                "--------", "-----", "------------", "--------", "-----------");
            // Retrieve each record of car file and display them
            while (input.hasNextLine()) {
                carsAvailiable++;
                String line = input.nextLine();
                String[] fields = line.split(",");
                String carNo = fields[0];
                String carName = fields[1];
                String seats = fields[2];
                String transmission = fields[3];
                String carType = fields[4];
                String dayRate = fields[5];
            
                System.out.format("%-9s%-16s%-8s%-15s%-11s%-10s\n", carNo,
                    carName, seats, transmission, carType, dayRate);
            }
            
            input.close();
        } catch(IOException e) {
            System.out.println("File not found!");
            System.exit(0);
        }        
        return carsAvailiable;
    }
    
    public static int getSelection() {
        boolean valid = false;
        Scanner input = new Scanner(System.in);
        int selection = 0;
        
        System.out.println("\nPlease select from one of the following options");
        System.out.format("%28s%28s\n", "1. To make a booking\n", "2. To exit "
                + "the system");
        while(valid != true){
            System.out.print("\nPlease enter your selection: ");
            // This checks to see if the next input is a valid **int**
            if(input.hasNextInt()){ 
                selection = input.nextInt();
                valid = true;
                if(selection > 2 || selection <= 0 ){
                    System.out.print("Not a valid choice!\n");
                    valid = false;
                }
                if(selection == 2) {
                    System.out.println("Have a nice day!");
                    System.exit(0);
                }
            }else{
                System.out.print("Not a valid choice!\n");
                input.next();
            }
        }      
                
        return selection;
    }
}
