class Solution {
    public int solution(int n) {
        //lcm 최소공배수 구하기
        int gcd = getGcd(Math.max(6,n), Math.min(6,n));
        
        int answer = n/gcd;
        return answer;
    }
    
    public static int getGcd(int a, int b) {
        if(a%b==0) return b;
        
        return getGcd(b, a%b);
    }
}