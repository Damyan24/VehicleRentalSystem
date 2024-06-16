package vehicles;

public class Vehicle {



    private String brand;

    private String model;

    private int value;




    public Vehicle(String brand, String model, int value ) {
        this.brand = brand;
        this.model = model;
        this.value = value;
    }



    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }



}