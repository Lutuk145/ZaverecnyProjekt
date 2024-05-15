package classes;

import utils.CodingUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

import static utils.CodingUtils.wrongGuesses;

public class CelaCislaTest
{
    //@pa
    private int pocet;
    private int difficulty;

    public CelaCislaTest(int pocet, int difficulty) {
        this.pocet = pocet;
        this.difficulty = difficulty;
    }
    private String[] genPriklady(){
        String[] priklady = new String[pocet];
        for (int i = 0; i < pocet; i++) {
            priklady[i] = CodingUtils.genCelyPriklad(difficulty);
        }
        return priklady;
    }
    public void test(){

        int spravne = 0;
        String[] priklady = genPriklady();

        for (String priklad : priklady) {
            if (wrongGuesses <=0){
                System.out.println("Zadal jsi 5 neplatnych odpovedi, test ukoncen");
                System.exit(0);
            }
            System.out.print(priklad + " = ");
            Scanner scanner = new Scanner(System.in);
            try {
                int vysledek = scanner.nextInt();
                System.out.println(CodingUtils.vysledekCelychCisel(priklad) == vysledek);
                spravne += CodingUtils.vysledekCelychCisel(priklad) == vysledek ? 1 : 0;
            } catch (InputMismatchException e) {
                wrongGuesses--;
                System.out.printf("Neplatny vstup %d/5\n", wrongGuesses);
                scanner.next();
            }

        }


        System.out.println("Mas "+spravne+"/"+ pocet + " spravnych odpovedi");

    }

}
