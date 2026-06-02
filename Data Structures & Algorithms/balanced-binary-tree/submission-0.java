/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        // Nếu return -1 nghĩa là cây mất cân bằng
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        // 1. Tính chiều cao nhánh trái
        int leftHeight = checkHeight(root.left);
        if(leftHeight == -1) return -1;

        // 2. Tính chiều cao nhánh phải
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) return -1;

        // 3. Kiểm tra độ chênh lệch chiều cao tại nút hiện tại
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Mất cân bằng tại nút này, trả về -1
        }

        // 4. Nếu cân bằng, trả về chiều cao thực tế của nút này (Logic +1 kinh điển)
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
