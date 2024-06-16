package services;

import vehicles.Car;
import vehicles.CargoVan;
import vehicles.Motorcycle;

import java.util.List;



public class Garage {



    private static class CarGarage {



       private static final Car toyota = new Car("Toyota", "Corolla", 35000, 5);
        private static final Car ford = new Car("Ford", "Focus", 22000, 4);
        private static final Car nissan = new Car("Nissan", "Altima", 16500, 3);

        private static  List<Car> cars = List.of(toyota,ford,nissan);

    }

    private static class MotorcycleGarage {



        private static final Motorcycle honda = new Motorcycle("Honda", "CBR600RR", 21000);
        private static final Motorcycle yamaha = new Motorcycle("Yamaha", "YZF-R6", 27000);
        private static final Motorcycle kawasaki = new Motorcycle("Kawasaki", "Ninja 650", 16500);

        private static  List<Motorcycle> motors = List.of(honda,yamaha,kawasaki);

    }



    private static class CargoVansGarage {



        private static final CargoVan mercedes = new CargoVan("Mercedes-Benz", "Sprinter", 70000);
        private static final CargoVan ford = new CargoVan("Ford", "Transit", 50000);
        private static final CargoVan ram = new CargoVan("Ram", "ProMaster", 61000);

        private static  List<CargoVan> vans = List.of(mercedes,ford,ram);

    }











    public static List<Car> getCars(){
        return CarGarage.cars;
    }

    public static  List<Motorcycle> getMotorcycles(){
        return MotorcycleGarage.motors;
    }

    public static List<CargoVan>  getCargoVans(){
        return CargoVansGarage.vans;
    }

}