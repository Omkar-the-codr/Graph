package in.dp;

public class LongestPalindromicSubstring5 {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int finalLow = 0;
        int finalHigh =0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                int low = i-1;
                int high = i;
                while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){
                    if(finalHigh-finalLow<high-low){
                        finalLow = low;
                        finalHigh = high;
                    }
                    low--;
                    high++;
                }
            }
            int low = i;
            int high = i;
            while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){
                if(finalHigh-finalLow<high-low){
                    finalLow = low;
                    finalHigh = high;
                }
                low--;
                high++;
            }
        }
        return s.substring(finalLow, finalHigh+1);
    }
}
