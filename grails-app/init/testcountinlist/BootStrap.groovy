package testcountinlist

class BootStrap {

    def init = { servletContext ->
        Book book1 = new Book(name: 'The Shining', category: 'Fiction')
        Book book2 = new Book(name: 'It', category: 'Fiction')
        new Author(name: 'Stephen King')
          .addToBooks(book1)
          .addToBooks(book2)
          .save(flush: true, failOnError: true)
    }
    def destroy = {
    }
}
