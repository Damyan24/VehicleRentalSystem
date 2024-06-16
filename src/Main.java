import customers.Customer;
import invoices.Invoice;
import vehicles.Vehicle;
import services.CustomerService;
import services.VehicleService;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        VehicleService.askForTypeOfVehicle();

        VehicleService.askForModel();

        CustomerService.getInfo();

        Invoice.returnInvoice();





    }

}

