class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String oddsum = "";
        String evensum = "";
        for(int num : num_list ){
             if(num%2==0) {
                 evensum+=num;
             } else {
                 oddsum+=num;
             }
        }
        answer = Integer.parseInt(oddsum) + Integer.parseInt(evensum);
        return answer;
    }
}