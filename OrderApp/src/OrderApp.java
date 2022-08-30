import java.util.Arrays;
import java.util.Scanner;

public class OrderApp {

    public static void main(String[] args) {

        // list variables
        Scanner sc = new Scanner(System.in);
        double cheeseburgerLoop = 0;
        double cheeseburgerBasePrice = 9.99;
        double cheeseburgerSubtotal = 0;
        double smallFryCount = 0;
        double medFryCount = 0;
        double largeFryCount = 0;
        double friesSubtotal = 0;
        double friesLoop = 0;
        double smallSodaCount = 0;
        double medSodaCount = 0;
        double largeSodaCount = 0;
        double sodaSubtotal = 0;
        double sodaLoop = 0;
        double subTotal = 0;
        double justTax = 0;
        double realTotal = 0;

        // intro
        System.out.println("Welcome to the Godburn Burger Ordering App");

        // ask for order
        System.out.println("How many cheeseburgers would you like to order?");
        System.out.println("The base price of a cheeseburger is: $" + String.format("%.2f", cheeseburgerBasePrice));
        cheeseburgerLoop = sc.nextDouble();
        String[] cheeseburgerList = new String[(int) cheeseburgerLoop];
        double[] cheeseburgerOrder = new double[(int) cheeseburgerLoop];
        String[][] cheeseburgerFinal = burgerOrder(cheeseburgerLoop);
        for(int i = 0;i < cheeseburgerFinal[0].length;i++)
        {
            cheeseburgerList[i] = cheeseburgerFinal[0][i];
            cheeseburgerOrder[i] = Double.parseDouble(cheeseburgerFinal[1][i]);
        }


        System.out.println("How many fries would you like to order?");
        friesLoop = sc.nextDouble();
        double [] friesFinal = sodaOrder(friesLoop);
        smallFryCount = friesFinal[0];
        medFryCount = friesFinal[1];
        largeFryCount = friesFinal[2];
        friesSubtotal = friesFinal[3];

        System.out.println("How many sodas would you like to order?");
        sodaLoop = sc.nextDouble();
        double[] sodaFinal = sodaOrder(sodaLoop);
        smallSodaCount = sodaFinal[0];
        medSodaCount = sodaFinal[1];
        largeSodaCount = sodaFinal[2];
        sodaSubtotal = sodaFinal[3];


        // list prices
        System.out.println("Itemized List:");
        listOrder(cheeseburgerLoop, cheeseburgerList, cheeseburgerOrder, smallFryCount, medFryCount, largeFryCount, smallSodaCount, medSodaCount, largeSodaCount);

        // calculate and list subtotal
        System.out.println("Payment: ");
        subTotal = subtotalCalc(cheeseburgerOrder, cheeseburgerSubtotal, friesSubtotal, sodaSubtotal);
        System.out.println("Subtotal: $" + String.format("%.2f", subTotal));

        // calculate and list tax and total
        justTax = justTaxCalc(subTotal);
        realTotal = totalCalc(subTotal);
        System.out.println("Tax: $" + String.format("%.2f", justTax));
        System.out.println("Total: $" + String.format("%.2f", realTotal));

    }

    // burger order method
    public static String[][] burgerOrder(double cheeseburgerLoop) {

        // list variables
        Scanner sc = new Scanner(System.in);
        String sizeChoice = "";
        double loopNumber = 0;
        double cheeseburgerBasePrice = 9.99;
        boolean optionsLoop = true;
        String[][] cheeseburgerOptions = {
                {"Regular", "Pretzel", "Stuffed"},
                {"$0"     , "$2"     , "$6"     },
                {"American","Cheddar","Swiss"},
                {"$0"      ,"$0.25"  ,"$0.50"},
                {"Lettuce", "Onion", "Tomato", "Gold" , "Nothing (Else)"},
                {"$1.25"  , "$1.50", "$1.75" , "$9239", "$0"            }
        };

        // do burger order
        String[] cheeseburgerList = new String[(int) cheeseburgerLoop];
        double[] cheeseburgerOrder = new double[(int) cheeseburgerLoop];
        while (loopNumber < cheeseburgerLoop) {
            System.out.println("What bun type would you like for cheeseburger #" + String.format("%.0f", (loopNumber + 1) ));
            System.out.println("The options are: " + Arrays.toString(cheeseburgerOptions[0]));
            System.out.println("The extra price for each are: " + Arrays.toString(cheeseburgerOptions[1]));
            sizeChoice = sc.next();
            for (int a = 0; a < cheeseburgerOptions[0].length; a++) {
                if (sizeChoice.toLowerCase().equals(cheeseburgerOptions[0][a].toLowerCase())) {
                    cheeseburgerOrder[(int) loopNumber] = cheeseburgerBasePrice  + Double.parseDouble(cheeseburgerOptions[1][a].substring(1));
                    cheeseburgerList[(int) loopNumber] = "1x Cheeseburger + " + cheeseburgerOptions[0][a] + " Bun";
                }
            }
            System.out.println("What cheese type would you like for cheeseburger #" + String.format("%.0f", (loopNumber + 1) ));
            System.out.println("The options are: " + Arrays.toString(cheeseburgerOptions[2]));
            System.out.println("The extra price for each are: " + Arrays.toString(cheeseburgerOptions[3]));
            sizeChoice = sc.next();
            for (int a = 0; a < cheeseburgerOptions[2].length; a++) {
                if (sizeChoice.toLowerCase().equals(cheeseburgerOptions[2][a].toLowerCase())) {
                    cheeseburgerOrder[(int) loopNumber] = cheeseburgerOrder[(int) loopNumber] + Double.parseDouble(cheeseburgerOptions[3][a].substring(1));
                    cheeseburgerList[(int) loopNumber] = cheeseburgerList[(int) loopNumber] + " + " + cheeseburgerOptions[2][a] + " Cheese";
                }
            }
            while (optionsLoop == true) {
                System.out.println("Would you like to add any other options on cheeseburger #" + String.format("%.0f", (loopNumber + 1) ));
                System.out.println("The options are: " + Arrays.toString(cheeseburgerOptions[4]));
                System.out.println("The extra price for each are: " + Arrays.toString(cheeseburgerOptions[5]));
                sizeChoice = sc.next();
                for (int a = 0; a < cheeseburgerOptions[4].length; a++) {
                    if (sizeChoice.toLowerCase().equals(cheeseburgerOptions[4][a].toLowerCase())) {
                        cheeseburgerOrder[(int) loopNumber] = cheeseburgerOrder[(int) loopNumber] + Double.parseDouble(cheeseburgerOptions[5][a].substring(1));
                        if (sizeChoice.toLowerCase().equals("nothing") != true || sizeChoice.toLowerCase().equals("nothing else") != true) {
                            cheeseburgerList[(int) loopNumber] = cheeseburgerList[(int) loopNumber] + (" + " + cheeseburgerOptions[4][a]);
                        }
                    }
                }
                if (sizeChoice.toLowerCase().equals("nothing") || sizeChoice.toLowerCase().equals("nothing else")) {
                    optionsLoop = false;
                    break;
                }
            }
            optionsLoop = true;
            loopNumber++;
        }
        String[][] cheeseburgerFinal = new String [2][(int) cheeseburgerLoop];
        for(int i = 0;i < cheeseburgerFinal[0].length;i++)
        {
            cheeseburgerFinal[0][i] = cheeseburgerList[i];
            cheeseburgerFinal[1][i] = String.valueOf(cheeseburgerOrder[i]);
        }
        return  cheeseburgerFinal;
    }

    // soda order method
    public static double[] friesOrder(double friesLoop) {

        // list variables
        Scanner sc = new Scanner(System.in);
        double loopNumber = 0;
        String[] Sizes = {"Small", "Medium", "Large"};
        String sizeChoice = "";
        String[] friesPrices = {"$4.99", "$5.99", "$6.99"};
        double friesSubtotal = 0;
        double smallFryCount = 0;
        double medFryCount = 0;
        double largeFryCount = 0;

        // do fries order
        while (loopNumber < friesLoop) {
            System.out.println("What size would you like for fry #" + String.format("%.0f", (loopNumber + 1) ));
            System.out.println("Please Type a selection: Small, Medium, or Large");
            System.out.println("The prices for each are: " + Arrays.toString(friesPrices));
            sizeChoice = sc.next();
            if (sizeChoice.toLowerCase().equals("small")) {
                smallFryCount++;
            } else if (sizeChoice.toLowerCase().equals("medium")) {
                medFryCount++;
            } else if (sizeChoice.toLowerCase().equals("large")) {
                largeFryCount++;
            }
            for (int a = 0; a < Sizes.length; a++) {
                if (sizeChoice.toLowerCase().equals(Sizes[a].toLowerCase())) {
                    friesSubtotal = friesSubtotal + Double.parseDouble(friesPrices[a].substring(1));
                }
            }
            loopNumber++;
        }
        double[] friesFinal = new double[]  {smallFryCount, medFryCount, largeFryCount, friesSubtotal};
        return friesFinal;
    }

    // soda order method
    public static double[] sodaOrder(double sodaLoop) {

        // list variables
        Scanner sc = new Scanner(System.in);
        double loopNumber = 0;
        String[] Sizes = {"Small", "Medium", "Large"};
        String sizeChoice = "";
        double smallSodaCount = 0;
        double medSodaCount = 0;
        double largeSodaCount = 0;
        double sodaSubtotal = 0;
        String[] sodaPrices = {"$1.99", "$2.99", "$3.99"};

        // do soda order
        while (loopNumber < sodaLoop) {
            System.out.println("What size would you like for soda #" + String.format("%.0f", (loopNumber + 1) ));
            System.out.println("Please Type a selection: Small, Medium, or Large");
            System.out.println("The prices for each are: " + Arrays.toString(sodaPrices));
            sizeChoice = sc.next();
            if (sizeChoice.toLowerCase().equals("small")) {
                smallSodaCount++;
            } else if (sizeChoice.toLowerCase().equals("medium")) {
                medSodaCount++;
            } else if (sizeChoice.toLowerCase().equals("large")) {
                largeSodaCount++;
            }
            for (int a = 0; a < Sizes.length; a++) {
                if (sizeChoice.toLowerCase().equals(Sizes[a].toLowerCase())) {
                    sodaSubtotal = sodaSubtotal + Double.parseDouble(sodaPrices[a].substring(1));
                }
            }
            loopNumber++;
        }
        double[] sodaFinal = new double[]  {smallSodaCount, medSodaCount, largeSodaCount, sodaSubtotal};
        return sodaFinal;
    }

    // itemized list method
    public static void listOrder(double cheeseburgerLoop, String[] cheeseburgerList, double[] cheeseburgerOrder, double smallFryCount, double medFryCount, double largeFryCount, double smallSodaCount, double medSodaCount, double largeSodaCount) {

        // list variables
        String[] friesPrices = {"$4.99", "$5.99", "$6.99"};
        String[] sodaPrices = {"$1.99", "$2.99", "$3.99"};

        // show itemized list
        if (cheeseburgerLoop > 0) {
            for (int a = 0; a < cheeseburgerList.length; a++) {
                System.out.println(cheeseburgerList[a] + " - $" + String.format("%.2f", cheeseburgerOrder[a]));
            }
        }
        if (smallFryCount > 0) {
            System.out.println(String.format("%.0f", smallFryCount) + "x Small Fry - $" + smallFryCount * Double.parseDouble(friesPrices[0].substring(1)));
        }
        if (medFryCount > 0) {
            System.out.println(String.format("%.0f", medFryCount) + "x Medium Fry - $" + medFryCount * Double.parseDouble(friesPrices[1].substring(1)));
        }
        if (largeFryCount > 0) {
            System.out.println(String.format("%.0f", largeFryCount) + "x Large Fry - $" + largeFryCount * Double.parseDouble(friesPrices[2].substring(1)));
        }
        if (smallSodaCount > 0) {
            System.out.println(String.format("%.0f", smallSodaCount) + "x Small Soda - $" + smallSodaCount * Double.parseDouble(sodaPrices[0].substring(1)));
        }
        if (medSodaCount > 0) {
            System.out.println(String.format("%.0f", medSodaCount) + "x Medium Soda - $" + medSodaCount * Double.parseDouble(sodaPrices[1].substring(1)));
        }
        if (largeSodaCount > 0) {
            System.out.println(String.format("%.0f", largeSodaCount) + "x Large Soda - $" + largeSodaCount * Double.parseDouble(sodaPrices[2].substring(1)));
        }
    }

    // calculate subtotal method
    public static double subtotalCalc(double[] cheeseburgerOrder, double cheeseburgerSubtotal, double friesSubtotal, double sodaSubtotal) {
        for (int a = 0; a < cheeseburgerOrder.length; a++) {
            cheeseburgerSubtotal = cheeseburgerSubtotal + cheeseburgerOrder[a];
        }
        double subTotal = cheeseburgerSubtotal + friesSubtotal + sodaSubtotal;
        return subTotal;
    }

    // calculate just tax method
    public static double justTaxCalc(double subTotal) {
        double taxRate = 0.065;
        double justTax = subTotal * taxRate;
        return justTax;
    }

    // calculate total method
    public static double totalCalc(double subTotal) {
        double taxRate = 0.065;
        double realTotal = subTotal * (1 + taxRate);
        return  realTotal;
    }

}

