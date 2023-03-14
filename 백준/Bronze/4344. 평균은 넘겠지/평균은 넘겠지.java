import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        int studentCount;
        int total;
        int overAvgStudent;
        double avg;
        double overAvgPercent;
        for(int i=0; i<testCase; i++){
            total = 0;
            avg = 0.0;
            overAvgStudent = 0;
            overAvgPercent = 0.0;
            studentCount = scanner.nextInt();
            int[] scoreArr = new int[studentCount];
            for(int j=0; j<studentCount; j++){
                scoreArr[j]= scanner.nextInt();
                total += scoreArr[j];
            }
            avg = total/studentCount;
            for(int j=0; j<studentCount; j++){
                if(scoreArr[j] > avg) {
                    overAvgStudent++;
                }
            }
            overAvgPercent = overAvgStudent/(double)studentCount*100;
            System.out.println(String.format("%.3f", overAvgPercent) + "%");
            
        }
    }
}