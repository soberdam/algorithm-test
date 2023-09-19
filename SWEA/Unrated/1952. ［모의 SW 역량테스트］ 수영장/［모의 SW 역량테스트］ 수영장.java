import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
 
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for(int tc=1; tc<=T; tc++) {
            int answer = 0;
            int[] plan = new int[13];
            int[] d = new int[13];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int season = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
             
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }
            d[0] = 0;
            for(int i=1; i<=2; i++) {
                d[i] = Math.min(d[i-1]+day*plan[i], d[i-1]+month);
                d[i] = Math.min(d[i], season);
                d[i] = Math.min(d[i], year);
            }
            for(int i=3; i<=12; i++) {
                d[i] = Math.min(d[i-1]+day*plan[i], d[i-1]+month);
                d[i] = Math.min(d[i], d[i-3]+season);
                d[i] = Math.min(d[i], year);
            }
            System.out.printf("#%d %d\n", tc, d[12]);
        }
    }
     
     
 
}