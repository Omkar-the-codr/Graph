package in.tree;

public class InvertBinaryTree226 {
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        invertRoot(root);
        return root;
    }
    public void invertRoot(TreeNode root){
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        else if(root.left==null && root.right!=null){
            root.left = root.right;
            root.right = null;
        }
        else if(root.left!=null && root.right==null){
            root.right = root.left;
            root.left = null;
        }
        else{
            TreeNode newNode = root.left;
            root.left = root.right;
            root.right = newNode;
        }
        invertRoot(root.left);
        invertRoot(root.right);

    }
}
