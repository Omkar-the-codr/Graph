package in.Graph;

 class FindTheTownJudge997 {
        public int findJudge(int n, int[][] trust) {
            int[] trustsOthers = new int[n+1];
            int[] trustedByOthers = new int[n+1];
            for(int[] ele: trust){
                trustsOthers[ele[0]]++;
                trustedByOthers[ele[1]]++;
            }
            for(int i=1;i<n+1;i++){
                if(trustsOthers[i]==0 && trustedByOthers[i]==n-1) return i;
            }
            return -1;

        }
    }
