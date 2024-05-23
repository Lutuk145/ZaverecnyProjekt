package classes.zlomky;

import java.util.Scanner;

import static utils.CodingUtils.genZlomekPriklad;
import static utils.CodingUtils.wrongGuesses;

public class ZlomekTest {
    private int pocet;
    private int diff;

    public ZlomekTest(int pocet, int diff) {
        this.pocet = pocet;
        this.diff = diff;
    }

    public static void main(String[] args) {
        ZlomekTest test = new ZlomekTest(10, 1);
        test.test();
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

            } catch (Exception e) {
                wrongGuesses--;
                System.out.printf("Neplatny vstup %d/5\n", wrongGuesses);
                sc.reset();
            }

        }
        System.out.println("Mas "+spravne+"/"+ pocet + " spravnych odpovedi");
    }
}
