package com.arumbala.lcblind75.problems;

/**
 * Maximum Depth of Binary Tree
 *
 * Given the root of a binary tree, return its maximum depth.
 * Maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 *
 * Example: [3,9,20,null,null,15,7] → 3
 * Example: [1,null,2] → 2
 * Example: [] → 0
 *
 * Time: O(n), Space: O(h) where h is height of tree
 */
public class MaxDepthBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
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

        System.out.println(maxDepth(root));   // Expected: 3
        System.out.println(maxDepth(null));   // Expected: 0

        TreeNode single = new TreeNode(1);
        System.out.println(maxDepth(single)); // Expected: 1

        TreeNode skewed = new TreeNode(1);
        skewed.right = new TreeNode(2);
        System.out.println(maxDepth(skewed)); // Expected: 2
    }
}