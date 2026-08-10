package in.dp;

public class SumOfCompatibleNumbersInRangeI3954 {
    public int sumOfGoodIntegers(int n, int k) {
        int sum =0;
        int diff=0;
        if(n>k) diff = n-k;
        for(int i=diff;i<n+k+1;i++){
            if((n&i)==0) sum+=i;
        }
        return sum;
    }
}
