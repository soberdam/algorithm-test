class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        answer = Math.max(Integer.parseInt(""+a+b), 2*a*b);
        return answer;
    }
}