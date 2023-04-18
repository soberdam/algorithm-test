class Solution {
    public double solution(int[] arr) {
        int sum = 0;
        double avg = 0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
        }
        avg = sum/(double)arr.length;
        
        return avg;
    }
}