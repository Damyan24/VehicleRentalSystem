package invoices;

import customers.Customer;
import services.CustomerService;
import vehicles.Car;
import vehicles.CargoVan;
import vehicles.Motorcycle;
import vehicles.Vehicle;

import java.text.DecimalFormat;
import java.time.LocalDate;

public abstract class Invoice {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private static final Vehicle vehicle = CustomerService.getVehicle();

    private static final Customer customer = CustomerService.getCustomer();

    private static final LocalDate startingDay = CustomerService.getReservationStart();

    private static final int expectedRentLength = CustomerService.getExpectedLength();

    private static final int actualRentLength = CustomerService.getActualLength();

    private static int costPerDay ;

    private static float insurancePerDay;

    private static float initialInsurancePerDay = Float.parseFloat(df.format(insurancePerDay * vehicle.getValue()));

    private static float finalInsurancePerDay = initialInsurancePerDay;


    public static void setFinalInsurancePerDay(float finalInsurancePerDay) {
        Invoice.finalInsurancePerDay = finalInsurancePerDay;
    }






    private static void invoiceBeginning() {
        System.out.println("XXXXXXXXXX\nDate:" + startingDay + "\nCustomer Name:"
                + customer.getName() + "\nRented Vehicle:" + vehicle.getBrand() + " " + vehicle.getModel());

        System.out.println();
    }

    private static void invoicePeriodInfo() {
        System.out.println("Reservation start date:" + startingDay + "\nReservation end date:" + startingDay.plusDays(expectedRentLength)
                + "\nReserved rental days:" + expectedRentLength + " days\n\n" +
                "Actual Return Date:" + startingDay.plusDays(actualRentLength) +"\nActual rental days:"+ actualRentLength + " days");

        System.out.println();
    }




    public static void checkForEarlyReturn(){
        if(getActualRentLength() < getExpectedRentLength()) {

            int countOfNotUsedDays = getExpectedRentLength() - getActualRentLength();

            float earlyReturnRentDiscount = Float.parseFloat(df.format(countOfNotUsedDays * ((float) costPerDay / 2)));

            float earlyReturnInsuranceDiscount = countOfNotUsedDays * finalInsurancePerDay ;

            System.out.println("Early return discount for rent:$" + df.format(earlyReturnRentDiscount));
            System.out.println("Early return discount for insurance:$" + df.format(earlyReturnInsuranceDiscount) );
            System.out.println();
        }
    }

    public static void giveTotal(){

        float usedDays = costPerDay * getActualRentLength();
        float notUsedDays = ((float) costPerDay /2) * (getExpectedRentLength() - getActualRentLength());

        float totalRent = usedDays + notUsedDays;
        float totalInsurance = Float.parseFloat(df.format(getActualRentLength() * finalInsurancePerDay));

        System.out.println("Total rent:$" + df.format(totalRent));
        System.out.println("Total insurance:$" + df.format(totalInsurance));
        System.out.println("Total:$" + df.format(totalRent + totalInsurance));
        System.out.println("XXXXXXXXXX");
    }






    public static void returnInvoice(){

        setCostAndInsurancePerDay();

        if(vehicle instanceof Car){
            CarInvoice carInvoice = new CarInvoice();



            carInvoice.startMessage();

            invoiceBeginning();

            invoicePeriodInfo();

            carInvoice.initialCosts();

            Invoice.checkForEarlyReturn();

            Invoice.giveTotal();

        } else if (vehicle instanceof Motorcycle){
            MotorcycleInvoice motorcycleInvoice = new MotorcycleInvoice();

            motorcycleInvoice.startMessage();

            invoiceBeginning();

            invoicePeriodInfo();

            motorcycleInvoice.initialCosts();

            Invoice.checkForEarlyReturn();

            Invoice.giveTotal();
        }else{
            CargoVanInvoice cargoVanInvoice = new CargoVanInvoice();

            cargoVanInvoice.startMessage();

            invoiceBeginning();

            invoicePeriodInfo();

            cargoVanInvoice.initialCosts();

            Invoice.checkForEarlyReturn();

            Invoice.giveTotal();

        }
    }









    private static void setCostAndInsurancePerDay(){
        if(vehicle instanceof Car){

            if(actualRentLength > 7){
                costPerDay = 15;
            }else{
                costPerDay = ((Car) vehicle).getPricePerDay();
            }
            insurancePerDay = ((Car) vehicle).getInsurancePerDay();

        }else if (vehicle instanceof Motorcycle){

            if(actualRentLength > 7){
                costPerDay = 10;
            }else {
                costPerDay = ((Motorcycle) vehicle).getPricePerDay();
            }
            insurancePerDay = ((Motorcycle) vehicle).getInsurancePerDay();
        }else {
            if(actualRentLength > 7) {
                costPerDay = 40;
            }else{
                costPerDay = ((CargoVan) vehicle).getPricePerDay();
            }
            insurancePerDay = (((CargoVan) vehicle).getInsurancePerDay());
        }
    }


    public Vehicle getVehicle() {
        return vehicle;
    }


    public static float getFinalInsurancePerDay() {
        return finalInsurancePerDay;
    }



    public static int getExpectedRentLength() {
        return expectedRentLength;
    }

    public static int getActualRentLength() {
        return actualRentLength;
    }



}
