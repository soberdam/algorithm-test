class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        if(s.length() == 4 || s.length() == 6) {
            answer = true;
            for(int i=0; i<s.length(); i++) {
                if (Character.isLetter(s.charAt(i))) {
                    answer = false;
                }
            }
        }
        
        return answer;
    }
}
                    