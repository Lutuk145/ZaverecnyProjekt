package classes.celaCisla;

import java.util.InputMismatchException;

/**
 * Represents a whole number arithmetic problem.
 */
public class CelaCislaPriklad {

    private final int num1; // First operand
    private final int num2; // Second operand
    private String znaminko; // Arithmetic operator (+, -, *, /)
    private int vysledek; // Result of the arithmetic operation

    /**
     * Constructs a new CelaCislaPriklad with the specified operands and operator.
     *
     * @param num1     The first operand.
     * @param num2     The second operand.
     * @param znaminko The arithmetic operator (+, -, *, /).
     */
    public CelaCislaPriklad(int num1, int num2, String znaminko) {
        this.num1 = num1;
        this.num2 = num2;
        setZnaminko(znaminko);
        calcVysledek();
    }

    /**
     * Calculates the result of the arithmetic operation based on the operator.
     */
    private void calcVysledek() {
        switch (this.znaminko) {
            case "+" -> vysledek = num1 + num2;
            case "-" -> vysledek = num1 - num2;
            case "*" -> vysledek = num1 * num2;
            case "/" -> vysledek = num1 / num2;
            default -> {
                vysledek = 0;
                throw new InputMismatchException("Invalid operator");
            }
        }
    }

    /**
     * Sets the arithmetic operator.
     *
     * @param znaminko The arithmetic operator (+, -, *, /).
     */
    private void setZnaminko(String znaminko) {
        switch (znaminko) {
            case "+", "-", "*", "/" -> this.znaminko = znaminko;
            default -> {
                this.znaminko = "+";
                throw new InputMismatchException("Invalid operator");
            }
        }
    }

    /**
     * Returns the result of the arithmetic operation.
     *
     * @return The calculated result.
     */
    public int getVysledek() {
        return vysledek;
    }

    /**
     * Returns a string representation of the arithmetic problem.
     *
     * @return The formatted string with operands and operator.
     */
    @Override
    public String toString() {
        return String.format("%d %s %d =", num1, znaminko, num2);
    }
}

