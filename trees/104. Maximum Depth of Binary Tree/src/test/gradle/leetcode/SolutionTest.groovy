package leetcode


import spock.lang.Specification

class SolutionTest extends Specification {
    def s = new Solution()

    def "MaxDepth should return 0 when empty tree"() {
        given: "tree with 0 elements"
        def emptyTree = null

        when:
        def depth = s.maxDepth(emptyTree)

        then:
        depth == 0
    }

    def "given tree with depth 3 and right-aligned, when depth calculated, then returns 3"() {
        given: "tree with depth 3 and right-aligned"
        def tree = new TreeNode(3)
        tree.left = new TreeNode(9)
        tree.right = new TreeNode(20)
        tree.right.left = new TreeNode(15)
        tree.right.right = new TreeNode(7)

        when:
        def depth = s.maxDepth(tree)

        then:
        depth == 3
    }

    def "given tree with depth 2 and right-aligned, when depth calculated, then returns 2"() {
        given: "tree with depth 2 and right-aligned"
        def tree = new TreeNode(1)
        tree.right = new TreeNode(2)

        when:
        def depth = s.maxDepth(tree)

        then:
        depth == 2
    }

    def "given tree with single element, when depth calculated, then returns 1"() {
        given:
        def tree = new TreeNode(1)

        when:
        def depth = s.maxDepth(tree)

        then:
        depth == 1
    }
}
