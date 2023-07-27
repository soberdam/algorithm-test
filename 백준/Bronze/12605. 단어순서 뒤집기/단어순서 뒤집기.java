import java.util.Scanner;

public class Main {

public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    
    
    
    sc.nextLine();
    
    String [] sentences = new String[N];
    int size = sentences.length;
    
    
    for(int i=0; i<size; i++) {
        sentences[i] = sc.nextLine(); // 문장 한줄씩 담기
    }
    
    
    String[] reversedSentences = new String[N]; // 거꾸로 뒤집은 문장을 배열 생성, N개의 문장에 대해서
    
 
    for(int i=0; i<size; i++) {
    	String[] words = sentences[i].split(" ");     // i번째 문장을 단어별로 배열에 나누어 담기
    	String reverseSentence = ""; // 단어를 뒤에서부터 모아서 저장할 곳, i번째 문장마다 초기화
    	for(int j=words.length-1; j>=0; j--) {  // 거꾸로 만들기 위에 단어를 뒤에서부터 줄세우자!
    		 reverseSentence += words[j]; // i번째 단어를  추가하고
    		 if(j==0) {
    			 break; // 마지막 단어면 스페이스 추가 X
    		 }
    		 reverseSentence += " "; // 스페이스 추가
    	}
    	reversedSentences[i] = reverseSentence; // 거꾸로 더해서 만든 i번째 문장을 배열에 하나씩 추가
    }
    
    
    for(int i=0; i<size; i++) {
        System.out.println("Case #"+(i+1)+": " + reversedSentences[i]);
    }
        
        
      
       
        
        
    }

}
