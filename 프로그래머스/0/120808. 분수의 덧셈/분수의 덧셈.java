class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        // 분모 = 분모1 *분모2, 분자 = 분자1*분모2 + 분자2*분모1로
        // 분모와 분자를 만든 후 분모와 분자의 최대공약수(gcd)로 나누어 기약분수화한다. 
        
        
        int denom = denom1*denom2;
        int numer = numer1*denom2 + numer2*denom1;
        int gcd = getGCD(Math.max(numer,denom), Math.min(numer,denom));
        answer[0] = numer/gcd;
        answer[1] = denom/gcd;
        
        
        
        
        return answer;
    }
    
    public static int getGCD(int a, int b) {
        if(a%b==0) {
            return b;
        }
        return getGCD(b, a%b);
    }
}