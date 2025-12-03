package camera_rental_app;
public class Camera {
    private static int counter = 1;
    private int id;
    private String brand;
    private String model;
    private double rentPerDay;
    private String status;
    public Camera(String brand, String model, double rentPerDay) {
        this.id = counter++;
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.status = "Available";
    }
    public int getId() { return id; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getRentPerDay() { return rentPerDay; }
    public String getStatus() { return status; }
    public void setStatus(String status) {
        this.status = status;
    }
}