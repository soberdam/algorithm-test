import java.util.*;
class Solution {
    private static final int MONTH_DAYS = 28;
    private static final int MONTHS = 12;
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();
        
        for(int i=0; i<terms.length; i++) {
            String[] term = terms[i].split(" ");
            termsMap.put(term[0], Integer.valueOf(term[1]) * MONTH_DAYS);
        }
        String[] todayStr = today.split("\\.");
        int todayYear = Integer.parseInt(todayStr[0]);
        int todayMonth = Integer.parseInt(todayStr[1]);
        int todayDay = Integer.parseInt(todayStr[2]);
        
        for(int i=0; i<privacies.length; i++) {
            String date = privacies[i].split(" ")[0];
            String [] str = date.split("\\.");
            int year = (todayYear - Integer.parseInt(str[0])) * MONTHS * MONTH_DAYS;
            int month = (todayMonth - Integer.parseInt(str[1])) * MONTH_DAYS;
            int day = (todayDay - Integer.parseInt(str[2]));
            
            int type = termsMap.get(privacies[i].split(" ")[1]);
            
            if(type <= year + month + day) {
                answer.add(i+1);
            }
        }
        
        return answer.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
    }
}