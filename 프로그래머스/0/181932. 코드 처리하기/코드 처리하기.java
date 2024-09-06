import java.util.*;
import java.io.*;

class Solution {
    public String solution(String code) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean mode = false;
        for(int i=0; i<code.length(); i++) {
            if(code.charAt(i)=='1') {
              mode = !mode;
            } else {
                if(!mode) {
                    if(i%2==0) {
                        sb.append(code.charAt(i));
                    }
                } else {
                    if(i%2==1) {
                        sb.append(code.charAt(i));
                    }
                }
            } 
            
        }
        
        answer = sb.toString();
        if(sb.length()==0) answer = "EMPTY";
        return answer;
    }
}