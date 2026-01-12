import java.util.*;

public class Club {

    public static String clubName = "Cyber Strike";
    private static double totalRevenue = 0.0;
    private static int activeSessions = 0;


    private List<Device> devices = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();
    private List<Staff> staffMembers = new ArrayList<>();


    public <T> void printList(List<T> list) {
        if (list.isEmpty()) {
            System.out.println("Lista jest pusta.");
            return;
        }
        for (T item : list) {
            System.out.println(item.toString());
        }
    }

    public static void printWelcomeMessage() {
        System.out.println("========================================");
        System.out.println("   WITAMY W KLUBIE: " + clubName);
        System.out.println("========================================");
    }

    public static void printStatistics() {
        System.out.println("\n--- STATYSTYKA FINANSOWA KLUBU ---");
        System.out.println("Całkowity przychód: " + totalRevenue + " zł");
        System.out.println("Aktywnych sesji wynajmu: " + activeSessions);
        System.out.println("----------------------------------");
    }

    public void addDevice(Device d) { devices.add(d); }
    public void addClient(Client c) { clients.add(c); }
    public void addStaff(Staff s) { staffMembers.add(s); }

    public List<Device> getDevices() { return devices; }
    public List<Client> getClients() { return clients; }
    public List<Staff> getStaff() { return staffMembers; }

    public void rentDevice(Client client, Device device) throws InvalidBalanceException {
        if (device.getStatus() != DeviceStatus.AVAILABLE) {
            System.out.println("Błąd: Urządzenie " + device.getId() + " jest obecnie niedostępne (" + device.getStatus() + ")");
            return;
        }

        double cost = device.getPricePerHour();
        client.pay(cost);

        device.setStatus(DeviceStatus.OCCUPIED);
        device.bootUp();

        totalRevenue += cost;
        activeSessions++;

        System.out.println("Klient " + client.getName() + " pomyślnie wynajął " + device.getId());
    }

    public void showConsoleSpecificInfo() {
        System.out.println("\n--- SPRAWDZANIE KONSOL ---");
        for (Device d : devices) {
            if (d instanceof Console) {
                Console c = (Console) d;
                System.out.println("Konsola " + c.getId() + ", Liczba padów: " + c.getGamepadCount());
            }
        }
    }
}