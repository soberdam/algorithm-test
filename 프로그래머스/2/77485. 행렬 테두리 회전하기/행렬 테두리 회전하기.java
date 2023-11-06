class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows][columns];
        
        int cnt=1;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                arr[i][j] = cnt++;
            }
        }
        
        int[] answer = new int [queries.length];
        
        for(int i=0; i<queries.length; i++) {
            int x1 = queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            
            
            int temp = arr[x1][y1];
            int min = temp;
            for(int j=x1; j<x2; j++) {
                arr[j][y1] = arr[j+1][y1];
                min = Math.min(arr[j][y1], min);
            }
            
            for(int j=y1; j<y2; j++) {
                arr[x2][j] = arr[x2][j+1];
                min = Math.min(arr[x2][j], min);
            }
            
            for(int j=x2; j>x1; j--) {
                arr[j][y2] = arr[j-1][y2];
                min = Math.min(arr[j][y2], min);
            }
            
            for(int j=y2; j>y1+1; j--) {
                arr[x1][j] = arr[x1][j-1];
                min = Math.min(arr[x1][j], min);
            }
            
            arr[x1][y1+1] = temp;
            answer[i] = min;
            
        }
        
        return answer;
    }
}