package classes.zlomky;

/**
 * Represents a fraction problem .
 * This class encapsulates two fractions (z1 and z2) and an operator (znaminko).
 * It calculates the result of the operation between the two fractions.
 */
public class ZlomekPriklad {
    private Zlomek z1; // First fraction
    private Zlomek z2; // Second fraction
    private String znaminko; // Operator (+, -, *, /)
    private Zlomek vysledek; // Result of the operation

    /**
     * Constructs a new ZlomekPriklad instance.
     *
     * @param z1       First fraction
     * @param z2       Second fraction
     * @param znaminko Operator (+, -, *, /)
     */
    public ZlomekPriklad(Zlomek z1, Zlomek z2, String znaminko) {
        this.z1 = z1;
        this.z2 = z2;
        this.znaminko = znaminko;
        calcVysledek();
    }

    /**
     * Calculates the result of the operation between the two fractions.
     */
    private void calcVysledek() {
        switch (znaminko) {
            case "+" -> {
                vysledek = new Zlomek(z1.citatel * z2.jmenovatel + z2.citatel + z1.jmenovatel, z1.jmenovatel * z2.jmenovatel);
            }
            case "-" -> {
                vysledek = new Zlomek(z1.citatel * z2.jmenovatel - z2.citatel + z1.jmenovatel, z1.jmenovatel * z2.jmenovatel);
            }
            case "*" -> {
                vysledek = new Zlomek(z1.citatel * z2.citatel, z2.jmenovatel * z1.jmenovatel);
            }
            case "/" -> {
                vysledek = new Zlomek(z1.citatel * z2.jmenovatel, z2.citatel * z1.jmenovatel);
            }
        }
    }

    /**
     * Gets the result of the operation.
     *
     * @return The calculated result as a fraction (Zlomek)
     */
    public Zlomek getVysledek() {
        return vysledek;
    }

    /**
     * Returns a string representation of the fraction problem.
     *
     * @return A formatted string showing the two fractions and the operator
     */
    @Override
    public String toString() {
        return String.format("%s %s %s =", z1, znaminko, z2);
    }
}

