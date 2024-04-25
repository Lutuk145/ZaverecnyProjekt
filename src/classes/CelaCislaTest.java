package classes;

import utils.CodingUtils;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        for (String priklad : priklady) {
            System.out.print(priklad+" = ");
            int vysledek = scanner.nextInt();
            System.out.println(CodingUtils.vysledekCelychCisel(priklad) == vysledek);
        }
        System.out.println("Mas "+spravne+"/"+ pocet + " spravnych odpovedi");
    }

}
