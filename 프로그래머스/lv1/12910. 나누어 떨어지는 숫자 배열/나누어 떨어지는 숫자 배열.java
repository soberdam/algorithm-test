import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {-1};
        ArrayList<Integer> divided = new ArrayList<Integer>();
        for(int i=0; i<arr.length; i++){
           if(arr[i]%divisor == 0) {
               divided.add(arr[i]);
           }
        }
        if(divided.size()==0){
            return answer;
        } else {
            Collections.sort(divided);
            answer = new int[divided.size()];
            for(int i=0; i<divided.size(); i++) {
                answer[i] = divided.get(i);
            }
        }
        
        return answer;
    }
}