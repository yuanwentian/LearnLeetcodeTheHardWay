/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class sol_101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        return (root == null) || checkSymmetric(root.left, root.right);
    }

    public boolean checkSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        else if (leftNode == null || rightNode == null) return false;
        else {
            return leftNode.val == rightNode.val
                    && checkSymmetric(leftNode.left, rightNode.right)
                    && checkSymmetric(leftNode.right, rightNode.left);
        }
    }
}
