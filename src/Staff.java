public class Staff extends Person {
    private String position;

    public Staff(String name, String email, String position) {
        super(name, email);
        this.position = position;
    }

    @Override
    public String getRole() { return "STAFF"; }

    public void fixDevice(Device device) {
        System.out.println("Pracownik " + getName() + " remontuje " + device.getId());
        device.setStatus(DeviceStatus.AVAILABLE);
    }
}