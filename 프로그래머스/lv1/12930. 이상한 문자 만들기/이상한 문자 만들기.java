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
            if(index%2 == 0) {
                answer+=Character.toUpperCase(s.charAt(i));
            } else {
                answer+=Character.toLowerCase(s.charAt(i));
            }
            index++;
            i++;

        }
        return answer;
    }
}