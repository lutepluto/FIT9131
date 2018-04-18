/**
 *
 */
package com.lutepltuo.gue55ing;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author lute
 */
public class Game {

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

        System.out.println("Hi, wElcOme to number gue55ing game.");

        Player player = requestPlayer();
        System.out.println(player.getName());
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
