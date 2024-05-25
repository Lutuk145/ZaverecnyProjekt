package classes.soustavy;

import java.util.InputMismatchException;
import java.util.Scanner;

import static utils.CodingUtils.genSoustavyPriklad;
import static utils.CodingUtils.wrongGuesses;

public class SoustavyTest {
    private int pocet;
    public SoustavyTest(int pocet){
        this.pocet=pocet;
    }
    private SoustavyPriklad[] genPriklady(){
        SoustavyPriklad[] sp = new SoustavyPriklad[pocet];
        for (int i = 0; i<pocet;i++){
            sp[i]=genSoustavyPriklad();
        }
        return sp;
    }
    public void test(){
        int spravne = 0;
        SoustavyPriklad[] priklady = genPriklady();
        for (SoustavyPriklad priklad :priklady){
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
                    spravne+= Integer.parseInt(vysledek,priklad.getOutputSoustava())==priklad.getValue()?1:0;
                    run = false;
                } catch (InputMismatchException | NumberFormatException e) {
                    wrongGuesses--;
                    System.out.printf("Neplatny vstup %d/5\n", wrongGuesses);
                    scanner.reset();
                }
            }while(run);

        }
        System.out.println("Mas " + spravne + "/" + pocet + " spravnych odpovedi");
    }
}
