import classes.celaCisla.CelaCislaTest;
import classes.soustavy.SoustavyTest;
import classes.zlomky.ZlomekTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static utils.CodingUtils.*;

/**
 * @author Lukas Knejzlik
 * @implNote class for managing console input
 */
public class UserInterface {


    private Scanner sc = new Scanner(System.in);
    private boolean konec = false;

    /**
     * @implNote Runs the whole program
     */
    public void run(){
        System.out.println(getReadMe());
        do {
            sc.reset();
            System.out.println("Co byste chteli delat:\n\t1. Otestovat cela cisla\n\t2. Otestovat zlomky\n\t3. Otestovat prevody mezi soustavami\n\t4. Ukoncit program");
            System.out.print(">>> ");

            int choice = checkChoice(1,4);
            if (choice==-1){
                sc = new Scanner(System.in);
                continue;

            }
            switch (choice){
                case 1->testCelaCisla();
                case 2->testZlomky();
                case 3->testSoustavy();
                case 4->konec=true;
            }

        }while (!konec&&wrongGuesses>0);
    }

    /**
     * @implNote sets up the test for whole numbers
     */
    private void testCelaCisla(){
        sc.reset();
        System.out.println("Vyberte se obtiznost:\n\t1. Lehka\n\t2. Normalni\n\t3. Nemozna");
        System.out.print(">>> ");
        int choice=checkChoice(1,3);
        System.out.println("Zadejte pocet prikladu:");
        System.out.print(">>> ");
        int pocet = checkChoice(1,Integer.MAX_VALUE);
        if (pocet==-1|choice==-1){
            return;
        }
        new CelaCislaTest(pocet,choice).test();


    }

    /**
     * @implNote sets up the test for fractions
     */
    private void testZlomky(){
        sc.reset();
        System.out.println("Vyberte se obtiznost:\n\t1. Lehka\n\t2. Normalni\n\t3. Nemozna");
        System.out.print(">>> ");
        int choice=checkChoice(1,3);
        System.out.println("Zadejte pocet prikladu:");
        System.out.print(">>> ");
        int pocet = checkChoice(1,Integer.MAX_VALUE);
        if (pocet==-1|choice==-1){
            return;
        }
        new ZlomekTest(pocet,choice).test();
    }

    /**
     * @implNote sets up the test for "soustavy"
     */
    private void testSoustavy(){
        System.out.println("Zadejte pocet prikladu:");
        System.out.print(">>> ");
        int pocet = checkChoice(1,Integer.MAX_VALUE);
        if (pocet==-1){
            return;
        }
        new SoustavyTest(pocet).test();
    }

    /**
     * @implNote checks if the input num is correct
     * @param min min bound of the number
     * @param max max bound of the number
     * @return if -1 than its wrong else its right
     */
    private int checkChoice(int min,int max){

        try {
            int choice = sc.nextInt();
            if (choice > max|choice<min){
                wrongGuesses--;
                System.out.printf("Neplatny vstup %d/5\n", wrongGuesses);
                sc.reset();
                return -1;
            }
            return choice;
        }catch (NoSuchElementException e){
            wrongGuesses--;
            System.out.printf("Neplatny vstup %d/5\n", wrongGuesses);
            sc.reset();
            return -1;
        }
    }

    /**
     *
     * @return text from READ.ME file which has user documentation
     */
    private String getReadMe(){
        String output = "";
        try(BufferedReader br = new BufferedReader(new FileReader("src/READ.ME"))){
            String line;
            while ((line=br.readLine())!=null){
                output+=line+"\n";
            }
        }catch (IOException e){
            System.out.println("FILE COULDNT BE READ");
        }
        return output;
    }
}