package vehicles;

public class CargoVan extends Vehicle {

    private final int pricePerDay = 50;


    private final float insurancePerDay = 0.0003f;


    public CargoVan(String brand, String model, int value) {
        super(brand, model, value);
    }


    public int getPricePerDay() {
        return pricePerDay;
    }

    public float getInsurancePerDay() {
        return insurancePerDay;
    }
}
