package in.tree;

public class SameTree100{
      class TreeNode {
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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p==null && q==null) return true;
            else if(p==null || q==null) return false;
            return p.val==q.val?(isSameTree(p.left, q.left) && isSameTree(p.right, q.right)):false;
        }
}
