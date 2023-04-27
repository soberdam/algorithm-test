import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        
        if (arr.length == 1) { return new int[] {-1}; }
        else {
            int[] answer = new int [arr.length-1];
            int min = arr[0];
            int cnt = 0;
            for(int i=1; i<arr.length; i++){
                if(arr[i]<min) min = arr[i];
            }
            for(int i : arr) {
                if(i != min) {
                    answer[cnt++] = i;
                }
            }
            return answer;
        }
        
    }
}