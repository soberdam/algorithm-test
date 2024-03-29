import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        //각 테스트케이스 진행
        for(int i=0;i<t;i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            //전화번호 저장
            for (int j = 0; j < n; j++)
                arr[j] = br.readLine();

            Arrays.sort(arr);		//오름차순 정렬
            bw.write(search(arr) + "\n");	//일관성 결과 BufferedWriter 저장
        }
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //전화번호들 일관성 확인하는 함수
    static String search(String[] arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1].startsWith(arr[i]))	//접두사로 사용될 경우
                return "NO";		//일관성 X, NO반환
        }
        return "YES";	//접두사 사용 X, 일관성 O, YES반환
    }
}