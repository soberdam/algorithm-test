import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        ArrayList<Character> charArr = new ArrayList<Character>();
        ArrayList<String> strArr = new ArrayList<String>();
        
        for(String s : strings) {
            strArr.add(s);
        }
        Collections.sort(strArr);
        
        for(int i = 0; i< strings.length; i++){
            charArr.add(strings[i].charAt(n));
        }
        Collections.sort(charArr);
        
        for(int i = 0; i < strArr.size(); i++){
            for(int j = 0; j < charArr.size(); j++) {
               if(charArr.get(j) == strArr.get(i).charAt(n)) {
                   if(answer[j]==null){
                     answer[j] = strArr.get(i);
                     break;
                   }
                   
               }
            }
        }
        
        return answer;
    }
}