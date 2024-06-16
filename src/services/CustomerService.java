package services;

import vehicles.Car;
import customers.CargoVanCustomer;
import customers.Customer;
import customers.MotorcycleCustomer;
import vehicles.Motorcycle;
import vehicles.Vehicle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CustomerService {

    private static final Scanner scanner = new Scanner(System.in);

    private static Customer customer;

    private static final Vehicle vehicle = VehicleService.getVehicle();

    private static LocalDate reservationStart;

    private static int expectedLength;

    private static int actualLength;


    public static int getActualLength() {
        return actualLength;
    }

    public static Vehicle getVehicle() {
        return vehicle;
    }

    public static LocalDate getReservationStart() {
        return reservationStart;
    }

    public static int getExpectedLength() {
        return expectedLength;
    }





    public static void getInfo(){

        askForCustomerInfo(vehicle);

        askForStartingDate();

        askForExpectedReservationPeriod();

        askForActualReservation();


    }







    public static void askForCustomerInfo(Vehicle vehicle){
        System.out.println("Could you give us your name?");
        String name = scanner.nextLine();


        if(vehicle instanceof Car){
            customer = new Customer(name);
        }else if (vehicle instanceof Motorcycle){
            System.out.println("We would also need your age, please.");
            int age = Integer.parseInt(scanner.nextLine());
            customer = new MotorcycleCustomer(name , age);
        }else{
            System.out.println("We would need to know your years of experience, please.");
            int yearsOfExperience = Integer.parseInt(scanner.nextLine());
            customer = new CargoVanCustomer(name,yearsOfExperience);
        }

    }



    public static void askForStartingDate(){
        System.out.println("Please enter a starting date in the format(dd-MM-yyyy)");
        String str = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        reservationStart =LocalDate.parse(str,formatter);

        if(reservationStart.isBefore(LocalDate.now())){
            System.out.println("""
                    Invalid date, cant use dates from the past.
                    
                    """);

            askForStartingDate();

        }

    }

    public static void askForExpectedReservationPeriod(){
        System.out.println("For how many days are you expecting to rent the vehicle?");

        expectedLength = Integer.parseInt(scanner.nextLine());
    }



    public static void askForActualReservation(){
        System.out.println("What was the actual length of the reservation?");

        int actualRentLength = Integer.parseInt(scanner.nextLine());

       if(actualRentLength < 0 || actualRentLength > expectedLength) {
           System.out.println("""
                   Invalid input.

                   """);
           askForActualReservation();
       }

        System.out.println();
        System.out.println();

       actualLength =  actualRentLength;

    }

    public static Customer getCustomer() {
        return customer;
    }
}
