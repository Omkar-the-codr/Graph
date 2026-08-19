package in.tree;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST530 {
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

    List<Integer> ans = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<ans.size()-1;i++){
            min = Math.min(min, ans.get(i+1)-ans.get(i));
        }
        return min;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }
}
