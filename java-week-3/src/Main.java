class Book
{
    public  void read()
    {
        System.out.println("Reading a book");
    }
}


class Library
{
    private  final  Book book = new Book();

    public  void  borrowBook()
    {
        book.read();
    }

}

