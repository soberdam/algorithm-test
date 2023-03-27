import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        ArrayList<Character> ch = new ArrayList<Character>();
        for(int i=0; i<s.length(); i++){
            ch.add(s.charAt(i));
        }
        Collections.sort(ch, Collections.reverseOrder());
        for(char c : ch){;
            answer+=c;
        }
        
        return answer;
    }
}