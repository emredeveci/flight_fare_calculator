import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //scanner initialization
        Scanner input = new Scanner(System.in);

        //variable initializations
        boolean validKilometers = true , validAge = true, validFlightType = true;
        boolean roundTripDiscount = false;

        int kilometers = 0, age, flightType;
        double ageDiscount = 0;
        double flightCost;

        //receive user inputs
        //input prompts loop until valid input is entered
        while (validKilometers){
            System.out.print("Enter the flight distance in kilometers: ");
            kilometers = input.nextInt();
            if (kilometers >= 1) {
                validKilometers = false;
            } else {
                System.out.println("Please enter a valid number.");
            }
        }

        while (validAge){
            System.out.print("Enter your age: ");
            age = input.nextInt();
            if (age >= 1) {
                if (age < 12) {
                    ageDiscount = 0.5;
                } else if (age >= 12 && age <=24) {
                    ageDiscount = 0.1;
                } else if (age > 65) {
                    ageDiscount = 0.3;
                }
                validAge = false;
            } else {
                System.out.println("Please enter a valid number.");
            }
        }

        while (validFlightType){
            System.out.print("Enter 1 for \"One Way\", 2 for \"Round Trip\": ");
            flightType = input.nextInt();
            if (flightType == 1 || flightType == 2) {
                validFlightType = false;

                if (flightType == 2){
                    roundTripDiscount = true;
                }
            } else {
                System.out.println("Please enter a valid number.");
            }
        }

        //fare calculation
        if (roundTripDiscount) {
            flightCost = kilometers * 0.1;
            flightCost = (ageDiscount == 0) ? flightCost : flightCost - (flightCost * ageDiscount);
            flightCost -= flightCost * 0.2;
            flightCost *= 2;
            System.out.println("Your flight cost is: " + flightCost + " TL");
        } else {
            flightCost = kilometers * 0.1;
            flightCost = (ageDiscount == 0) ? flightCost : flightCost - (flightCost * ageDiscount);
            System.out.println("Your flight cost is: " + flightCost + " TL");
        }

        input.close();
    }
}