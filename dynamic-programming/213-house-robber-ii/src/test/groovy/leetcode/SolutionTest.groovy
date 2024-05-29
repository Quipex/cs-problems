package leetcode

import spock.lang.Specification

class SolutionTest extends Specification {
    private Solution s = new Solution();

    def "works correctly with different possible houses"() {
        expect:
        s.rob(houses as int[]) == max

        where:
        houses       || max
        [2, 3, 2]    || 3
        [1, 2, 3, 1] || 4
        [1, 2, 3]    || 3
        [0]          || 0
        [4]          || 4
        [0, 0, 0]    || 0
        [1, 0, 0, 2] || 2
    }
}
