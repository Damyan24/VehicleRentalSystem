import invoices.Invoice;
import services.CustomerService;
import services.VehicleService;




public class Main {
    public static void main(String[] args) {


        VehicleService.askForTypeOfVehicle();

        VehicleService.askForModel();

        CustomerService.getInfo();

        Invoice.returnInvoice();





    }

}

