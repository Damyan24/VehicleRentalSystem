package invoices;

import vehicles.Car;

import java.text.DecimalFormat;

public class CarInvoice  extends  Invoice{

    private static final DecimalFormat df = new DecimalFormat("0.00");


    Car car = (Car) super.getVehicle();

    int costPerDay = (getActualRentLength() > 7) ? 15 : 20 ;

    float initialInsurancePerDay = Float.parseFloat(df.format(car.getInsurancePerDay() * car.getValue()));

    float finalInsurancePerDay = getFinalInsurancePerDay();

    float discountPerDay;




    public  void startMessage() {
        System.out.println("A car that is valued at " + df.format(car.getValue())+", and has security rating of " +car.getSafetyRating()+":");
        System.out.println();
    }



    public void initialCosts(){

        System.out.println("Rental cost per day:$" + df.format(costPerDay));

        if(car.getSafetyRating() <= 3){
            System.out.println("Insurance per day:$"+ df.format(initialInsurancePerDay));
            System.out.println();
            setFinalInsurancePerDay(initialInsurancePerDay);
        }else {



            discountPerDay = Float.parseFloat(df.format(initialInsurancePerDay * 0.1));
            finalInsurancePerDay = initialInsurancePerDay - discountPerDay;
            setFinalInsurancePerDay(finalInsurancePerDay);

            System.out.println("Initial insurance per day:$" + df.format(initialInsurancePerDay));
            System.out.println("Insurance discount per day:$" + df.format(discountPerDay));
            System.out.println("Insurance per day:$" + df.format(finalInsurancePerDay));

            System.out.println();
        }


    }






}
