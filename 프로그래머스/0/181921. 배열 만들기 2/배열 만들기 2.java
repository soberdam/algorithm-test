import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        Loop1: for(int i=l; i<=r; i++) {
            String str = String.valueOf(i);
            for(int j=0; j<str.length(); j++) {
                if(str.charAt(j)=='0' || str.charAt(j)=='5') {
                    continue;
                } else {
                    continue Loop1;
                }
            }
            list.add(i);
        }
        if(list.size()==0) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[list.size()];
            for(int i=0; i<list.size(); i++) {
                answer[i] = list.get(i);
            }
        }
        return answer;
    }
}