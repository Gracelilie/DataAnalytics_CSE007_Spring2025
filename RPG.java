/*
* Grace-lilie Acheampong
*800137566
* 03/27/2025 
* CSE007 Spring 2025: Homework 6
* description: This Java program simulates a dungeon RPG game where the player battles enemies, can attack, heal, or flee. The player earns gold by defeating enemies, and if defeated, the player loses half of their gold. 
*The game continues until all enemies are defeated or the player flees.
* used Java11
*/

import java.util.Scanner;
import java.util.Random;

public class RPG {
    public static void main(String[] args) {

        int[] enemies = {3, 5, 8, 10, 15}; // Enemy health array
        int enemyIndex = 0; // Current enemy pointer
        final int MAX_HEALTH = 25; // Maximum value that can be stored in currHealth
        int currHealth = MAX_HEALTH; // Current health of the user
        int gold = 0; // Amount of gold earned after defeating an enemy
        String userOption = "";
        int healAmount;
        int enemyAttack;

        // Simulating the game
        System.out.println("The Player has entered the Dungeon!");
        System.out.print("Enemies Status: [");
        for (enemyIndex = 0; enemyIndex < enemies.length; enemyIndex++) {
            System.out.print(enemies[enemyIndex]);
            if (enemyIndex < enemies.length - 1) {
                System.out.print(", ");
            }
        }
        enemyIndex = 0;//Resetting enemyIndex for battle
        System.out.println("]");
        System.out.println("Player Health: " + currHealth);
        System.out.println("Gold: " + gold);
        System.out.println();

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        //while loop made until all conditions are complete(defeated enemies)
        while(enemyIndex < enemies.length){
            System.out.println("Oh-No! An Enemy Has Appeared! (Health: " + enemies[enemyIndex] + ")");
            System.out.println("What would you like to do? (Attack, Heal, Flee): ");
            userOption = scan.nextLine().toLowerCase();

            //handling multiple choices
            switch (userOption) {
                case "attack":
                    enemies[enemyIndex] -= 5;
                    System.out.println("The player hit for 5 damage!");

                    //Checking for enemy defeat 
                    if (enemies[enemyIndex] <= 0) {
                        gold += 10 + (enemyIndex * 2); //Gold gained
                        System.out.println("Enemy defeated!");
                        enemyIndex++; //Move to the next enemy

                        //Displaying current status of game
                        System.out.println();
                    System.out.print("Enemies Status: [");
                    for (int i = 0; i < enemies.length; i++) {
                        System.out.print(enemies[i]);
                        if (i < enemies.length - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println("]");
                    System.out.println("Player Health: " + currHealth);
                    System.out.println("Gold: " + gold);
                    System.out.println();                
                    continue; //Skip the rest of the loop iteration
                       
                    }             
                    break;
                   
                case "heal":
                    healAmount = rand.nextInt(5) + 2; //Randomly generating healing
                    currHealth += healAmount;
                    if (currHealth > MAX_HEALTH){
                        currHealth = MAX_HEALTH; //Ensuring health never exceeds MAX_HEALTH        
                    }                    
                    System.out.println("Player Health now: " + currHealth);
                    System.out.println();
                    break;

                case "flee":
                    //Game ends if player chooses to flee
                    System.out.println((enemies.length - enemyIndex) + " Enemies left undefeated.");
                    System.out.println("The player excaped with " + gold + " gold!");
                    scan.close();
                    return;

                default:
                    System.out.println("Invalid option! Please choose Attack, Heal, or Flee.");
            }
            //enemy Attack if user still alive
            if (enemies[enemyIndex] > 0) {
                enemyAttack = rand.nextInt(3) + 2;
                currHealth -= enemyAttack;
                System.out.println("The enemy attacks for " + enemyAttack + " damage!");

                //confirms if user is defeated
                if (currHealth <= 0) {
                gold -= gold / 2;
                System.out.println("You have been defeated! You lose half your gold.");
                scan.close();
                return; // End game
                }
            }

            // Displaying game status
            System.out.print("Enemies Status: [");
            for (int i = 0; i < enemies.length; i++) {
                System.out.print(enemies[i]);
                if (i < enemies.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            System.out.println("Player Health: " + currHealth);
            System.out.println("Gold: " + gold);
            System.out.println();
        }
        // Player wins if all enemies are defeated
        System.out.println("Player Victorious! All Enemies Defeated!");
        System.out.println("The Player escaped with " + gold + " gold.");
        System.out.print("--------");
        scan.close();
        
    }
}