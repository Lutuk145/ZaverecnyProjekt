package classes.soustavy;

import java.util.InputMismatchException;
import java.util.Scanner;

import static utils.CodingUtils.genSoustavyPriklad;
import static utils.CodingUtils.wrongGuesses;

/**
 * Represents a test for solving systems of equations .
 * The test generates a set of system of equations problems (SoustavyPriklad instances)
 * and prompts the user to solve them.
 */
public class SoustavyTest {
    private int pocet; // Number of problems to generate

    /**
     * Constructs a new SoustavyTest instance.
     *
     * @param pocet Number of problems to generate
     */
    public SoustavyTest(int pocet) {
        this.pocet = pocet;
    }

    /**
     * Generates an array of system of equations problems (SoustavyPriklad instances).
     *
     * @return An array of SoustavyPriklad instances
     */
    private SoustavyPriklad[] genPriklady() {
        SoustavyPriklad[] priklady = new SoustavyPriklad[pocet];
        for (int i = 0; i < pocet; i++) {
            priklady[i] = genSoustavyPriklad();
        }
        return priklady;
    }

    /**
     * Runs the system of equations test.
     * Prompts the user to solve each generated problem and keeps track of correct answers.
     */
    public void test() {
        int spravne = 0; // Counter for correct answers
        SoustavyPriklad[] priklady = genPriklady();
        for (SoustavyPriklad priklad : priklady) {
            boolean run = true;
            do {
                if (wrongGuesses <= 0) {
                    System.out.println("Zadal jsi 5 neplatnych odpovedi, test ukoncen");
                    System.exit(0);
                }
                System.out.println(priklad);
                System.out.print(">>> ");
                Scanner scanner = new Scanner(System.in);
                try {
                    String vysledek = scanner.nextLine();
                    spravne += Integer.parseInt(vysledek, priklad.getOutputSoustava()) == priklad.getValue() ? 1 : 0;
                    run = false;
                } catch (InputMismatchException | NumberFormatException e) {
                    wrongGuesses--;
                    System.out.printf("Neplatny vstup %d/5\n", wrongGuesses);
                    scanner.reset();
                }
            } while (run);
        }
        System.out.println("Mas " + spravne + "/" + pocet + " spravnych odpovedi");
    }
}

