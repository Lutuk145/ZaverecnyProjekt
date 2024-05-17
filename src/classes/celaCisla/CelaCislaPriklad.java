package classes.celaCisla;

import java.util.InputMismatchException;

public class CelaCislaPriklad {
    private final int num1;
    private final int num2;
    private String znaminko;
    private int vysledek;

    public CelaCislaPriklad(int num1, int num2, String znaminko) {
        this.num1 = num1;
        this.num2 = num2;
        setZnaminko(znaminko);
        calcVysledek();
    }

    private void calcVysledek() {
        switch (this.znaminko) {
            case "+" -> vysledek = num1 + num2;
            case "-" -> vysledek = num1 - num2;
            case "*" -> vysledek = num1 * num2;
            case "/" -> vysledek = num1 / num2;
            default -> {
                vysledek = 0;
                throw new InputMismatchException("Spatne znaminko");
            }
        }
    }

    private void setZnaminko(String znaminko) {
        switch (znaminko) {
            case "+", "-", "*", "/" -> this.znaminko = znaminko;
            default -> {
                this.znaminko = "+";
                throw new InputMismatchException("Neplatne znaminko");
            }
        }
    }

    public int getVysledek() {
        return vysledek;
    }

    @Override
    public String toString() {
        return String.format("%d %s %d =", num1, znaminko, num2);
    }
}
