public class Console extends Device {
    private int gamepadCount;

    public Console(String id, String brand, double pricePerHour, int gamepadCount) {
        super(id, brand, pricePerHour);
        this.gamepadCount = gamepadCount;
    }

    @Override
    public void bootUp() {
        System.out.println("Konsola " + getId() + " uruchamia system i sprawdza " + gamepadCount + " gamepada.");
    }

    public int getGamepadCount() { return gamepadCount; }

    @Override
    public String toString() {
        return super.toString() + " [Typ: Console, Gamepads: " + gamepadCount + "]";
    }
}