public abstract class Person implements Identifiable {
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public abstract String getRole();

    public String getName() { return name; }

    @Override
    public String getFullId() {
        return "[" + getRole() + "] " + name + " (" + email + ")";
    }
}