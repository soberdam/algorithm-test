class Solution {
    public int solution(int[] array) {
        int[] cnt = new int [1000];
        
        for(int i=0; i<array.length; i++) {
            cnt[array[i]]++;
        }
        int answer = 0; // 최빈수
        int max = 0; // 최다 등장 빈도 수

        
        //cnt[i]는 등장빈도, i는 최빈수
        for(int i=0; i<cnt.length; i++) {
            if(cnt[i] > max) { //등장 빈도가 기존 등장빈도보다 많으면 
                answer=i; // 최빈수 갱신 
                max = cnt[i]; // 최다 등장빈도 갱신
            } else if(cnt[i]==max) { // 등장 빈도가 기존 최다 등장빈도와 같다면 
                answer = -1;
            }
        }
        

        return answer;
    }
}