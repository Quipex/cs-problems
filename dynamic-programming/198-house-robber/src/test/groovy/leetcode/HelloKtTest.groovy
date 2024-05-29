package leetcode

import spock.lang.Specification

class HelloKtTest extends Specification {
    private Solution s = new Solution()

    def "a single house gives a valid result"() {
        given: "single house"
        int[] houses = [4]

        when: "do the robbery"
        var max = s.rob(houses)

        then: "returns a valid result"
        max == 4
    }

    def "many houses give a valid result"() {
        expect:
        s.rob(houses as int[]) == max

        where:
        houses          || max
        [1, 2, 3, 1]    || 4
        [2, 7, 9, 3, 1] || 12
        [2, 0, 0, 2, 1] || 4
    }

    def "no-money houses give 0"() {
        given: "ho-money house"
        int[] houses = [0]

        when: "do the robbery"
        var max = s.rob(houses)

        then: "returns 0"
        max == 0
    }
}
