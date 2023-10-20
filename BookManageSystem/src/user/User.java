package user;

<<<<<<< HEAD
import book.BookList;
import operate.IOperate;

public abstract class User {
    private String name;
    protected IOperate operates[];
=======
public abstract class User {
    private String name;

>>>>>>> 1057ee93a5e6272685f59534bfed6a77e5098a34
    public User(String name) {
        this.name = name;
    }

    public abstract int menu();
<<<<<<< HEAD

    public abstract void work(int choice, BookList bookList);
=======
>>>>>>> 1057ee93a5e6272685f59534bfed6a77e5098a34
}
