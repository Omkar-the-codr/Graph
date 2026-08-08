package in.dp;

public class MaximumRepeatingSubstring1668 {
    public int maxRepeating(String sequence, String word) {
        int k = 0;
        for(int i=1;i<(sequence.length()/word.length())+1;i++){
            String wordKtimes = recur(i, word, new StringBuffer(word));
            if(!sequence.contains(wordKtimes)){
                return k;
            }
            k = i;
        }
        return k;
    }
    public String recur(int k, String word, StringBuffer newWord){
        return k==1?newWord.toString():recur(k-1, word, newWord.append(word));
    }
}
