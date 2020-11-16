import java.util.HashMap;
import java.util.Scanner;
import java.io.PrintWriter;

public class GradeReport {
    private int studentId;
    private int practiceCounter;
    private int labCounter;
    private int midTermCounter;
    private int finalCounter;
    private HashMap<String, Double> grades;

    public GradeReport(int id) {
        this.studentId = id;
        grades = new HashMap<String, Double>();
        practiceCounter = 0;
        labCounter = 0;
        midTermCounter = 0;
        finalCounter = 0;
    }

    //explains input formatting
    public void formatting() throws InterruptedException{
        System.out.println("Input Formatting:");
        System.out.println("Grades should be entered in order of assignment number. \nExample  L1 L2 L3 L4 etc.");
        System.out.println("Once you have entered all available grades for the assignment category, enter a -1 to move to the next category");
    }

    //takes input and calculates sum of practice problem grades
    public void addPracticeProblems(Scanner scan) {
        double practiceGrades = 0;
        double grade;
        System.out.println("Please enter up to 8 practice problem grades. To mark the end of the list, enter a -1");
        while (scan.hasNext()) {
            grade = scan.nextDouble();
            if (grade < 0) {
                break;
            }
            practiceGrades += grade;
            practiceCounter += 1;
        }
        grades.put("practice problems", practiceGrades);
    }

    //takes input and calculates sum of practice problem grades
    public void addlabs(Scanner scan) {
        double labGrades = 0;
        double grade;
        System.out.println("Please enter up to 7 lab grades. To mark the end of the list, enter a -1");
        while (scan.hasNext()) {
            grade = scan.nextDouble();
            if (grade < 0) {
                break;
            }
            labGrades += grade;
            labCounter += 1;
        }
        grades.put("labs", labGrades);
    }

    //takes input and calculates sum of midterm grades
    public void addMidterms(Scanner scan) {
        double midTermGrades = 0;
        double grade;
        System.out.println("Please enter up to 2 midterm grades. To mark the end of the list, enter a -1");
        while (scan.hasNext()) {
            grade = scan.nextDouble();
            if (grade < 0) {
                break;
            }
            midTermGrades += grade;
            midTermCounter += 1;
        }
        grades.put("midterms", midTermGrades);
    }

    //takes grade for final exam
    public void addFinal(Scanner scan) {
        double finalExamGrade = 0;
        double grade;
        System.out.println("Please enter the final exam grade. To end the list, or if no grade is available, enter a -1");
        while (scan.hasNext()) {
            grade = scan.nextDouble();
            if (grade < 0) {
                break;
            }
            finalExamGrade += grade;
            finalCounter++;
        }
        grades.put("final exam", finalExamGrade);
    }

    public void writeGradeReport(PrintWriter report) {
        try { 
            double currentGrade = grades.get("practice problems") + grades.get("labs") + grades.get("midterms") + grades.get("final exam");
            report.println("Grade report for: " + studentId);
            report.print("Practice problem grades: " + grades.get("practice problems") + " out of 44\t\t");
            //uses if else since 7 practice problem assignments have a max grade of 6, but one has a grade of 2
            //without if else you cannot calculate points remaining accurately if one student has no available grades and another did some
            if (practiceCounter != 0) {
                report.println("Possible Points Remaining: " + ((practiceCounter < 8) ? (8 - practiceCounter) * 6  : 0));
            }
            else {
                report.println("Possible Points Remaining: 44" );
            }
            //multiplies remaining count by weight of assignments, for labs each assignment is worth 2 points
            report.println("Lab grades: " + grades.get("labs") + " out of 16\t\t" +
                        "Possible Points Remaining: " + ((labCounter < 7) ? (8 - labCounter) * 2 : 0));
            report.println("midterm grades: " + grades.get("midterms") + " out of 20\t\t" + 
                        "Possible Points Remaining: " + ((midTermCounter < 2) ? (2 - midTermCounter) * 10 : 0));
            report.println("final exam grade: " + grades.get("final exam") + " out of 20\t\t" +
                        "Possible Points Remaining: " + ((finalCounter < 1) ? 20 : 0));
            report.print("Current Grade: " + currentGrade);
            //converts to letter grade based on grade scale provided
            if (currentGrade >= 90) {
                report.println("\t\tGrade as Letter: A");
            }
            else if (currentGrade >= 80) {
                report.println("\t\tGrade as Letter: B");
            }
            else if (currentGrade >= 70) {
                report.println("\t\tGrade as Letter: C");
            }
            else if (currentGrade >= 60) {
                report.println("\t\tGrade as Letter: D");
            }
            else {
                report.println("\t\tGrade as Letter: F");
            }
            //calculates points needed to get indicated letter grade. Not based on possible points remaining
            report.println("Points needed for an A: " + ((currentGrade < 90) ? 90 - currentGrade: "Grade is met"));
            report.println("Points needed for an B: " + ((currentGrade < 80) ? 80 - currentGrade: "Grade is met"));
            report.println("Points needed for an C: " + ((currentGrade < 70) ? 70 - currentGrade: "Grade is met"));
            report.println("Points needed for an D: " + ((currentGrade < 60) ? 60 - currentGrade: "Grade is met"));
            report.print("\n");
        }
        catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

}
