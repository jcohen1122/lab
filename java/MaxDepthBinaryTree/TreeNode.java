package MaxDepthBinaryTree;

/*
Definition for a binary tree node.
*/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ldepth = maxDepthHelper(root.left, 1);
        int rdepth = maxDepthHelper(root.right, 1);

        return Math.max(ldepth, rdepth);
    }

    public int maxDepthHelper(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        int ldepth = maxDepthHelper(root.left, depth + 1);
        int rdepth = maxDepthHelper(root.right, depth + 1);

        return Math.max(ldepth, rdepth);
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution solution = new Solution();
        int depth = solution.maxDepth(root);
        System.out.println("Max Depth of the Binary Tree: " + depth); // Output: 3
    }
}