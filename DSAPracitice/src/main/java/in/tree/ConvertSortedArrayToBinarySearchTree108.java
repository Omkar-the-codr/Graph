package in.tree;

public class ConvertSortedArrayToBinarySearchTree108 {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(0, nums.length-1, nums);
    }
    public TreeNode createTree(int low, int high, int[] nums){
        if(low>high) return null;
        int mid = low+(high-low)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = createTree(low, mid- 1, nums);
        node.right = createTree(mid+1, high, nums);
        return node;
    }
}
