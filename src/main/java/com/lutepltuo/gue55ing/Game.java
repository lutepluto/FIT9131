/**
 *
 */
package com.lutepltuo.gue55ing;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author lute
 */
public class Game {

    private final int HUAMN_ABANDON = 999;

    @SuppressWarnings("serial")
    private final Map<Integer, Integer> SCORE_TABLE = new HashMap<Integer, Integer>() {{
        put(1, 20);
        put(2, 15);
        put(3, 11);
        put(4, 8);
        put(5, 6);
        put(6, 5);
    }};

    private Scanner scanner;

    private RandomNumber randomNumber;

    /**
     * default constructor
     */
    public Game() {
        this.scanner = new Scanner(new BufferedInputStream(System.in));
        this.randomNumber = new RandomNumber();
    }

    public void gameStart() {

        Computer computer = new Computer();
        System.out.println("Hi, welcome to number gue55ing game.");

        Player human = requestPlayer();
        System.out.printf("Hello %s, good luck!\n", human.getName());

        int offensive = randomNumber.generateNumber() % 2;
        List<Player> players = Arrays.asList(computer, human);

        for (int round = 1; round <= 4; round++) {
            // abandon indicator for computer
            int computerAbandon = randomNumber.generateNumber(20);

            // every round, we generate a new target for guessing
            int target = randomNumber.generateNumber();
            int min = 1;
            int max = 100;

            int guesses;
            for (guesses = 1; guesses < 7; guesses++) {
                System.out.printf("The hidden number is between %d and %d.\n", min, max);

                Player player = players.get(Math.abs(offensive - guesses % 2));
                if (player.isComputer() && computerAbandon == randomNumber.generateNumber(20)) {
                    System.out.println("Computer has abandoned this round!");
                    System.out.println("\n******************* Gue55ing Game *********************\n");
                    break;
                }

                int number = enterNumber(player, min, max);
                if (!player.isComputer() && number == HUAMN_ABANDON) {
                    System.out.println("Sorry, you have been abandoned this round!\n");
                    System.out.println("\n******************* Gue55ing Game *********************\n");
                    break;
                }
                player.lastGuess(number);

                System.out.printf("%s enters number %d.\n", player.getName(), number);
                if (number == target) {
                    System.out.printf("%s guess the correct number!\n", player.getName());
                    int score = SCORE_TABLE.get(guesses);
                    player.score(score);
                    System.out.printf("%s got %d scores for round %d\n", player.getName(), score, round);
                    break;
                } else if (number < target) {
                    if (number >= min) {
                        min = number + 1;
                    }
                    System.out.println("The guess is lower.");
                    System.out.println("\n******************* Gue55ing Game *********************\n");
                } else {
                    if (number <= max) {
                        max = number - 1;
                    }
                    System.out.println("The guess is higher.");
                    System.out.println("\n******************* Gue55ing Game *********************\n");
                }
            }

            // No one guessed the target
            if (guesses == 7) {
                for (Player player : players) {
                    int proximity = Math.abs(player.getGuesses() - target);
                    int score = proximity > 10 ? 0 : 10 - proximity;
                    player.score(score);
                    System.out.printf("%s got %d scores for round %d\n", player.getName(), score, round);
                }
            }
        }

        System.out.printf("Your final score is: %d\n", human.getScore());
        System.out.printf("Computer's final score is: %d\n", computer.getScore());
        if (human.getScore() > computer.getScore()) {
            System.out.println("Congrats! You win the game!");
        } else if (human.getScore() < computer.getScore()) {
            System.out.println("Sorry, computer K.O!");
        } else {
            System.out.println("Draw for this game. Try again?");
        }
    }

    /**
     * @param player
     * @param min
     * @param max
     * @return
     */
    private int enterNumber(Player player, int min, int max) {
        if (player.isComputer()) {
            return randomNumber.generateNumber(min, max);
        }

        System.out.printf("%s, plz enter a lucky number:\n", player.getName());
        while (true) {
           try {
               int number = scanner.nextInt();
               if ((number < 1 || number > 100) && number != HUAMN_ABANDON) {
                   System.out.println("Plz enter a number bewteen 1 and 100.");
                   continue;
               }
               if ((number < min || number > max) && number != HUAMN_ABANDON) {
                   System.out.println("Sorry, the number entered is out of the possible range.");
               }
               return number;
           } catch (InputMismatchException e) {
               System.out.println("Plz enter a valid number.");
           }
        }
    }

    /**
     * Request player for entering a correct name
     *
     * @return
     */
    private Player requestPlayer() {
        Player player = null;
        System.out.println("Please enter your name:");
        while (player == null) {
            String name = scanner.nextLine();
            try {
                player = new Player(name);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Please reenter your name:");
            }
        }
        return player;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.gameStart();
    }

}
