public class Car {
    int id;
    String make;
    String model;
    int year;
    String color;
    double price;
    String registrationNumber;

    // Constructor
    public Car(int id, String make, String model, int year, String color, double price, String registrationNumber) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    // toString method for easy printing
    public String toString() {
        return "Car ID: " + id + ", Make: " + make + ", Model: " + model + ", Year: " + year + 
               ", Color: " + color + ", Price: $" + price + ", Registration: " + registrationNumber + "\n";
    }
}