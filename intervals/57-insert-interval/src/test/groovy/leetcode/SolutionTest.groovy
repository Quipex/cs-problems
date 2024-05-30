package leetcode

import spock.lang.Specification

class SolutionTest extends Specification {
    private Solution s = new Solution()

    def "insert an interval into empty array"() {
        given:
        int[][] intervals = []
        int[] newInterval = [4, 5]

        when:
        var actual = s.insert(intervals, newInterval)

        then:
        aToL(actual) == [[4, 5]]
    }

    def "insert a non-overlapping interval"() {
        given:
        int[][] intervals = [[1, 3], [6, 9]]
        int[] newInterval = [4, 5]

        when:
        var actual = s.insert(intervals, newInterval)

        then:
        actual == [[1, 3], [4, 5], [6, 9]] as int[][]
    }

    def "insert an overlapping interval"() {
        expect:
        aToL(s.insert(lToA(intervals), newInterval)) == expectedIntervals

        where:
        intervals                                   | newInterval     || expectedIntervals
        [[1, 3], [6, 9]]                            | [2, 5] as int[] || [[1, 5], [6, 9]]
        [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]] | [4, 8] as int[] || [[1, 2], [3, 10], [12, 16]]
    }

    static int[][] lToA(List<List<Integer>> list) {
        if (list == null) {
            return null;
        }

        int numRows = list.size();
        int[][] array = new int[numRows][];

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = list.get(i);
            int numCols = row.size();
            array[i] = new int[numCols];
            for (int j = 0; j < numCols; j++) {
                array[i][j] = row.get(j);
            }
        }

        return array;
    }

    static List<List<Integer>> aToL(int[][] array) {
        if (array == null) {
            return null;
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int[] row : array) {
            List<Integer> rowList = new ArrayList<>();
            for (int val : row) {
                rowList.add(val);
            }
            list.add(rowList);
        }

        return list;
    }

    static String convertIntervalsToString(int[][] intervals) {
        if (intervals == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < intervals.length; i++) {
            sb.append("[");
            for (int j = 0; j < intervals[i].length; j++) {
                sb.append(intervals[i][j]);
                if (j < intervals[i].length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            if (i < intervals.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
