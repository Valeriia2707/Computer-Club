public class Client extends Person {
    private double balance;

    public Client(String name, String email, double balance) {
        super(name, email);
        this.balance = balance;
    }

    @Override
    public String getRole() { return "CLIENT"; }

    public double getBalance() { return balance; }

    public void addFunds(double amount) {
        if (amount > 0) this.balance += amount;
    }


    public void pay(double amount) throws InvalidBalanceException {
        if (this.balance < amount) {
            throw new InvalidBalanceException("Za mało pieniędzy! Saldo:" + balance + ", potrzebuję: " + amount);
        }
        this.balance -= amount;
        System.out.println("Płatność zakończona sukcesem. Reszta: " + balance);
    }
}