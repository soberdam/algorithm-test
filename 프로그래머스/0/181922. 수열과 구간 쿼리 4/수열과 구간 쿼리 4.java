class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr;
        for(int i=0; i<queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];
            
            for(int j=s; j<=e; j++) {
                if(j%k==0) {
                    answer[j]+=1;
                }
            }
        }
        return answer;
    }
}