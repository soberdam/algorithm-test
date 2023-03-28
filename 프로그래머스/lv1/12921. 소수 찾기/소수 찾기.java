class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean [] bool = new boolean[n+1]; // false는 소수, true는 소수가 아닌 수
        
        for(int i=2; i<=n; i++){
            if(bool[i] == false){ //i번째가 소수라면 확인
                 for(int j=2; i*j<=n; j++) { // i의 배수들을 제거
                     bool[i*j] = true; // i의 배수들은 true
                 }
            }
           
        }
        for(int i=2; i<=n; i++){
            if(bool[i]==false){
                answer++;
            }
        }
        return answer;
    }
}