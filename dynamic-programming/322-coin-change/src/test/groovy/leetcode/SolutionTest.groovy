package leetcode

import spock.lang.Specification

class SolutionTest extends Specification {
    private Solution solution = new Solution()

    def "when amount is 0, expect the answer to be 0"() {
        given:
        def amount = 0
        int[] coins = [1]

        when:
        def coinChange = solution.coinChange(coins, amount)

        then:
        coinChange == 0
    }

    def "when amount cannot be made of coins, the answer should be -1"() {
        given:
        def amount = 3
        int[] coins = [2]

        when:
        def coinChange = solution.coinChange(coins, amount)

        then:
        coinChange == -1
    }

    def "when amount can be made of coins, the answer is returning the fewest coins"() {
        expect:
        solution.coinChange(coins, amount) == answer

        where:
        coins                 | amount || answer
        [1, 3, 4, 5] as int[] | 7      || 2
        [1, 5] as int[]       | 7      || 3
        [1, 2, 5] as int[]    | 11     || 3
        [4, 5] as int[]       | 10     || 2
    }
}
