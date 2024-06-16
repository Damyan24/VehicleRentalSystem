package invoices;
import customers.CargoVanCustomer;
import services.CustomerService;
import vehicles.CargoVan;
import java.text.DecimalFormat;

public class CargoVanInvoice extends Invoice{

    private static final DecimalFormat df = new DecimalFormat("0.00");


    CargoVan cargoVan = (CargoVan) super.getVehicle();

    CargoVanCustomer cargoVanCustomer = (CargoVanCustomer) CustomerService.getCustomer();


    int costPerDay = (getActualRentLength() > 7) ? 40 : 50 ;

    float initialInsurancePerDay = Float.parseFloat(df.format(cargoVan.getInsurancePerDay() * cargoVan.getValue()));

    float finalInsurancePerDay = initialInsurancePerDay;




    void startMessage() {
        System.out.println("A cargo van valued at $" + df.format(cargoVan.getValue()) + ", and the driver has " + cargoVanCustomer.getYearsOfDrivingExperience());
        System.out.println();

    }



    public void initialCosts(){

        System.out.println("Rental cost per day:$" + df.format(costPerDay));

        if(cargoVanCustomer.getYearsOfDrivingExperience() > 5){

            float insuranceDiscount = (float) (initialInsurancePerDay * 0.2);

            setFinalInsurancePerDay(finalInsurancePerDay);

            finalInsurancePerDay = initialInsurancePerDay - insuranceDiscount;

            setFinalInsurancePerDay(finalInsurancePerDay);


            System.out.println("Initial insurance per day:$" + df.format(initialInsurancePerDay));
            System.out.println("Insurance discount per day:$" + df.format(insuranceDiscount));
            System.out.println("Insurance per day:$" + df.format(finalInsurancePerDay));
        } else {
            System.out.println("Insurance per day:$" + df.format(initialInsurancePerDay));
            setFinalInsurancePerDay(initialInsurancePerDay);
        }

        System.out.println();

    }






}
