package md.utm;

public class Vehicle {

    private long id;
    private String brand;

    public Vehicle() {

    }

    public Vehicle(long id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.brand = name;
    }
}
