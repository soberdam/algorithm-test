import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int L = sc.nextInt();
        int [] cake = new int [L]; 
        int N = sc.nextInt();
        for(int i = 0 ; i<L ; i++) {
            cake[i] = 1;
        }
        int[]people = new int [N];
        //사람이 원하는 케이크의양
        int[]realcake = new int [N];
        //실제로 가져간 케이크의양
        
        int bigpp = 0;
        //최대로가져가려한 친구
        int maxcake = 0;
        //최대로가져간 친구
        
        for(int i = 0 ; i<N ; i++) {
            int p = sc.nextInt();
            int k = sc.nextInt();
            people[i] = k-p+1;
            for(int h = p-1; h<k; h++) {
                realcake[i] += cake[h];
                cake[h]=0;
            }
        
        }
        
        //최대값인덱스구하기
        int max = 0;
        for(int i = 0; i<N ; i++) {
            max = Math.max(max, people[i]);
        }    
        
        for(int i = 0; i<N; i++) {
        	if(people[i]== max) {
        		bigpp=i;
        		break;
        	}
        }
        
        //최대값인덱스구하기
        max = 0;
        for(int i = 0; i<N ; i++) {
            max = Math.max(max, realcake[i]);
        }    
        
        for(int i = 0; i<N; i++) {
        	if(realcake[i]== max) {
        		maxcake=i;
        		break;
        	}
        }
        System.out.println((bigpp+1));
        System.out.println((maxcake+1));
    }
}