import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        
        List<Integer> stkList = new ArrayList<>();
        int i = 0;
        while(i<arr.length) {
            if(stkList.size()==0) {
                stkList.add(arr[i++]);
            } else if (stkList.get(stkList.size()-1)<arr[i]) {
                stkList.add(arr[i++]);
            } else {
                stkList.remove(stkList.size()-1);
            }
        }
        int[] stk = new int[stkList.size()];
        for(int j=0; j<stkList.size(); j++) {
            stk[j] = stkList.get(j);
        }
        return stk;
    }
}