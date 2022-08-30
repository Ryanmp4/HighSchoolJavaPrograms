package reignsGame;

public class Tools {

        // 7. multiple methods
        // 8. multiple classes

        // Adam
        // method to display each class and points
        static void displayStats(String[] classes, int[] points) {
            // intro
            System.out.println("Your stats are:");
            // display each class and corresponding points
            for (int i = 0; i < classes.length; i++) {
                System.out.println(classes[i] + ": " + points[i]);
            }
            // skip line
            System.out.println("");
        }

        // Jakob
        // method to display the year
        static void displayYear(int year) {
            // check year
            if (year > 0) {
                // display and skip line
                System.out.println("Year: " + year);
                System.out.println("");
            }
        }

        // Ryan
        // method to display possible options
        static void displayOptions(String options[]){
            // create variables
            String showOptions = "";
            // add on each option
            for (int i = 0; i < options.length; i++) {
                if (i == options.length - 1) {
                    showOptions = showOptions + (i+1) + ": " + options[i];
                } else {
                    showOptions = showOptions + (i+1) + ": " + options[i] + " | ";
                }
            }
            // show options
            System.out.println(showOptions);
        }

        // Ryan
        // method to do math for points
        static int[] doPoints(int chosenAnswer, int[] tempResults, int[] points) {
            // create variables
            int[] newPoints = points;
            int[] modResults = tempResults;
            boolean isReversed = false;
            // reverse points if second option is chosen
            if (chosenAnswer == 2) {
                for (int i = 0; i < 4; i++) {
                    modResults[i] = tempResults[i] * -1;
                    isReversed = true;
                }
            }
            // add points on
            for (int i = 0; i < 4; i++) {
                newPoints[i] = newPoints[i] + modResults[i];
            }
            // reset
            if (isReversed == true) {
                for (int i = 0; i < 4; i++) {
                    modResults[i] = tempResults[i] * -1;
                }
            }
            isReversed = false;
            // return
            return newPoints;
        }

}
