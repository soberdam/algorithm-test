class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        long multiply = 1L;
        long sum = 0L;
        for(int num : num_list) {
            multiply *= num;
            sum += num;
        }
        if(multiply<sum*sum) answer = 1;
        else answer = 0;
        return answer;
    }
}