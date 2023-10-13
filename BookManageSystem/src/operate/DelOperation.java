package operate;

import book.BookList;

public class DelOperation implements IOperate{
    @Override
    public void work(BookList bookList) {
        System.out.println("删除");
    }
}
