package utils;

import classes.soustavy.SoustavyPriklad;
import classes.zlomky.Zlomek;
import classes.celaCisla.CelaCislaPriklad;
import classes.zlomky.ZlomekPriklad;

import java.util.Random;

public class CodingUtils {
    /**
     * @implNote wrong Guess is left number of attempts
     */
    public static int wrongGuesses = 5;

    /**
     * @implNote generates random fraction equation
     * @param dif difficulty of the equation (1 = -10 - 10 2 = -100 - 100 3 = -1000 - 1000)
     * @return returns random fraction equation
     */
    public static ZlomekPriklad genZlomekPriklad(int dif){
            Random rand = new Random();
            String znaminko = "";
            int znaminkoRand = rand.nextInt(4) + 1;
            Zlomek z1 = null;
            Zlomek z2 = null;
            switch (znaminkoRand) {
                case 1 -> znaminko = "+";
                case 2 -> znaminko = "-";
                case 3 -> znaminko = "*";
                case 4 -> znaminko = "/";
            }
            switch (dif) {
                case 1 -> {
                    z1 = new Zlomek(rand.nextInt(21) - 10, rand.nextInt(21) - 10);
                    z2 = new Zlomek(rand.nextInt(21) - 10, rand.nextInt(21) - 10);

                }
                case 2 -> {
                    z1 = new Zlomek(rand.nextInt(201) - 100, rand.nextInt(201) - 100);
                    z2 = new Zlomek(rand.nextInt(201) - 100, rand.nextInt(201) - 100);
                }
                case 3 -> {
                    z1 = new Zlomek(rand.nextInt(2001) - 1000, rand.nextInt(2001) - 1000);
                    z2 = new Zlomek(rand.nextInt(2001) - 1000, rand.nextInt(2001) - 1000);
                }
            }
            return new ZlomekPriklad(z1,z2,znaminko);
    }

    /**
     * @implNote generates random whole number equation
     * @param difficulty difficulty of the equation 1 = -10 - 10 2 = -100 - 100 3 = -1000 - 1000
     * @return returns a random whole number equation
     */
    public static CelaCislaPriklad genCelyPriklad(int difficulty) {
        Random rand = new Random();
        int num1 = 0;
        int num2 = 0;
        int znaminkoRand = rand.nextInt(4) + 1;
        String znaminko = "";

        switch (difficulty) {
            case 1 -> {
                if (znaminkoRand == 4) {
                    num2 = rand.nextInt(21) - 10;
                    num1 = num2 * (rand.nextInt(3) + 1);
                } else {
                    num1 = rand.nextInt(21) - 10;
                    num2 = rand.nextInt(21) - 10;
                }
            }
            case 2 -> {
                if (znaminkoRand == 4) {
                    num2 = rand.nextInt(201) - 100;
                    num1 = num2 * rand.nextInt(3) + 1;
                } else {
                    num1 = rand.nextInt(201) - 100;
                    num2 = rand.nextInt(201) - 100;
                }
            }
            case 3 -> {
                if (znaminkoRand == 4) {
                    num2 = rand.nextInt(2001) - 1000;
                    num1 = num2 * (rand.nextInt(3) + 1);
                } else {
                    num1 = rand.nextInt(2001) - 1000;
                    num2 = rand.nextInt(2001) - 1000;
                }
            }
        }
        if (znaminkoRand ==4||znaminkoRand==3){
            if (num2 < 0 && num1 < 0) {
                num2 *= (-1);
                num1 *= -1;
            }
        }
        if (num2 < 0) {
            if (znaminkoRand == 1) {
                znaminkoRand = 2;
                num2 = num2 * (-1);
            } else if (znaminkoRand == 2) {
                znaminkoRand = 1;
                num2 = num2 * (-1);
            }
        }
        switch (znaminkoRand) {
            case 1 -> znaminko = "+";
            case 2 -> znaminko = "-";
            case 3 -> znaminko = "*";
            case 4 -> znaminko = "/";
        }
        return new CelaCislaPriklad(num1,num2,znaminko);
    }

    /**
     * @implNote
     * @return returns random soustava priklad
     */
    public static SoustavyPriklad genSoustavyPriklad(){
        Random rand = new Random();
        int value = rand.nextInt(100_000)+1;
        int beginingValue= rand.nextInt(3);
        int convertValue;
        do{
            convertValue = rand.nextInt(3);
        }while (beginingValue==convertValue);
        return new SoustavyPriklad(value,beginingValue,convertValue);
    }
}
