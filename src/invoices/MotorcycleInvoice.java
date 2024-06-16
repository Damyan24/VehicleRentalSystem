package invoices;

import customers.MotorcycleCustomer;
import services.CustomerService;
import vehicles.Motorcycle;

import java.text.DecimalFormat;

public class MotorcycleInvoice extends Invoice{

    private static final DecimalFormat df = new DecimalFormat("0.00");

    Motorcycle motorcycle = (Motorcycle) super.getVehicle();

    MotorcycleCustomer motorcycleCustomer = (MotorcycleCustomer) CustomerService.getCustomer();

    int costPerDay = (getActualRentLength() > 7) ? 10 : 15 ;

    float initialInsurancePerDay = Float.parseFloat(df.format(motorcycle.getInsurancePerDay() * motorcycle.getValue()));

    float finalInsurancePerDay = initialInsurancePerDay;





    @Override
    void startMessage() {
        System.out.println("A motorcycle valued at $" + df.format(motorcycle.getValue())+", and the driver is " + motorcycleCustomer.getAge() +" years old" );
        System.out.println();
    }



    public void initialCosts(){

        System.out.println("Rental cost per day:$" + df.format(costPerDay));

        if(motorcycleCustomer.getAge() < 25){

            float insuranceAddition = (float) (initialInsurancePerDay * 0.2);



            finalInsurancePerDay = insuranceAddition + initialInsurancePerDay;

            setFinalInsurancePerDay(finalInsurancePerDay);


            System.out.println("Initial insurance per day:$" + df.format(initialInsurancePerDay));
            System.out.println("Insurance addition per day:$" + df.format(insuranceAddition));
            System.out.println("Insurance per day:$" + df.format(finalInsurancePerDay));
        } else {
            System.out.println("Insurance per day:$" + df.format(initialInsurancePerDay));
            setFinalInsurancePerDay(initialInsurancePerDay);
        }

        System.out.println();

    }



}
