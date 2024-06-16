package vehicles;

public class Car extends Vehicle {

    private final int safetyRating;


    public Car( String brand, String model, int value, int safetyRating) {
        super(brand,model,value);
        this.safetyRating = safetyRating;
    }

    public int getSafetyRating() {
        return safetyRating;
    }


    public float getInsurancePerDay() {
        float insurancePerDay = 0.0001f;
        return insurancePerDay;
    }

    public int getPricePerDay() {
        int pricePerDay = 20;
        return pricePerDay;
    }

}
