package vehicles;

public class Car extends Vehicle {

    private int safetyRating;

    private final float insurancePerDay = 0.0001f;

    private final int pricePerDay = 20;





    public Car( String brand, String model, int value, int safetyRating) {
        super(brand,model,value);
        this.safetyRating = safetyRating;
    }

    public int getSafetyRating() {
        return safetyRating;
    }


    public float getInsurancePerDay() {
        return insurancePerDay;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

}
