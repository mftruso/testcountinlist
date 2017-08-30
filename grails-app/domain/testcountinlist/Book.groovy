package testcountinlist

class Book {

    String name
    String category

    static belongsTo = [author: Author]

    static constraints = {
    }
}
