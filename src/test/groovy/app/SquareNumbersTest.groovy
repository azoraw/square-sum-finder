package app

import spock.lang.Specification

class SquareNumbersTest extends Specification {

    def "should fill square numbers"() {
        given:
        def numbers = new SquareNumbers(10)

        then:
        numbers.squares == [1, 4, 9, 16] as Set
    }
}
