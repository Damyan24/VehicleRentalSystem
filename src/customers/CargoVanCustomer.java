package customers;

public class CargoVanCustomer extends Customer{

    int yearsOfDrivingExperience;

    public CargoVanCustomer(String name , int yearsOfDrivingExperience) {
        super(name);
        this.yearsOfDrivingExperience = yearsOfDrivingExperience;
    }

    public int getYearsOfDrivingExperience() {
        return yearsOfDrivingExperience;
    }
}
