import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line;
        String[] lineArr;
        double score;
        String grade;
        double gradeScore = 0.0;
        double totalScore = 0.0;
        double totalSubjectScore = 0.0;
        double majorScore;
        for(int i=0; i<20; i++){
            line = scanner.nextLine();
            lineArr = line.split(" ");
            score = Double.parseDouble(lineArr[1]);
            grade = lineArr[2];
            if (grade.equals("P")){
                continue;
            }
            switch(grade) {
                case "A+": gradeScore = 4.5;
                           break;
                case "A0": gradeScore = 4.0;
                           break;
                case "B+": gradeScore = 3.5;
                           break;
                case "B0": gradeScore = 3.0;
                           break;
                case "C+": gradeScore = 2.5;
                           break;
                case "C0": gradeScore = 2.0;
                           break;
                case "D+": gradeScore = 1.5;
                           break;
                case "D0": gradeScore = 1.0;
                           break;
                case "F": gradeScore = 0.0;
                           break;
            }
            
            totalScore += score;
            totalSubjectScore += (score * gradeScore);
        }
        
        majorScore = totalSubjectScore/totalScore;
        System.out.print(majorScore);
    }
}