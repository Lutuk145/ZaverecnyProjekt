package classes.zlomky;

import java.util.Scanner;

import static utils.CodingUtils.genZlomekPriklad;
import static utils.CodingUtils.wrongGuesses;


/**
 * Represents a test for working with fractions .
 * The test generates a set of fraction problems and prompts the user to solve them.
 */
public class ZlomekTest {
    private int pocet; // Number of problems to generate
    private int diff; // Difficulty level (e.g., range of numerator and denominator)

    /**
     * Constructs a new ZlomekTest instance.
     *
     * @param pocet Number of problems to generate
     * @param diff  Difficulty level (e.g., range of numerator and denominator)
     */
    public ZlomekTest(int pocet, int diff) {
        this.pocet = pocet;
        this.diff = diff;
    }

    /**
     * Generates an array of fraction problems (ZlomekPriklad instances).
     * @return An array of ZlomekPriklad instances
     */
    private ZlomekPriklad[] genPriklady() {
        ZlomekPriklad[] priklady = new ZlomekPriklad[pocet];
        for (int i = 0; i < pocet; i++) {
            priklady[i] = genZlomekPriklad(diff);
        }
        return priklady;
    }

    /**
     * Runs the fraction test.
     * Prompts the user to solve each generated problem and keeps track of correct answers.
     */
    public void test() {
        int spravne = 0; // Counter for correct answers
        ZlomekPriklad[] priklady = genPriklady();
        for (ZlomekPriklad priklad : priklady) {
            boolean run = true;
            do {
                if (wrongGuesses <= 0) {
                    System.out.println("Zadal jsi 5 neplatnych odpovedi, test ukoncen");
                    System.exit(0);
                }
                System.out.println(priklad);
                System.out.print(">>> ");
                Scanner sc = new Scanner(System.in);
                try {
                    String input = sc.next();
                    Zlomek vysledek;
                    if (input.contains("/")) {
                        vysledek = Zlomek.parseZlomek(input);
                    } else {
                        vysledek = new Zlomek(Double.parseDouble(input));
                    }
                    spravne += vysledek.getCitatel() == priklad.getVysledek().citatel && vysledek.getJmenovatel() == priklad.getVysledek().jmenovatel ? 1 : 0;
                    run = false;
                } catch (Exception e) {
                    wrongGuesses--;
                    System.out.printf("Neplatny vstup %d/5\n", wrongGuesses);
                    sc.reset();
                }
            } while (run);
        }
        System.out.println("Mas " + spravne + "/" + pocet + " spravnych odpovedi");
    }
}

