# CISC3130_Lab6
Java program written to calculate student grades based on class syllabus. Main.java contains the code needed to run the program, GradeReport.java contains
the source code for the object used to store the grades. A sample output is included titled "gradeReport.txt" and includes four students  
Student 1: My grades as reported in the class spreadsheet. Student ID is 8757 (last 4 digits of my EMPLID.)  
Student 2: Test case where a student did not complete any assignments, 0 is entered for each assignment. Student ID is 0.  
Student 3: Test case where no grades are available (e.g start of the semester.) No grade is entered for all categories. Student ID is 1.  
Student 4: Test case where a student gets full points for all assignments. Student ID is 1234.
## Implementation
For this program, user input is taken from the command line. The user is first prompted to enter a student ID, and is then prompted to enter the assignment grades
for each assignment category. The four categories used are Practice Problems, Labs, Midterms, and a Final exam. The sum of the grades for each category is stored in a 
HashMap with the assignment category as the key and the grade as a double for the element. The sum is stored as an array since midterm 1 had the possibility for half points, so
a double was used for all grades. I also chose to store the sum of each category instead of each individual assignment grade to simplify the grade calculations. If the grades were
stored with the same key but with an array, stack, or queue as the element we would have to find the sum anytime we retrieve the element from the map. To indicate that all grades for 
a category were entered a -1 should be entered after the last grade. This resolved some bugs I faced when trying to limit the input by number of assignments in each category. Doing
this would not give the prompt for the next category if the max number of assignment grades were entered for the current category. The output file is split by student and shows the
grade sum for each category, as well as the total grade out of 100 and the corresponding letter grade. It also includes the remaining possible points for the category, as well as
the points needed to receive an A, B, C, and a D.  
I initially did not plan to code a GUI for this program, but using the -1 as a key to move to the next category helped me visualize how a GUI would take in input from the user. I
did not include any code for a GUI since I did not feel comfortable enough using Swing or JavaFX to write a functional GUI in the few days I had, but I do see this as a good opportunity to practice 
and familiarize myself with Swing or JavaFX as a side project.
### Dependencies
* Written using Java 14
* Terminal to run commands for setup, may differ by OS used.
#### Set up
To run this program, you need to have a github account setup with an SSH key. Access to a terminal and git commands
are needed, unless your IDE of choice has git support. If you choose to run the program with this IDE,
the setup process will differ.  
1. Clone to your machine using `git clone git@github.com:bertom1/CISC3130_Lab6.git` 
2. Open the project directory with the command `cd CISC3130_Lab6`.
3. To compile the program, use the command `javac Main.java`
4. To run the program, use the command `java Main`
