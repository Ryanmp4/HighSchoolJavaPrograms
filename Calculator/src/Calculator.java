import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] values = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "F"};
        Double[] grades = new Double[11];
        double[] points = {4.33, 4.00, 3.67, 3.33, 3.00, 2.67, 2.33, 2.00, 1.67, 1.00, 0};
        double classNum = 0;
        double result = 0;
        System.out.println("Xavier GPA Calculator");
        for (int a = 0; a < values.length; a++) {
            System.out.println("How many " + values[a] + "'s do you have?");
            grades[a] = sc.nextDouble();
        }
        System.out.println("Calculating:");
        for (int b = 0; b < grades.length; b++) {
            classNum = classNum + grades[b];
            grades[b] = grades[b] * points[b];
            result = result + grades[b];
        }
        result = result / classNum;
        System.out.println("Your GPA is: " + String.format("%.2f", result));
    }
}