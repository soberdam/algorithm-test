class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String s = String.valueOf(x);
        int num = 0;
        for(int i=0; i<s.length(); i++){
            num += s.charAt(i) - '0';
        }
        if(x%num!=0 ) return false;
        return answer;
    }
}