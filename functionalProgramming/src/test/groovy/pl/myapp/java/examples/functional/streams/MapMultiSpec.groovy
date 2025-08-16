package pl.myapp.java.examples.functional.streams


import spock.lang.Specification
import spock.lang.Subject

import java.time.LocalDate

class MapMultiSpec extends Specification {

    @Subject
    MapMulti mapMultiExample = new MapMulti()

    def "should filter out even integers and double their value"() {
        given:
        def input = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
        def expected = [4, 8, 12, 16, 20, 24, 28]

        when:
        def result = mapMultiExample.evenDoubledNumbersClassic(input)

        then:
        result == expected

        when:
        def result2 = mapMultiExample.evenDoubledNumbersNew(input)

        then:
        result2 == expected
    }

    def "should flatten Author - Book one-to-many relationship and return list of Bookshelf"() {
        given:
        def book1 = new MapMulti.Book('First Book Title', LocalDate.parse('2023-04-17'))
        def book2 = new MapMulti.Book('Second Book Title', LocalDate.parse('2011-10-25'))
        def book3 = new MapMulti.Book('Third Book Title', LocalDate.parse('2015-01-01'))
        def book4 = new MapMulti.Book('Fourth Book Title', LocalDate.parse('2020-12-31'))
        def author1 = new MapMulti.Author('Author One', [book1, book2])
        def author2 = new MapMulti.Author('Author Two', [book3])
        def author3 = new MapMulti.Author('Author Three', [book4])

        when:
        def result = mapMultiExample.bookshelfClassic([author1, author2, author3])

        then:
        result.size() == 4
        result[0].author == 'Author One'
        result[0].book == 'First Book Title'
        result[1].author == 'Author One'
        result[1].book == 'Second Book Title'
        result[2].author == 'Author Two'
        result[2].book == 'Third Book Title'
        result[3].author == 'Author Three'
        result[3].book == 'Fourth Book Title'

        when:
        def result2 = mapMultiExample.bookshelfNew([author1, author2, author3])

        then:
        result == result2
    }
}
