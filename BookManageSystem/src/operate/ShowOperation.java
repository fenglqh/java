package operate;

import book.BookList;

public class ShowOperation implements IOperate{
<<<<<<< HEAD
    @Override
    public void work(BookList bookList) {
        int pos = bookList.getUsedSize();
        for (int i = 0; i < pos; i++) {
=======
    public void work(BookList bookList) {
        int usedsize = bookList.getUsedSize();
        for (int i = 0; i < usedsize; i++) {
>>>>>>> 1057ee93a5e6272685f59534bfed6a77e5098a34
            System.out.println(bookList.getBooks(i));
        }
    }

}
