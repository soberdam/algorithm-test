import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int wordCount = scanner.nextInt();
        boolean isGroupWord;
        int groupWordCount = 0;
        char ch;
        String str;
        for(int i=0; i<wordCount; i++){
            str = scanner.next();
            isGroupWord = true;
            ch = '0';
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j)!=ch){
                    String cutStr = str.substring(j);
                    if(cutStr.contains(String.valueOf(ch))){
                        isGroupWord = false;
                        break;
                    }
                }
                ch = str.charAt(j);
            }
            if(isGroupWord == true){
                groupWordCount++;
            }           
        }
        
        System.out.print(groupWordCount);
    }
}