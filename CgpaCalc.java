import java.util.Scanner;

public class CgpaCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("             Welcome to the CGPA Calculator                ");
        System.out.println("___________________________________________________________");
        System.out.println("please enter the number of subjects to be calculated");

        int subjects = sc.nextInt();
        float[] marks = new float[subjects];

        System.out.println("Enter marks obtained in each subject");

        for (int i = 0; i < subjects; i++) {
            for (;;) {
                System.out.println("Enter marks for subject " + (i + 1) + ":");
                float mark;
                while (!sc.hasNextFloat()) {
                    System.out.println("Invalid input! Please enter a valid number");
                    sc.next();
                }
                mark = sc.nextFloat();

                if (mark >= 0 && mark <= 100) {
                    marks[i] = mark;
                    break;
                } else {
                    System.out.println("Invalid input! Marks must be between 0 and 100");
                }
            }
        }

        float totalMarks = 0;
        for (float mark : marks) {
            totalMarks += mark;
        }

        double AvgPercentage= (totalMarks/subjects)*100/100;
        String grade;

        if(AvgPercentage>=90){
            grade= "A";
        }
        else if(AvgPercentage>=80){
            grade= "B";
        }
        else if(AvgPercentage>=70){
            grade= "C";
        }
        else if(AvgPercentage>=60){
            grade= "D";
        }
        else if(AvgPercentage>=50){
            grade= "E";
        }
        else{
            grade = "F";
        }
        String remarks;
        switch(grade){
            case "A" :
                remarks = "Exceptional work, exceeding expectations";
                break;
            case "B":
                remarks= "Above-average performance with notable strengths";
                break;
            case "C":
                remarks = "Good job, meeting the necessary criteria.";
                break;
            case "D":
                remarks = "Showing potential, but improvement is needed";
                break;
            case "E":
                remarks= "Subpar, significant deficiencies requiring attention.";
                break;
            default:
                remarks = "Unacceptable, urgent attention and improvement needed";
        }
        System.out.println("Total marks scored: " + totalMarks);
        System.out.println("your percentage is: " + AvgPercentage);
        System.out.println("your grade is: "+ grade);
        System.out.println("remarks: " + remarks);
        System.out.println("Thank you for using grade calculator");
    }
}
