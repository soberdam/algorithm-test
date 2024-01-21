import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        //선물을 다른 모든 친구들과 주고받은 증감, 선물 지수
        int[] giftCount = new int[friends.length];
        //서로 선물을 주고받은 수를 저장할 그래프
        int[][] graph = new int[friends.length][friends.length];
        
        
        HashMap<String, Integer> map = new HashMap<>();
        
        //친구 이름을 맵에 인덱스로 저장
        for(int i=0; i<friends.length; i++) {
            map.put(friends[i], i);
        }
        
        // 선물을 주는 사람에게 개수 ++, 받은 사람은 개수 --
        for(String gift : gifts) {
            StringTokenizer st = new StringTokenizer(gift);
            int from = map.get(st.nextToken());
            int to = map.get(st.nextToken());
            
            giftCount[from]++;
            giftCount[to]--;
            graph[from][to]++;
        }
        
        for(int i=0; i<graph.length; i++){
            int max = 0;
            
            for(int j=0; j<graph[0].length; j++) {
                if(i==j)
                    continue;
                
                if(graph[i][j] > graph[j][i]||(graph[i][j]==graph[j][i]&&giftCount[i]>giftCount[j])) 
                    max++;
            } 
            if(max>answer) answer=max;
        }
        
        return answer;
    }
}