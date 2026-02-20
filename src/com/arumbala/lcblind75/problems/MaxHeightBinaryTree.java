package com.arumbala.lcblind75.problems;

/**
 * Maximum Height of Binary Tree
 *
 * Given the root of a binary tree, return its maximum height.
 * Height is the number of edges along the longest path
 * from the root node down to the farthest leaf node.
 *
 * Example: [3,9,20,null,null,15,7] → 2
 * Example: [1,null,2] → 1
 * Example: [1] → 0
 * Example: [] → -1
 *
 * Time: O(n), Space: O(h) where h is height of tree
 */
public class MaxHeightBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    /**
     *   Simple rule:
     *   - Depth (nodes): null = 0, leaf = 1
     *   - Height (edges): null = -1, leaf = 0
     * @param root
     * @return
     */
    public static int maxHeight(TreeNode root) {
        if(root == null) return -1;
        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        //         3
        //        / \
        //       9   20
        //          /  \
        //         15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxHeight(root));   // Expected: 2
        System.out.println(maxHeight(null));   // Expected: -1

        TreeNode single = new TreeNode(1);
        System.out.println(maxHeight(single)); // Expected: 0

        TreeNode skewed = new TreeNode(1);
        skewed.right = new TreeNode(2);
        System.out.println(maxHeight(skewed)); // Expected: 1
    }
}