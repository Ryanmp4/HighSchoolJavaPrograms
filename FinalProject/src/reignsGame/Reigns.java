package reignsGame;

import java.util.*;

public class Reigns {

    public static void main(String[] args) {

        // Variables
        // Jakob & Ryan
        // 6. array
        String[] gameQuestions =
                {
                        "The kingdom of the South claims that you're betrothed to their young princess. Declining may trigger a war.",
                        "I would like to conduct a mass to the memory of your father.",
                        "Cereals are very cheap these days my Lord. You Should adjust the price of bread",
                        "The Queen of the South is offering you 40 books. We should build a bigger library.",
                        "This is the coldest winter of the last 30 years. After the weak harvest, your people are starving.",
                        "There's a crisis in your Church. We need to reform our religion!",
                        "We should make a new pilgrimage sculpture",
                        "I heard strange noises in the castle last night. We should have more guards patrolling!",
                        "You should organize another curfew. The streets of the capital are not safe at night!",
                        "We should have a party for another great year!",
                        "A ship has been quarantined. It may be the rona. Shall we quarantine the whole port.",
                        "The army is bored! What shall we do?",
                        "There's a rona outbreak in the capital! We are all going to die.",
                        "Long live the King! I will pray for the prosperity of Your Majesty.",
                        "We developed a new farming technique. What should we do?",
                        "I don't like Matt, he's a liar.",
                        "The river Drop is dry again. We should expand the dam.",
                        "An explosion in the mine haas killed at least 100 people. Shall we continue digging?",
                        "Your soldiers' wages are too low. Please pay them properly and on time.",
                        "We should build a new church.",
                        "The cattle are dying from the rona. Please help them contain the disease.",
                        "My Lord, would you like to hunt some wild pigs.",
                        "Should we build more embassies in neighbouring countries. It may help to prevent wars.",
                        "The mines are full of gold my Lord!",
                        "We found a serial killer...",
                        "There was a massive prison breakout. We need to organize a search party.",
                        "We found some gold in the mines. Should we try to dig deeper?",
                        "There is a lion loose in the street!",
                        "I heard strange noises in the castle last night. We should have more guards patrolling.",
                        "I just witnessed a miracle!",
                        "Would you like me to help train your army more. My skills do not go cheap."
                };
        String[][] gameOptions =
                {
                        {"Accept", "Deny"},
                        {"Yes", "No"},
                        {"Increase the price", "No"},
                        {"Yes", "No"},
                        {"Help", "Don't"},
                        {"Sure, lets do it", "No"},
                        {"Yes", "No"},
                        {"Yes", "No"},
                        {"Yes", "No"},
                        {"Sure, lets do it", "No"},
                        {"Yes", "No"},
                        {"Go exercise", "Drink wine"},
                        {"Treat the population", "Save my money"},
                        {"Yes", "No"},
                        {"Its all mine", "Share it for all"},
                        {"But a useful one", "Throw him out"},
                        {"Yes", "No"},
                        {"Yes", "No"},
                        {"Yes", "No"},
                        {"Yes", "No"},
                        {"Yes", "No"},
                        {"Yes", "No"},
                        {"Yes", "No"},
                        {"Share it", "Its mine"},
                        {"Make him the executioner", "So what?"},
                        {"Yes", "No"},
                        {"Yes", "No"},
                        {"Contain it now!", "Not my problem"},
                        {"Yes", "No"},
                        {"True!", "Not True!"},
                        {"Yes", "No"}
                };
        int[][] gameResults =
                {
                        {5, 5, 5, 5},
                        {10, 0, 0, -10},
                        {0, -10, 0, 10},
                        {-10, 10, 20, -10},
                        {10, 10, 10, -10},
                        {10, 10, 10, -10},
                        {10, 10, 0, -10},
                        {0, 10, -20, -10},
                        {0, 10, 10, -10},
                        {20, 20, 20, 20},
                        {0, 20, 20, -20},
                        {0, 10, 10, -10},
                        {0, 0, 15, -15},
                        {15, 15, 15, -15},
                        {15, 0, 0, 15},
                        {0, 0, 0, 10},
                        {0, 10, 0, -10},
                        {0, -25, 0, 25},
                        {0, 0, 15, -15},
                        {15, 0, 0, -15},
                        {0, 15, 0, -15},
                        {0, 5, 5, -5},
                        {15, 15, 15, -15},
                        {0,0, 0, 5},
                        {0,0,15, -15},
                        {0,15,15, -15},
                        {0, -25, 0, 25},
                        {0,5, 0, -5},
                        {10, 10, 10, -10},
                        {15,-15, 0, 0},
                        {0,0,25,-25}
                };
        // Ryan
        Scanner sc = new Scanner(System.in);
        String[] classes = {"Religion", "Happiness of the People", "Military Strength", "Economy"};
        int[] points     = {50        , 50                       , 50                 , 50       };
        boolean decisionReached = false;
        int year = 1;
        int tempNumber = 0;
        String tempQuestion = "";
        boolean hasChosen = false;
        int chosenAnswer;
        boolean hasWon = false;

        // Ryan - I stole this from StackOverflow
        // create array of 31 non repeating array elements
        Random randNum = new Random();
        Set<Integer> set = new LinkedHashSet<Integer>();
        // 4. while loop
        while (set.size() < gameQuestions.length) {
            set.add(randNum.nextInt(gameQuestions.length));
        }
        Object[] gameOrder = set.toArray();

        // Adam
        // intro - flow
        System.out.println("Welcome to Reigns");
        System.out.println("Watch your stats. Don't make them go below 1 or above 99.");

        // game loop - flow
        while (decisionReached == false) {

            // Ryan
            // chooses scenario
            tempNumber = (int) gameOrder[year];
            tempQuestion = gameQuestions[tempNumber];
            System.out.println("");

            // Jakob
            // display needed stats and info
            Tools.displayYear(year);
            Tools.displayStats(classes, points);
            System.out.println(tempQuestion);
            Tools.displayOptions(gameOptions[tempNumber]);

            // Ryan
            // choose possible answer and check
            chosenAnswer = sc.nextInt();
            // 3. nested loop
            while (hasChosen == false) {
                if (chosenAnswer <= gameOptions[tempNumber].length) {
                    hasChosen = true;
                    break;
                } else {
                    System.out.println("You did not make a possible choice. Try Again");
                    chosenAnswer = sc.nextInt();
                }
            }

            // Jakob
            // do points
            if (chosenAnswer == 1 || chosenAnswer == 2) {
                points = Tools.doPoints(chosenAnswer, gameResults[tempNumber], points);
            } else {

            }

            // Ryan
            // if points are above 99 or below 1, loose game
            // 5. for loop
            for (int i = 0; i < points.length; i++) {
                if (points[i] >= 100 || points[i] <= 0) {
                    decisionReached = true;
                    hasWon = false;
                    break;
                }
            }

            // Adam
            // if played through all scenarios, win game
            // 1. if-statement
            if (year == gameQuestions.length) {
                decisionReached = true;
                hasWon = true;
                break;
            }

            // Jakob
            // reset and increase year for next loop
            if (decisionReached == false) {
                year++;
                hasChosen = false;
            }

        }

        // end - flow

        // Adam
        // display final statistics
        System.out.println();
        Tools.displayStats(classes, points);
        // 2. if-else statement
        if (hasWon == true) {
            System.out.println("You Win!");
            System.out.println("You get nothing for winning because I am not rich.");
        } else {
            System.out.println("You let your kingdom die. You are also dead.");
            System.out.println("You lasted " + year + " years.");
        }

    }

}
