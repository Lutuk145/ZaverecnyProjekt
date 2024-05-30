package classes.celaCisla;

import utils.CodingUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

import static utils.CodingUtils.wrongGuesses;

/**
 * Represents a test for evaluating whole number problems.
 */
public class CelaCislaTest {

    private int pocet; // Number of problems in the test
    private int difficulty; // Difficulty level of the problems

    /**
     * Constructs a new CelaCislaTest with the specified parameters.
     *
     * @param pocet      The number of problems in the test.
     * @param difficulty The difficulty level of the problems.
     */
    public CelaCislaTest(int pocet, int difficulty) {
        this.pocet = pocet;
        this.difficulty = difficulty;
    }

    /**
     * Generates an array of whole number problems.
     *
     * @return An array of CelaCislaPriklad objects representing the problems.
     */
    private CelaCislaPriklad[] genPriklady() {
        CelaCislaPriklad[] priklady = new CelaCislaPriklad[pocet];
        for (int i = 0; i < pocet; i++) {
            priklady[i] = CodingUtils.genCelyPriklad(difficulty);
        }
        return priklady;
    }

    /**
     * Executes the test and evaluates the user's answers.
     */
    public void test() {
        int spravne = 0;
        CelaCislaPriklad[] priklady = genPriklady();

        for (CelaCislaPriklad priklad : priklady) {
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
                    int vysledek = scanner.nextInt();
                    spravne += priklad.getVysledek() == vysledek ? 1 : 0;
                    run = false;
                } catch (InputMismatchException e) {
                    wrongGuesses--;
                    System.out.printf("Neplatny vstup %d/5\n", wrongGuesses);
                    scanner.next();
                }
            } while (run);
        }
        System.out.println("Mas " + spravne + "/" + pocet + " spravnych odpovedi");
    }
}

