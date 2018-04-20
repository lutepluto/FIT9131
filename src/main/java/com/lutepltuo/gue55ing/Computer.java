package com.lutepltuo.gue55ing;

/**
 * @author lute
 *
 */
public class Computer extends Player {

    /**
     * @param name
     */
    public Computer() {
        super("Computer");
    }

    /* (non-Javadoc)
     * @see com.lutepltuo.gue55ing.Player#isComputer()
     */
    @Override
    public boolean isComputer() {
        return true;
    }

}
