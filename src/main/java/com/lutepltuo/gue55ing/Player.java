package com.lutepltuo.gue55ing;

/**
 *
 * @author lute
 */
public class Player {

    private String name;

    private int guesses;

    private int score;

    /**
     * default constructor
     */
    public Player() {
        this.name = "computer";
        this.guesses = 0;
        this.score = 0;
    }

    /**
     * @param name
     */
    public Player(String name) {
        this.name = name;
        this.guesses = 0;
        this.score = 0;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the guesses
     */
    public int getGuesses() {
        return guesses;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param guesses the guesses to set
     */
    public void setGuesses(int guesses) {
        this.guesses = guesses;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

}
