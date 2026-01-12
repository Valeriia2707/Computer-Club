public class PC extends Device {
    private String gpu;

    public PC(String id, String brand, double pricePerHour, String gpu) {
        super(id, brand, pricePerHour);
        this.gpu = gpu;
    }

    @Override
    public void bootUp() {
        System.out.println("PC " + getId() + " ładuje system Windows i sterowniki " + gpu);
    }

    @Override
    public String toString() {
        return super.toString() + " [Typ: PC, GPU: " + gpu + "]";
    }
}