class Solution {
    private static final int[] MONTH_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] WEEKDAYS = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    public String solution(int a, int b) {
        
        
        int firstWeekday = 5; // 1월 1일의 요일 인덱스
        
        //요일 인덱스를 해당 월의 최대 일수만큼 더한다.
        for(int i=1; i<a; i++){
            int maxDay = MONTH_DAYS[i-1];
            firstWeekday += maxDay;
        } 
       int weekday = firstWeekday + (b-1); // a월의 1일날짜에서 b-1일만큼 경과한 요일 인덱스
        
        String answer = WEEKDAYS[weekday%7]; // 요일 인덱스를 7로 나눈 나머지를 요일 배열에서 찾는다.
        
        return answer;
        
        
    }
}
