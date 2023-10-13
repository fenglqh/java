package operate;

import book.BookList;

public class AddOperation implements IOperate{
    public void work(BookList bookList) {
        System.out.println("增加");
    }
}
