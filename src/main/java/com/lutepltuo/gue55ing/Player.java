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
     * @throws IllegalArgumentException
     */
    public Player(String name) throws IllegalArgumentException {
        if (outOfRange(name)) {
            throw new IllegalArgumentException("The name's length should be between 1 to 8");
        }
        if (containsInValidCharacters(name)) {
            throw new IllegalArgumentException("The name can only contain characters");
        }
        this.name = name;
        this.guesses = 0;
        this.score = 0;
    }

    /**
     * Checks the name's length is out of range
     *
     * @param name
     * @return
     */
    public boolean outOfRange(String name) {
        int len = name.length();
        return len < 1 || len > 8;
    }

    /**
     * Checks the name contains any invalid characters
     *
     * @param name
     * @return
     */
    public boolean containsInValidCharacters(String name) {
        for (int i = 0; i < name.length(); i++) {
            int code = name.charAt(i);
            if (code < 65 || (code > 90 && code < 97) || code > 122) {
                return true;
            }
        }
        return false;
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
