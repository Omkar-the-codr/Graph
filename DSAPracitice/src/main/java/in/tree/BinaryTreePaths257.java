package in.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {
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
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        paths(root, sb);
        return ans;
    }
    public void paths(TreeNode root, StringBuilder sb){
        if(root==null) return;
        int length = sb.length();
        sb.append(root.val);
        if(root.left==null && root.right==null) ans.add(sb.toString());
        else{
            sb.append("->");
            paths(root.left, sb);
            paths(root.right, sb);
        }
        sb.setLength(length);
    }
}
