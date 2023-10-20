package book;

public class BookList {
    private final int MaxSize = 20;
    private Book[] books = new Book[MaxSize];
    private int usedSize;//记录书架中有多少书被使用了

    public int getUsedSize() {
        return usedSize;
    }

<<<<<<< HEAD
    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

=======
>>>>>>> 1057ee93a5e6272685f59534bfed6a77e5098a34
    public Book getBooks(int pos) {
        return books[pos];
    }

<<<<<<< HEAD
    public void setBooks(int pos, String name, String author, int price, String type) {
        this.books[pos] = new Book(name, author, price, type);
    }


=======
>>>>>>> 1057ee93a5e6272685f59534bfed6a77e5098a34
    public BookList() {
        books[0] = new Book("水浒传","罗贯中",26,"小说");
        books[1] = new Book("罗生门","芥川龙之下",36,"散文");
        books[2] = new Book("嫌疑人x的献祭","东野圭吾",69,"悬疑");
        books[3] = new Book("白夜行","东野圭吾",52,"爱情");
        this.usedSize = 4;
    }


<<<<<<< HEAD

=======
>>>>>>> 1057ee93a5e6272685f59534bfed6a77e5098a34
}
