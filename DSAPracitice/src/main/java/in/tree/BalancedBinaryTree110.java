package in.tree;

public class BalancedBinaryTree110 {
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
    private boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        checkHeight(root);
        return ans;
    }
    public int checkHeight(TreeNode root){
        if(root==null) return 0;
        int left = 0;
        int right = 0;
        if(root.left!=null) left = 1+ checkHeight(root.left);
        if(root.right!=null) right = 1+checkHeight(root.right);
        if(Math.abs(left-right)>1) ans = false;
        return Math.max(left, right);
    }
}
