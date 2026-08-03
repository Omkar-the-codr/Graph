package in.dp;

public class IsSubsequence392 {
    public boolean isSubsequence(String s, String t) {
        return dp(s, t, 0, 0);
    }
    public boolean dp(String s, String t, int i, int j){
        if(i>s.length()-1) return true;
        if(j>t.length()-1) return false;
        boolean ans = true;
        if(s.charAt(i)==t.charAt(j)) ans = dp(s, t, i+1, j+1);
        else ans = dp(s, t, i, j+1);
        return ans;
    }
}
