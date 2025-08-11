package pl.myapp.java.examples.functional.streamApi

import spock.lang.Specification
import spock.lang.Subject

class MapMultiExampleSpec extends Specification {

    @Subject
    MapMultiExample mapMultiExample = new MapMultiExample()

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
}
