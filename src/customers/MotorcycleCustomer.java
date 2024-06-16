package customers;

public class MotorcycleCustomer extends Customer {

    private int age;

    public MotorcycleCustomer(String name,int age) {
        super(name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
