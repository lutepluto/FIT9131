/**
 *
 */
package com.lutepltuo.gue55ing;

/**
 * @author lute
 */
public class RandomNumber {

    private int min;

    private int max;

    /**
     * default constructor
     */
    public RandomNumber() {
        this.min = 0;
        this.max = 100;
    }

    /**
     * Generate random number between min and max
     *
     * @return
     * @throws IllegalArgumentException
     */
    public int generateNumber() throws IllegalArgumentException {
        return this.generateNumber(max);
    }

    /**
     * Generate random number between min and the specified max
     *
     * @param max
     * @return
     * @throws IllegalArgumentException
     */
    public int generateNumber(int max) throws IllegalArgumentException {
        if (max > 100) {
            throw new IllegalArgumentException("Max number should not be excceded 100.");
        } else {
            return min + Double.valueOf(Math.random() * (max - min)).intValue();
        }
    }

}
