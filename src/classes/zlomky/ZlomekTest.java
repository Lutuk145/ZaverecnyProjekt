package classes.zlomky;

import java.util.Scanner;

import static utils.CodingUtils.genZlomekPriklad;
import static utils.CodingUtils.wrongGuesses;

/**
 * @author Lukas Knejzlik
 * @implNote console run for fractions
 */
public class ZlomekTest {
    private int pocet;
    private int diff;

    /**
     *
     * @param pocet number of priklads
     * @param diff diffilcuty of the priklads
     */
    public ZlomekTest(int pocet, int diff) {
        this.pocet = pocet;
        this.diff = diff;
    }

    private ZlomekPriklad[] genPriklady() {
        ZlomekPriklad[] priklady = new ZlomekPriklad[pocet];
        for (int i = 0; i < pocet; i++) {
            priklady[i] = genZlomekPriklad(diff);
        }
        return priklady;
    }

    public void test() {
        int spravne = 0;
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
                    run=false;

                } catch (Exception e) {
                    wrongGuesses--;
                    System.out.printf("Neplatny vstup %d/5\n", wrongGuesses);
                    sc.reset();
                }
            }while (run);

        }
        System.out.println("Mas "+spravne+"/"+ pocet + " spravnych odpovedi");
    }
}
