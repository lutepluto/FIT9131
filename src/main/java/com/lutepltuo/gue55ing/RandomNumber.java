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
        return this.generateNumber(this.min, this.max);
    }

    /**
     * Generate random number between min and the specified max
     *
     * @param max
     * @return
     * @throws IllegalArgumentException
     */
    public int generateNumber(int max) throws IllegalArgumentException {
        return this.generateNumber(this.min, max);
    }

    /**
     * Generate random number between specified min and max
     *
     * @param min
     * @param max
     * @return
     * @throws IllegalArgumentException
     */
    public int generateNumber(int min, int max) throws IllegalArgumentException {
        if (min < this.min || max > this.max) {
            throw new IllegalArgumentException("Max number should not be excceded 100.");
        } else {
            return min + Double.valueOf(Math.random() * (max - min)).intValue();
        }
    }

}
