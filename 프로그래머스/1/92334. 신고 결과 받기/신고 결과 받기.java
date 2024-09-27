import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        HashMap<String, Integer> mailCnt = new HashMap<>();
        for(int i=0; i<id_list.length; i++) {
            String id = id_list[i];
            reportMap.put(id, new HashSet<String>());
            mailCnt.put(id, 0);
        }
        
        StringTokenizer st;
        
        for(int i=0; i<report.length; i++) {
            st = new StringTokenizer(report[i]);
            
            String reporter = st.nextToken();
            String reported = st.nextToken();
            
            reportMap.get(reported).add(reporter);
        }
        
        for(String reported : reportMap.keySet()) {
            if(reportMap.get(reported).size()>=k) {
                Iterator<String> iter = reportMap.get(reported).iterator();	
                while(iter.hasNext()) {
                    String reporter = iter.next();
                    mailCnt.replace(reporter, mailCnt.get(reporter)+1);
                }
            }
        }
        
        for(int i=0; i<id_list.length; i++) {
            String id = id_list[i];
            answer[i] = mailCnt.get(id);
        }
        return answer;
    }
}