import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer> testScore = new HashMap<>();
        
        testScore.put('R', 0);
        testScore.put('T', 0);
        testScore.put('C', 0);
        testScore.put('F', 0);
        testScore.put('J', 0);
        testScore.put('M', 0);
        testScore.put('A', 0);
        testScore.put('N', 0);
        
        for(int i=0; i<survey.length; i++) {
            char no = survey[i].charAt(0);
            char yes = survey[i].charAt(1);
            int score = choices[i];
            
            switch(score) {
                case 1:
                    testScore.put(no, testScore.get(no)+3);
                    break;
                case 2:
                    testScore.put(no, testScore.get(no)+2);
                    break;
                case 3:
                    testScore.put(no, testScore.get(no)+1);
                    break;
                case 4:
                    break;
                case 5:
                    testScore.put(yes, testScore.get(yes)+1);
                    break;
                case 6:
                    testScore.put(yes, testScore.get(yes)+2);
                    break;
                case 7:
                    testScore.put(yes, testScore.get(yes)+3);
                    break;
            }
        }
        
        if(testScore.get('R')>=testScore.get('T')) {
            answer+="R";
        } else {
            answer+="T";
        }
        
        if(testScore.get('C')>=testScore.get('F')) {
            answer+="C";
        } else {
            answer+="F";
        }
        
        if(testScore.get('J')>=testScore.get('M')) {
            answer+="J";
        } else {
            answer+="M";
        }
        
        if(testScore.get('A')>=testScore.get('N')) {
            answer+="A";
        } else {
            answer+="N";
        }
        
        return answer;
    }
}