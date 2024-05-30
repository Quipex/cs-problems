package leetcode

import spock.lang.Specification

class SolutionTest extends Specification {
    private Solution s = new Solution()

    def "should return largest sum of any subarray"() {
        expect:
        s.maxSubArray(subarray) == largestSum

        where:
        subarray                                 || largestSum
        [-2, 1, -3, 4, -1, 2, 1, -5, 4] as int[] || 6
        [1] as int[]                             || 1
        [5, 4, -1, 7, 8] as int[]                || 23
        [-1] as int[]                            || -1
    }
}
