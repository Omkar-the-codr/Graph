package in.tree;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree501 {
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
        List<Integer> ans = new ArrayList<>();
        public int[] findMode(TreeNode root) {
            inorder(root);
            if(ans.size()<=1) return ans.stream().mapToInt(Integer::intValue).toArray();
            List<Integer> answer = new ArrayList<>();
            int count = 1;
            int maxCount = 0;
            for(int i=0;i<ans.size()-1;i++){
                if((ans.get(i)).equals(ans.get(i+1))){
                    count++;
                }else{
                    if(count==maxCount){
                        answer.add(ans.get(i));
                    }else if(count>maxCount){
                        answer.clear();
                        answer.add(ans.get(i));
                        maxCount = count;
                    }
                    count = 1;
                }
            }
            if(count == maxCount){
                answer.add(ans.get(ans.size() - 1));
            }else if(count > maxCount){
                answer.clear();
                answer.add(ans.get(ans.size() - 1));
            }
            return answer.stream().mapToInt(Integer::intValue).toArray();

        }
        public void inorder(TreeNode root){
            if(root==null) return;
            inorder(root.left);
            ans.add(root.val);
            inorder(root.right);
        }
    }
}
