package leetcode

import spock.lang.Specification

class IntervalUtilsTest extends Specification {
    private IntervalUtils intervalUtils = new IntervalUtils()

    def "interval A is after interval B"() {
        expect:
        intervalUtils.aIsAfterB(intervalA, intervalB) == isTrue

        where:
        intervalA       | intervalB       || isTrue
        [0, 1] as int[] | [2, 3] as int[] || false
        [2, 3] as int[] | [0, 1] as int[] || true

        [0, 1] as int[] | [1, 2] as int[] || false
        [1, 2] as int[] | [0, 1] as int[] || false

        [0, 4] as int[] | [1, 2] as int[] || false
        [1, 2] as int[] | [0, 4] as int[] || false

        [1, 3] as int[] | [2, 4] as int[] || false
        [2, 4] as int[] | [1, 3] as int[] || false
    }

    def "merge two intervals together"() {
        expect:
        intervalUtils.merge(intervalA, intervalB) == mergedInterval

        where:
        intervalA       | intervalB       || mergedInterval
        [0, 1] as int[] | [2, 3] as int[] || [0, 3] as int[]
        [2, 3] as int[] | [0, 1] as int[] || [0, 3] as int[]

        [0, 1] as int[] | [1, 2] as int[] || [0, 2] as int[]
        [1, 2] as int[] | [0, 1] as int[] || [0, 2] as int[]

        [0, 4] as int[] | [1, 2] as int[] || [0, 4] as int[]
        [1, 2] as int[] | [0, 4] as int[] || [0, 4] as int[]

        [1, 3] as int[] | [2, 4] as int[] || [1, 4] as int[]
        [2, 4] as int[] | [1, 3] as int[] || [1, 4] as int[]
    }
}
