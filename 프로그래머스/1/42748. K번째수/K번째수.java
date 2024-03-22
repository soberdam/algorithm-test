import java.util.*;


class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
        
        int index = 0;
        for(int l=0; l<commands.length; l++) {
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];
            
            int[] temp = new int[j-i+1];
            int idx = 0;
            for(int m = i-1; m<=j-1; m++) {
                temp[idx++] = array[m];
            }
            Arrays.sort(temp);
            answer[index++] = temp[k-1];
        }
        return answer;
    }
}