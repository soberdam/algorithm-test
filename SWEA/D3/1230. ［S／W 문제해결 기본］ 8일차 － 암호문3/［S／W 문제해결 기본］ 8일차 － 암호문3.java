import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = 10; // 테스트 케이스 수
        
        for(int test_case=1; test_case<=T; test_case++) {
        	// 암호문의 개수
        	int N = sc.nextInt(); 
            LinkedList<Integer> bundle = new LinkedList<>();
            
            // 원본 암호문 저장
            for(int i=0; i<N; i++) {
            	bundle.add(sc.nextInt()); 
            }
            
            // 명령어의 개수
            int M = sc.nextInt(); 
            
            // 명령어마다 수행
            for(int i=0; i<M; i++) {
            	String order = sc.next();
            	int x = 0;
            	int y = 0;
            	int s = 0;
            	switch(order) {
            	// 명령어가 I일 경우 앞에서부터 x번째 암호문 바로 다음에 y개의 암호문을 삽입한다. s는 덧붙일 암호문들이다.
            	case "I":
            		x = sc.nextInt();
            		y = sc.nextInt();
            		for(int j=0; j<y; j++) {
            			s = Integer.parseInt(sc.next());
            			bundle.add(x, s);
            			x++;
            		}
            		break;
            	// 명령어가 D일 경우 앞에서부터 x번째 암호문 바로 다음부터 y개의 암호문을 삭제한다.
            	case "D":
            		x = sc.nextInt();
            		y = sc.nextInt();
            		for(int j=0; j<y; j++) {
            			bundle.remove(x);
            		}
            		break;
            	// 명령어가 A일 경우 암호문 뭉치 맨 뒤에 y개의 암호문을 덧붙인다. s는 덧붙일 암호문들이다.
            	case "A":
            		y = sc.nextInt();
            		for(int j=0; j<y; j++) {
            			s = Integer.parseInt(sc.next());
            			bundle.add(s);
            		}
            		break;
            	}
            }
            
            
            System.out.printf("#%d ",test_case);
            for(int i=0; i<10; i++) {
            	System.out.print(bundle.get(i) +" ");
            }
            System.out.println();
                
        }
    }
}