package leetcode


import spock.lang.Specification

class HelloKtTest extends Specification {
    def s = new Solution()

    def "invertTree is inverting the empty tree"() {
        given:
        def emptyTree = new TreeNode(0)

        when:
        def invertedTree = s.invertTree(emptyTree)

        then:
        invertedTree.val == 0
    }

    def "invertTree is inverting a single-branch tree"() {
        given:
        /*
            0
            |\
            2 3
         */
        def singleBranchTree = new TreeNode(0)
        singleBranchTree.left = new TreeNode(2)
        singleBranchTree.right = new TreeNode(3)

        when:
        def invertedTree = s.invertTree(singleBranchTree)

        then:
        invertedTree.val == 0
        invertedTree.left.val == 3
        invertedTree.right.val == 2
    }

    def "invertTree is inverting a multiple-branch tree"() {
        given:
        /*
            0
            |\
            2   3
            |\  |\
            4 5 6 7
         */
        def multiBranchTree = new TreeNode(0)
        multiBranchTree.left = new TreeNode(2)
        multiBranchTree.left.left = new TreeNode(4)
        multiBranchTree.left.right = new TreeNode(5)
        multiBranchTree.right = new TreeNode(3)
        multiBranchTree.right.left = new TreeNode(6)
        multiBranchTree.right.right = new TreeNode(7)

        when:
        def invertedTree = s.invertTree(multiBranchTree)

        then:
        invertedTree.val == 0
        invertedTree.left.val == 3
        invertedTree.left.left.val == 7
        invertedTree.left.right.val == 6
        invertedTree.right.val == 2
        invertedTree.right.left.val == 5
        invertedTree.right.right.val == 4
    }

    def "invertTree is inverting a tree with uneven leaves"() {
        given:
        /*
            0
            |\
            2 null
         */
        def singleBranchTree = new TreeNode(0)
        singleBranchTree.left = new TreeNode(2)

        when:
        def invertedTree = s.invertTree(singleBranchTree)

        then:
        invertedTree.val == 0
        invertedTree.right.val == 2
        invertedTree.left == null
    }
}
