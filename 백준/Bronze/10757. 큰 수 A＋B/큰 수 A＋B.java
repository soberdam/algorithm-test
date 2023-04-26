import java.util.*;
import java.math.BigInteger;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = new BigInteger(sc.next());
        BigInteger b = new BigInteger(sc.next());
        a = a.add(b);
        System.out.print(a.toString());
    }
}