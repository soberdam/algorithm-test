import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int purchaseNum = sc.nextInt();
        int price = 0;
        int itemNum = 0;
        int total = 0;
        
        for (int i=1; i<=purchaseNum; i++) {
            price = sc.nextInt();
            itemNum = sc.nextInt();
            total += (price*itemNum);
        }
        if (total == sum) {
            System.out.print("Yes");
            
        } else {
            System.out.print("No");
        }
    }
}