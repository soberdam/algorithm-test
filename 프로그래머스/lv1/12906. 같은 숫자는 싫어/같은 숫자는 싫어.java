import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        ArrayList<Integer> intQueue = new ArrayList<Integer>();
        intQueue.add(arr[0]);
        for(int i=1; i<arr.length; i++) {
            if(arr[i]!=intQueue.get(intQueue.size()-1)) {
                intQueue.add(arr[i]);
            }
        }
        
        int[] answer = new int[intQueue.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = intQueue.get(i);
        }
        

        return answer;
    }
}