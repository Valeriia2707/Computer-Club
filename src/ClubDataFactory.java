public class ClubDataFactory {


    public static void seedData(Club club) {
        Device[] pcs = {
                new PC("PC-01", "Alienware", 60.0, "RTX 4090"),
                new PC("PC-02", "HP Omen", 45.0, "RTX 3060"),
                new PC("PC-03", "ASUS ROG Strix", 55.0, "RTX 4080"),
                new PC("PC-04", "MSI Aegis", 38.5, "RTX 4070 Ti"),
                new PC("PC-05", "Lenovo Legion", 42.0, "RX 7900 XTX")
        };
        for (Device d : pcs) club.addDevice(d);

        Device[] consoles = {
                new Console("PS-01", "Sony PS5", 40.0, 2),
                new Console("XB-01", "Xbox Series X", 35.0, 4),
                new Console("NS-01", "Nintendo Switch OLED", 30.0, 2),
                new Console("SD-01", "Steam Deck OLED", 55.0, 1),
                new Console("PS-02", "Sony PS5 Pro", 70.0, 1)
        };
        for (Device d : consoles) club.addDevice(d);

        club.addClient(new Client("Aleksander", "aleksander@gmail.com", 150.0));
        club.addClient(new Client("Maria", "maria@wp.pl", 45.0));
        club.addClient(new Client("Jakub", "jakub@gmail.com", 120.5));
        club.addClient(new Client("Zofia", "zofia@o2.pl", 85.0));
        club.addClient(new Client("Michał", "michal@interia.pl", 200.0));

        club.addStaff(new Staff("Valeriia", "admin@cyber.pl", "Administrator"));
        club.addStaff(new Staff("Danil", "tech@cyber.pl", "Technik"));
        club.addStaff(new Staff("Darya", "manager@cyber.pl", "Menedżer"));
        club.addStaff(new Staff("Mark", "recepcja@cyber.pl", "Recepcjonista"));
    }
}
// ///