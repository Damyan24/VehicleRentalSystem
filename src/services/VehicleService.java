package services;

import vehicles.Car;
import vehicles.CargoVan;
import vehicles.Motorcycle;
import vehicles.Vehicle;

import java.util.List;
import java.util.Scanner;

public class VehicleService {

   private static final Scanner scanner = new Scanner(System.in);

   private static int vehicleOption ;

   private static Vehicle vehicle;


    public static Vehicle getVehicle() {
        return vehicle;
    }

    public static void askForTypeOfVehicle(){
        System.out.println("Hello, what type of vehicle would you like to rent:\n1.Car\n2.Motorcycle \n3.Cargo van \n0.Exit ");

        vehicleOption = Integer.parseInt(scanner.nextLine());


        if((vehicleOption < 1 || vehicleOption > 3) && vehicleOption != 0){
            System.out.println("Invalid option, please try again!");

            askForTypeOfVehicle();
        }


    }


    public static void askForModel(){

        switch (vehicleOption){

            case 1 :
                System.out.println("Which one of our cars would you like:");

                List<Car> cars = Garage.getCars();

                int countOfCars = 1;

                for(Car car : cars){
                    System.out.println(countOfCars++ + "." + car.getBrand() + " " + car.getModel() + " - with safety rating of " + car.getSafetyRating());
                }


                vehicle = cars.get(Integer.parseInt(scanner.nextLine()) - 1);

                break;

            case 2:
                System.out.println("Which one of our motorcycles would you like:");

                List<Motorcycle> motorcycles = Garage.getMotorcycles();

                int motorcycleCount = 1;

                for(Motorcycle motorcycle : motorcycles){
                    System.out.println(motorcycleCount++ + "." + motorcycle.getBrand() + " " + motorcycle.getModel());
                }


                vehicle = motorcycles.get(Integer.parseInt(scanner.nextLine()) - 1);

                break;

            case 3:

            System.out.println("Which one of our cargo vans would you like:");

            List<CargoVan> vans = Garage.getCargoVans();

            int vanCount = 1;

            for(CargoVan van : vans){
                System.out.println(vanCount++ + "." + van.getBrand() + " " + van.getModel());
            }


            vehicle = vans.get(Integer.parseInt(scanner.nextLine()) - 1);

            break;
        }


    }







}
