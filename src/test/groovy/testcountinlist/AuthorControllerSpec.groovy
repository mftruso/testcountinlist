package testcountinlist

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification
import grails.testing.gorm.DataTest

class AuthorControllerSpec extends Specification implements ControllerUnitTest<AuthorController>, DataTest {
    void setupSpec() {
            mockDomains Book, Author
    }

    def setup() {
      Book book1 = new Book(name: 'The Shining', category: 'Fiction')
      Book book2 = new Book(name: 'It', category: 'Fiction')
      new Author(name: 'Stephen King')
        .addToBooks(book1)
        .addToBooks(book2)
        .save(flush: true, failOnError: true)
    }

    def cleanup() {
    }

    void "countByCategory"() {
        given:
        params.category = 'Fiction'

        when:
        controller.countByCategory()

        then:
        model.count == 1
    }
}
