class Solution {
    public long solution(long n) {
        double x = Math.sqrt((double)n);
        if(x%1.0 == 0) {
            return (long)Math.pow(x+1.0, 2);
        } else {
            return -1;
        }
        
    }
}