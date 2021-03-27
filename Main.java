package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {

        /*VARIABLES*/
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();
        boolean running = false;
        boolean waiting = false;
        boolean fighting = false;
        String playerName;
        int worldChoice;
        int enemyChoice;
        int randomEnemy;
        int randomEnemyDamage;
        int randomEnemyHealth;
        int playerHealth = 50;
        int randomPlayerDamage = rand.nextInt(playerHealth+10);
        int elixirCount = 3;

        /*INTRO*/
        System.out.println("Welcome to TEA");
        System.out.println("Please enter a name: ");
        playerName = scnr.next();

        /*PATHS*/
        System.out.println("Hello " +playerName+ ", please select a path\n" +
                                "\t> 1: Tutorial\n" +
                                "\t> 2: Tavern\n" +
                                "\t> 3: One last job");
        worldChoice = scnr.nextInt();
        while (!running)
        {
            if (worldChoice == 1)
            {
                System.out.println("Welcome to the tutorial!");
                running = true;
            }
            else if (worldChoice == 2)
            {
                System.out.println("You take a trip to the Tavern!\n" +
                                    "After having your usual good time inside you decide to head home.\n" +
                                    "As you're leaving you realize someones stolen your horse!\n" +
                                    "You take off on the trail in hopes of finding the thief and retrieving your horse.");
                running = true;
            }
            else if (worldChoice == 3)
            {
                System.out.println("Welcome to the last job!");
                running = true;
            }
            else
            {
                System.out.println("Please select a path\n" +
                                        "\t> 1: Tutorial\n" +
                                        "\t> 2: Tavern\n" +
                                        "\t> 3: One last job");
                worldChoice = scnr.nextInt();
                running = false;
            }
        }

        /*GAME*/
        while (running)
        {
            if (worldChoice == 2)
            {
                String[] enemies = new String[] {"bandit", "monster", "warlock", "witch"};
                 randomEnemy = rand.nextInt(enemies.length);
                int[] enemyDamage = new int[] {15, 30, 40, 45};
                randomEnemyDamage = rand.nextInt(enemyDamage[randomEnemy]);
                int[] enemyHealth = new int[] {50, 75, 90, 95};
                randomEnemyHealth = rand.nextInt(enemyHealth[randomEnemy])+25;
                waiting = true;

                System.out.println("\n--------------------------------------------------\n" +
                        "You're approached by a " +enemies[randomEnemy]+ " with " +randomEnemyHealth+ " HP!\n" +
                        "You currently have " +playerHealth+ " HP!");

                while (waiting || fighting)
                {
                    System.out.println("What would you like to do?\n" +
                                "\t> 1: Fight\n" +
                                "\t> 2: Drink elixir\n" +
                                "\t> 3: Run");
                    enemyChoice = scnr.nextInt();
                    if (enemyChoice == 1)
                    {
                        System.out.println("You've chosen to fight!");
                        fighting = true;
                        while (fighting)
                        {
                            playerHealth = playerHealth - randomEnemyDamage;
                            randomEnemyHealth = randomEnemyHealth - randomPlayerDamage;
                            if (playerHealth <= 0)
                            {
                                playerHealth = 0;
                                System.out.println("You lost.");
                                return;
                            }
                            else if (randomEnemyHealth <= 0)
                            {
                                playerHealth += 10;
                                System.out.println("You won! You now have " +playerHealth+ " HP!");
                                fighting = false;
                            }
                            else
                            {
                                System.out.println("The " +enemies[randomEnemy]+ " now has " +randomEnemyHealth+ " HP!\n" +
                                        "You now have " +playerHealth+ " HP!\n");
                                fighting = true;
                            }
                        }
                        waiting = false;
                    }
                    else if (enemyChoice == 2) {
                        System.out.println("You check for elixir!");
                        if (elixirCount > 0) {
                            elixirCount -= 1;
                            playerHealth += 15;
                            System.out.println("You drank an elixir giving you " + playerHealth + " HP! You now have " + elixirCount + " elixir.");
                        } else if (elixirCount <= 0)
                        {
                            System.out.println("You are out of elixir!");
                        }
                        waiting = false;
                    }
                    else if (enemyChoice == 3)
                    {
                        System.out.println("You run!");
                        waiting = false;
                    }
                    else
                    {
                        System.out.println("You're approached by a " +enemies[randomEnemy]+  " with " +randomEnemyHealth+ " HP!\n" +
                                            "You currently have " +playerHealth+ " HP! What would you like to do?\n" +
                                                "\t> 1: Fight\n" +
                                                "\t> 2: Drink elixir\n" +
                                                "\t> 3: Run");
                        enemyChoice = scnr.nextInt();
                    }
                }
            }
        }
    }
}
