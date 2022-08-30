import java.util.Scanner;

public class QbRankings {

    public static void main(String[] args) {

        //initialize scanner - AQ
        Scanner sc = new Scanner(System.in);

        //welcome - AQ
        System.out.println ("To compare NFL quarterbacks, the NFL devised a the quarterback rating formula based on the quarterbacks number of completed passes (A), pass attempts (B), passing yards (C), touchdown passes (D), and interceptions (E) as follows:");

        //collect data - RG
        System.out.println ("How many completed passes did they make?");
        double completedPasses = sc.nextDouble();
        System.out.println ("How many Pass Attempts did they make?");
        double passAttempts = sc.nextDouble();
        System.out.println ("How many passing yards did they make?");
        double passingYards = sc.nextDouble();
        System.out.println ("How many touchdown passes did they make?");
        double touchdownPasses = sc.nextDouble();
        System.out.println ("How many interceptions did they throw?");
        double interceptions = sc.nextDouble();

        //calculate data - RG
        double completionRatio = ((completedPasses / passAttempts) - 0.3) * 5;
        double yardsPerPass = ((passingYards / passAttempts) - 3) * 0.25;
        double touchdownRatio = (touchdownPasses / passAttempts) * 20;
        double interceptionRatio = 2.375 - (interceptions / passAttempts * 25);
        double quarterbackRating = ((completionRatio + yardsPerPass + touchdownRatio + interceptionRatio) / 6) * 100;

        //show data - AQ
        System.out.println ("Quarterback rating is: " +  String.format("%.1f", quarterbackRating));

        //determine and display top 10% - AQ and RG
        if (quarterbackRating >= 108.13) {
            System.out.println ("THAT IS PART OF THE TOP 10% OF NFL QUARTERBACK RATINGS OF 2020-2021");
        } else {
            System.out.println("That is NOT part of the top 10% of NFL Quarterback Ratings of 2020-2021");
        }

    }

}