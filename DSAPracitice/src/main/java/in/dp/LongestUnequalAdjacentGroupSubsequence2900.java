package in.dp;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupSubsequence2900 {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int currentBit = groups[0];
        ans.add(words[0]);
        for(int i=0;i<groups.length;i++){
            if(groups[i]!=currentBit){
                ans.add(words[i]);
                currentBit = currentBit ^ 1;
            }
        }
        return ans;
    }
}
