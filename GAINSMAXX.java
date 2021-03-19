/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author Daniel Fitzpatrick
 */
public class GAINSMAXX {

    public static String gender;
    public static double currentWeight;
    public static double desiredWeight;
    public static int height;
    public static int age;
    public static int activity;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        //intro
        System.out.println("---WELCOME---");
        System.out.println("     to");
        System.out.println("---GAINSMAXX---");
        System.out.println("");

        //verify gender
        while (true) {
            System.out.println("Input sex (m/f)");
            gender = scanner.nextLine();
            if (gender.equals("m") || gender.equals("f")) {
                break;
            } else {
                System.out.println("ERROR: Please type 'm' for male or 'f' for female.");
            }
        }
        //other user inputs
        System.out.println("Input current weight (kg):");
        currentWeight = Double.valueOf(scanner.nextLine());
        System.out.println("Input DESIRED weight (kg):");
        desiredWeight = Double.valueOf(scanner.nextLine());
        System.out.println("Input current height (cm):");
        height = Integer.valueOf(scanner.nextLine());
        System.out.println("How active are you?");
        System.out.println("1 = sedentary, maybe some lifting/walking");
        System.out.println("2 = some cardio, e.g. 5k run 4-5x a week");
        System.out.println("3 = pretty active, regular 10ks or higher");

        while (true) {
            System.out.println("Please input 1, 2 or 3.");
            activity = Integer.valueOf(scanner.nextLine());
            if (activity == 1 || activity == 2 || activity == 3) {
                break;
            }
        }
        System.out.println("Finally, enter your age (years):");
        age = Integer.valueOf(scanner.nextLine());

        //calculate TDEE
        double tdee;
        if (gender.equals("m")) {
            tdee = ((10 * currentWeight) + (6.25 * height) - (5 * age) + 5);
        } else {
            tdee = ((10 * currentWeight) + (6.25 * height) + (5 * age) - 161);
        }

        //approximate activity level
        switch (activity) {
            case 1:
                tdee = tdee * 1.2;
                break;
            case 2:
                tdee = tdee * 1.35;
                break;
            case 3:
                tdee = tdee * 1.55;
                break;
            default:
                break;
        }
        //use TDEE to calculate weight gain timescale
        double weightDifference = (desiredWeight - currentWeight);
        double weightTime = (weightDifference * 7) / 0.5;
        double daysToWeeks = weightTime / 7;

        //outputs
        System.out.println("very good. You are currently: " + currentWeight + " kilos. You want to gain " + weightDifference + " kilos.");
        System.out.println("To gain weight at a healthy rate, you want to eat at most a +500 daily surplus above what you burn.");
        System.out.println("For you, that would be " + (tdee + 500) + " calories per day.");
        System.out.println("It should take around " + weightTime + " days (" + daysToWeeks + " weeks) to gain " + weightDifference + " kilos.");
        System.out.println("You should gain around 0.5kg a week at this rate, although don't be afraid to adjust as you go.");
        System.out.println("now ---GAINSMAXX--- and make yourself proud.");

    }
}
