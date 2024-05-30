package classes.zlomky;

import java.util.InputMismatchException;

/**
 * Represents a fraction.
 * This class provides methods for creating and manipulating fractions.
 */
public class Zlomek {
    protected int citatel; // Numerator
    protected int jmenovatel; // Denominator

    /**
     * Constructs a new Zlomek instance.
     *
     * @param citatel     Numerator
     * @param jmenovatel  Denominator
     */
    public Zlomek(int citatel, int jmenovatel) {
        this.citatel = citatel;
        setJmenovatel(jmenovatel);
    }

    /**
     * Parses a string representation of a fraction.
     *
     * @param s The input string (e.g., "3/4")
     * @return A Zlomek instance representing the parsed fraction
     * @throws InputMismatchException if the input string does not contain a "/"
     */
    public static Zlomek parseZlomek(String s) {
        if (!s.contains("/")) {
            throw new InputMismatchException("Zlomek neobsahuje lomeno");
        }
        String[] split = s.split("/");
        return new Zlomek(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }

    /**
     * Formats the fraction by ensuring a positive denominator.
     */
    public void format() {
        if (jmenovatel < 0) {
            this.jmenovatel *= -1;
            this.citatel *= -1;
        }
    }

    /**
     * Constructs a Zlomek instance from a decimal value.
     *
     * @param decimal The decimal value (e.g., 0.75)
     */
    public Zlomek(double decimal) {
        if (Math.log10(decimal) >= 0) {
            double pow = Math.pow(10, Math.ceil(Math.log10(decimal)));
            citatel = (int) (decimal * pow);
            setJmenovatel((int) pow);
        } else {
            int count = 0;
            do {
                decimal *= 10;
                count++;
            } while (decimal % 1 != 0);
            setJmenovatel((int) Math.pow(10, count));
            format();
        }
    }

    /**
     * Gets the numerator.
     *
     * @return The numerator
     */
    public int getCitatel() {
        return citatel;
    }

    /**
     * Gets the denominator.
     *
     * @return The denominator
     */
    public int getJmenovatel() {
        return jmenovatel;
    }

    /**
     * Sets the denominator and ensures positive value.
     *
     * @param jmenovatel The new denominator
     */
    public void setJmenovatel(int jmenovatel) {
        this.jmenovatel = jmenovatel;
        format();
    }

    /**
     * Returns a string representation of the fraction.
     *
     * @return The formatted fraction (e.g., "3/4")
     */
    @Override
    public String toString() {
        return citatel + "/" + jmenovatel;
    }
}
