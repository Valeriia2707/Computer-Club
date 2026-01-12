import java.util.Comparator;

public class DevicePriceComparator implements Comparator<Device> {
    @Override
    public int compare(Device d1, Device d2) {
        return Double.compare(d1.getPricePerHour(), d2.getPricePerHour());
    }
}