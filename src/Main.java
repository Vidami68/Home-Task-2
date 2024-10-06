import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;



public class Main {
    public static void main(String[] args) {
    	
        ArrayList<Car> cars = new ArrayList<>();
    	
        cars.add(new Car(1, "Toyota", "Camry", 2010, "Black", 8000, "ABC123"));
        cars.add(new Car(2, "BMW", "X5", 2015, "White", 15000, "XYZ456"));
        cars.add(new Car(3, "Toyota", "Corolla", 2005, "Blue", 5000, "DEF789"));
        cars.add(new Car(4, "Mercedes", "C-Class", 2020, "Silver", 30000, "GHI101"));
        
        // a) Calling List of Toyota cars
        ArrayList<Car> toyotaCars = getCarsByMake(cars, "Toyota");
        saveCarsToFile(toyotaCars, "toyotaCars.txt");
        
        System.out.println("List of Toyota cars:"+ "\n" + toyotaCars);
        
        // b) Calling list of "Camery" cars which have been in use for more than 10 years 
        ArrayList<Car> oldCamrys = getCarsByModelAndAge(cars, "Camry", 10);
        saveCarsToFile(oldCamrys, "oldCamrys.txt");
        
        System.out.println("\n" + "List of Camary cars which have been in use for more than 10 years:"+ "\n" + oldCamrys);

        // c) Calling list of cars with the manufacture year of 2015 and the price of which is higher than 12000
        ArrayList<Car> expensiveCars = getCarsByYearAndPrice(cars, 2015, 12000);
        saveCarsToFile(expensiveCars, "expensiveCars.txt");
        
        System.out.println("\n" + "list of cars with the manufacture year of 2015 and the price of which is higher than 12000" + "\n" + expensiveCars);
        

    }
    
  // Method to filter and save cars of a given brand to a file
    public static ArrayList<Car> getCarsByMake(ArrayList<Car> cars, String make) {
        ArrayList<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.make.equals(make)) {
                result.add(car);
            }
        }
        return result;
    }
    
  // Method to filter and save cars of a given model that have been in use for more than n years
    public static ArrayList<Car> getCarsByModelAndAge(ArrayList<Car> cars, String model, int n) {
        ArrayList<Car> result = new ArrayList<>();
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        for (Car car : cars) {
            if (car.model.equals(model) && (currentYear - car.year) > n) {
                result.add(car);
            }
        }
        return result;
    }
    
 // Method to filter and save cars of a given year of manufacture, the price of which is higher than the specified one
    public static ArrayList<Car> getCarsByYearAndPrice(ArrayList<Car> cars, int year, double minPrice) {
        ArrayList<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.year == year && car.price > minPrice) {
                result.add(car);
            }
        }
        return result;
    }
    
 // Save all cars to a file
    public static void saveCarsToFile(ArrayList<Car> cars, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Car car : cars) {
                writer.write(car.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
