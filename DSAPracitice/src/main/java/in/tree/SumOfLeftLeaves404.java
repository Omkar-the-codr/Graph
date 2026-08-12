package in.tree;

public class SumOfLeftLeaves404 {
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
    public int sumOfLeftLeaves(TreeNode root) {
        return findSum(root, false);
    }
    public int findSum(TreeNode root, boolean isLeft){
        if(root==null) return 0;
        int sum =0;
        if(isLeft && root!=null){
            if(root.left==null && root.right==null) sum+=root.val;
        }
        return sum+findSum(root.left, true) + findSum(root.right, false);
    }
}
