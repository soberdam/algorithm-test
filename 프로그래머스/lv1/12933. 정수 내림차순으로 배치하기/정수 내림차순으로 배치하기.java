import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = String.valueOf(n);
        ArrayList<Character> numArr = new ArrayList<Character>();
        for(int i=0; i<s.length(); i++) {
            numArr.add(s.charAt(i));
        }
        Collections.sort(numArr, Collections.reverseOrder());
        String strAnswer = "";
        for(Character ch : numArr) {
            strAnswer += ch;
        }
        answer = Long.parseLong(strAnswer);
        return answer;
    }
}