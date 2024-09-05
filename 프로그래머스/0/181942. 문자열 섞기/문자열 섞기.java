class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<str1.length()+str2.length(); i++) {
            if(i%2==0)
                sb.append(str1.charAt(i/2));
            else
                sb.append(str2.charAt(i/2));
        }
        answer = sb.toString();
        return answer;
    }
}