class Solution {
    public String solution(String s) {
        String answer = "";
        int i=0;
        int index = 0;
        while(i<s.length()) {
            if(s.charAt(i) == ' ') {
                answer+=s.charAt(i);
                index = 0;
                i++;
                continue;
            }
            answer += index%2 == 0 ? 
                Character.toUpperCase(s.charAt(i)) :
                Character.toLowerCase(s.charAt(i));
            index++;
            i++;

        }
        return answer;
    }
}