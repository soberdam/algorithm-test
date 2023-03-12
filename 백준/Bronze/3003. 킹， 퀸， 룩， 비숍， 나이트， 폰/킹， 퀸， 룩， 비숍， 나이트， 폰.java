import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<6; i++){
            int piece = scanner.nextInt();
                switch(i) {
                    case 0: case 1: System.out.print((1-piece) + " ");
                            break;
                    case 2: case 3: case 4: System.out.print((2-piece) + " ");
                            break;
                    case 5: System.out.print((8-piece) + " ");
                            break;
                }
                    
        }
    }
}