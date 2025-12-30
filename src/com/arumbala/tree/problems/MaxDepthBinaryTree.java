package com.arumbala.tree.problems;

public class MaxDepthBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    /**
     * http://stackoverflow.com/questions/2597637/finding-height-in-binary-search-tree
     * @param root
     * @return
     */
    public static int getHeight(TreeNode root){
        if(root == null){
            return -1;
        }
        int maxLeft =  getHeight(root.left);
        int maxRight =  getHeight(root.right);
        return 1 + Math.max(maxLeft, maxRight);
    }

    // --------------------- Test code with main method ---------------------
    public static void main(String[] args) {
        // Build a sample binary tree:
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

        MaxDepthBinaryTree solution = new MaxDepthBinaryTree();

        System.out.println("=== Testing maxDepth ===");
        System.out.println("Max Depth: " + solution.maxDepth(root));        // Expected: 3

        System.out.println("Height using getHeight: " + getHeight(root));   // Expected: 2

        // Test empty tree
        System.out.println("\nEmpty tree:");
        System.out.println("Max Depth: " + solution.maxDepth(null));        // Expected: 0

        // Test single node
        TreeNode single = new TreeNode(1);
        System.out.println("\nSingle node tree:");
        System.out.println("Max Depth: " + solution.maxDepth(single));      // Expected: 1
    }
}
