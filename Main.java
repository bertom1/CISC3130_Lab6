import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Please enter a student id. To exit, enter -1");
        Scanner scan = new Scanner(System.in);
        int studentId = scan.nextInt();
        PrintWriter output = new PrintWriter(new File("gradeReport.txt"));
        while (studentId >= 0) {
            try{
                GradeReport report = new GradeReport(studentId);
                report.formatting();
                report.addPracticeProblems(scan);
                report.addlabs(scan);
                report.addMidterms(scan);
                report.addFinal(scan);
                report.writeGradeReport(output);
                System.out.println("Please enter a student id. To exit, enter -1");
                studentId = scan.nextInt();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scan.close();
        output.close();
        System.out.println("Grade reports have been created");
    }
}