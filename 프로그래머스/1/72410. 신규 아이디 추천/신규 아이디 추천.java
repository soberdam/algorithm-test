import java.util.*;
class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        //1단계
        new_id = new_id.toLowerCase();
        for(int i=0; i<new_id.length(); i++) {
            //2단계
            if(!((new_id.charAt(i)>='a'&&new_id.charAt(i)<='z')||new_id.charAt(i)=='-'||new_id.charAt(i)=='_'||new_id.charAt(i)=='.'||(new_id.charAt(i)>='0'&&new_id.charAt(i)<='9'))) continue;
            
            sb.append(new_id.charAt(i));
        }
        new_id = sb.toString();
        sb.setLength(0);
        //3단계
        for(int i=0; i<new_id.length(); i++) {
            if(new_id.charAt(i)=='.') {
                for(int j=i+1; j<new_id.length(); j++) {
                    if(new_id.charAt(j)!='.') {
                        i = j-1;
                        break;
                    }
                    i=j;
                }
                sb.append('.');
            } else {
                sb.append(new_id.charAt(i));
            }
        }
        //4단계
        new_id = sb.toString();
        sb.setLength(0);
        if(new_id.charAt(0)=='.') {
            sb.setLength(0);
            sb.append(new_id.substring(1,new_id.length()));
            new_id = sb.toString();
            sb.setLength(0);
        }
        
        if(new_id.length()!=0&&new_id.charAt(new_id.length()-1)=='.') {
            sb.setLength(0);
            sb.append(new_id.substring(0,new_id.length()-1));
            new_id = sb.toString();
            sb.setLength(0);
        }

        //5단계
        if(new_id.length()==0 || new_id.equals("")) {
            new_id = "a";
        }
        //6단계
        if(new_id.length()>=16) {
            sb.setLength(0);
            sb.append(new_id.substring(0,15));
            new_id = sb.toString();
            sb.setLength(0);
        }
        if(new_id.charAt(new_id.length()-1)=='.') {
            sb.setLength(0);
            sb.append(new_id.substring(0,new_id.length()-1));
            new_id = sb.toString();
            sb.setLength(0);
        }
        
        //7단계
        if(new_id.length()<=2) {
            sb.append(new_id);
            char newChar = new_id.charAt(new_id.length()-1);
            while(new_id.length()<3) {
                sb.append(newChar);
                new_id = sb.toString();
            }
        }   
        
        
        String answer = new_id;
        return answer;
    }
}