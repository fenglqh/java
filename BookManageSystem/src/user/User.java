package user;

import book.BookList;
import operate.IOperate;

public abstract class User {
    private String name;
    protected IOperate operates[];
    public User(String name) {
        this.name = name;
    }

    public abstract int menu();

    public abstract void work(int choice, BookList bookList);
}
