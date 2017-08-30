package testcountinlist

import grails.converters.JSON

class AuthorController {

    def index() {

    }

    def countByCategory(){
      String category = params.category
      List books = Book.findAllByCategory(category)
      def count = Author.countByBooksInList(books)
      render ([count: count] as JSON)
    }

    def listByCategory(){
      String category = params.category
      List books = Book.findAllByCategory(category)
      List authors = Author.findAllByBooksInList(books)
      render authors as JSON
    }
}
