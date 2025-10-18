/*
* Grace-lilie Acheampong
*800137566
* 03/07/2025 
* CSE007 Spring 2025: Homework 6
* Description: This Java program generates an array of random double values between 12.5 and 74.5. 
*The size of the array and the random number generator seed are provided as command-line arguments. The program validates the input arguments, creates and populates the array, then computes and displays the average, minimum, and maximum values along with their indices. 
* used Java11
*/

import java.util.Random;

public class RandomArrays {
    public static void main(String[] args) {
        // boolean valid = true;
        int length = 0; 
        int seed=0;
        do{
            // Validate Command Line Arguments          
            if (args.length == 2) {               
                length = Integer.parseInt(args[0]);
                seed = Integer.parseInt(args[1]);

                // Checking if length is greater than 0
                if (length <= 0) {
                    System.out.println("Error: Array length must be greater than 0. Please enter valid arguments.");
                    System.out.println("----");
                    return;
                }
                // If both checks are passed, exit the loop
                    break;
            } else {
                System.out.println("Error! Missing command line argument(s)");
                System.out.println("----");
                return;        
            }
        } while (true);

        // Step 2: Create Random object
        Random rand = new Random(seed);

        // Step 3: Create and populate the array
        double[] randomArray = new double[length];

        System.out.println("Creating the Array...");
        System.out.println("Filling the Array...");

        for (int i = 0; i < length; i++) {
            randomArray[i] = 12.5 + (rand.nextDouble() * (75.5 - 12.5)); // Random double in range [12.5, 74.5]
        }

        System.out.println("Printing the Array...");

        // Step 4: Print array values
        for (int i = 0; i < length; i++) {
            System.out.printf("Element %d: %.4f%n", i, randomArray[i]);
        }

        // Step 5: Compute statistics
        double min = randomArray[0], max = randomArray[0], sum = 0;
        int minIndex = 0, maxIndex = 0;

        for (int i = 0; i < length; i++) {
            sum += randomArray[i];

            if (randomArray[i] < min) {
                min = randomArray[i];
                minIndex = i;
            }
            if (randomArray[i] > max) {
                max = randomArray[i];
                maxIndex = i;
            }
        }

        double average = sum / length;

        // Step 6: Display results
        System.out.printf("Average of all %d values: %.4f%n", length, average);
        System.out.printf("Min Value of %.4f found at index=%d%n", min, minIndex);
        System.out.printf("Max Value of %.4f found at index=%d%n", max, maxIndex);

        System.out.println("---");
    }
}

