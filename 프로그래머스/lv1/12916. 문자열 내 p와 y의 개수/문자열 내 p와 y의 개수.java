class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int countP = 0;
        int countY = 0;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='p'||s.charAt(i)=='P') {
                countP++;
            }
            else if(s.charAt(i)=='y'||s.charAt(i)=='Y') {
                countY++;
            }
        }
        if(countP!=countY) {
            answer = false;
        }
        return answer;
    }
}