package user;

public abstract class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public abstract int menu();
}
