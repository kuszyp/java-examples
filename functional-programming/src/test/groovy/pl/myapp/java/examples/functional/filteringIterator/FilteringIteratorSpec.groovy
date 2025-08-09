package pl.myapp.java.examples.functional.filteringIterator

import spock.lang.Specification

class FilteringIteratorSpec extends Specification {
    def "should filter elements from the iterator and contain only even numbers"() {
        given:
        def numbers = [1, 2, 3, 4, 5, 6].iterator()
        def predicate = { it % 2 == 0 }
        def filteringIterator = new FilteringIterator(numbers, predicate)

        when:
        def result = filteringIterator.collect()

        then:
        result == [2, 4, 6]
    }

    def "should return empty list for no matching elements"() {
        given:
        def numbers = [1, 3, 5].iterator()
        def predicate = { it % 2 == 0 }
        def filteringIterator = new FilteringIterator(numbers, predicate)

        when:
        def result = filteringIterator.collect()

        then:
        result.isEmpty()
    }
}
