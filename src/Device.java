import java.util.Objects;

public abstract class Device implements Comparable<Device> {
    private String id;
    private String brand;
    private double pricePerHour;
    private DeviceStatus status;

    public Device(String id, String brand, double pricePerHour) {
        this.id = id;
        this.brand = brand;
        this.pricePerHour = pricePerHour;
        this.status = DeviceStatus.AVAILABLE;
    }

    public abstract void bootUp();


    public String getId() { return id; }
    public double getPricePerHour() { return pricePerHour; }
    public DeviceStatus getStatus() { return status; }
    public void setStatus(DeviceStatus status) { this.status = status; }


    @Override
    public int compareTo(Device other) {
        return this.id.compareTo(other.id);
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Brand: " + brand + " | Price: " + pricePerHour + "/h | Status: " + status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(id, device.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}