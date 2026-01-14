import java.util.*;
//https://github.com/Valeriia2707/Computer-Club
public class Main {
    public static void main(String[] args) {
        Club myClub = new Club();
        Scanner scanner = new Scanner(System.in);

        ClubDataFactory.seedData(myClub);

        String[] menuItems = {
                "1. Lista sprzętu",
                "2. Sortuj według ceny",
                "3. Wynajmij urządzenie",
                "4. Serwis naprawczy",
                "5. Doładuj saldo",
                "6. Statystyki",
                "0. Wyjdź"
        };

        Club.printWelcomeMessage();
        boolean running = true;
        while (running) {
            System.out.println("\n========= GŁÓWNE MENU =========");

            for (String item : menuItems) {
                System.out.println(item);
            }
            System.out.print("Twój wybór: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("\n--- LISTA (Sortowanie według ID) ---");
                        Collections.sort(myClub.getDevices());
                        myClub.printList(myClub.getDevices());
                        break;

                    case 2:
                        System.out.println("\n--- LISTA (Sortowanie według ceny) ---");
                        myClub.getDevices().sort(new DevicePriceComparator());
                        myClub.printList(myClub.getDevices());
                        break;

                    case 3:
                        System.out.println("\n--- WYBIERZ KLIENTA ---");
                        List<Client> rClients = myClub.getClients();
                        for (int i = 0; i < rClients.size(); i++) {
                            System.out.println(i + ". " + rClients.get(i).getName() + " (Saldo: " + rClients.get(i).getBalance() + ")");
                        }
                        int rIdx = scanner.nextInt();

                        System.out.println("\n---WYBIERZ URZĄDZENIE ---");
                        List<Device> rDevices = myClub.getDevices();
                        for (int i = 0; i < rDevices.size(); i++) {
                            System.out.println(i + ". " + rDevices.get(i));
                        }
                        int dIdx = scanner.nextInt();

                        if (rIdx >= 0 && rIdx < rClients.size() && dIdx >= 0 && dIdx < rDevices.size()) {
                            myClub.rentDevice(rClients.get(rIdx), rDevices.get(dIdx));
                        } else {
                            System.out.println("Błąd: Nieprawidłowy numer!");
                        }
                        break;

                    case 4:
                        System.out.println("\n--- CENTRUM SERWISOWE ---");
                        List<Staff> sList = myClub.getStaff();
                        for (int i = 0; i < sList.size(); i++) {
                            System.out.println(i + ". " + sList.get(i).getName());
                        }
                        System.out.print("Kto naprawia? ");
                        int workerIdx = scanner.nextInt();

                        List<Device> fDevices = myClub.getDevices();
                        for (int i = 0; i < fDevices.size(); i++) {
                            System.out.println(i + ". " + fDevices.get(i).getId() + " [" + fDevices.get(i).getStatus() + "]");
                        }
                        System.out.print("Co naprawiamy? ");
                        int fixIdx = scanner.nextInt();

                        if (workerIdx >= 0 && workerIdx < sList.size() && fixIdx >= 0 && fixIdx < fDevices.size()) {
                            sList.get(workerIdx).fixDevice(fDevices.get(fixIdx));
                        } else {
                            System.out.println("Błąd: Nieprawidłowy wybór!");
                        }
                        break;

                    case 5:
                        System.out.println("\n--- UZUPEŁNIENIE KONTA ---");
                        List<Client> topUpList = myClub.getClients();
                        for (int i = 0; i < topUpList.size(); i++) {
                            System.out.println(i + ". " + topUpList.get(i).getName() + " (Saldo: " + topUpList.get(i).getBalance() + ")");
                        }
                        System.out.print("Numer klienta: ");
                        int cIdx = scanner.nextInt();

                        if (cIdx >= 0 && cIdx < topUpList.size()) {
                            System.out.print("Kwota: ");
                            double sum = scanner.nextDouble();
                            if (sum < 0) throw new InvalidBalanceException("Suma nie może być ujemna!");
                            topUpList.get(cIdx).addFunds(sum);
                            System.out.println("Saldo zostało zaktualizowane.");
                        } else {
                            System.out.println("Nie znaleziono klienta.");
                        }
                        break;

                    case 6:
                        Club.printStatistics();
                        myClub.showConsoleSpecificInfo();
                        break;

                    case 0:
                        running = false;
                        System.out.println("Wylogowanie z systemu... Do zobaczenia!");
                        break;

                    default:
                        System.out.println("Nieprawidłowy punkt!");
                }
            } catch (InvalidBalanceException e) {
                System.out.println("UWAGA: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("BŁĄD: Wprowadzaj tylko liczby!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Wystąpił błąd: " + e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}