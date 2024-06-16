package vehicles;

public class Motorcycle extends Vehicle {

    private final int pricePerDay = 15;

    private final float insurancePerDay = 0.0002f;


    public int getPricePerDay() {
        return pricePerDay;
    }

    public Motorcycle(String brand, String model, int value) {
        super(brand, model, value);
    }


    public float getInsurancePerDay() {
        return insurancePerDay;
    }
}
