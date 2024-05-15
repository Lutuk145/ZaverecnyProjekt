package utils;

import classes.Zlomek;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CodingUtils {
    public static int wrongGuesses = 5;
    public static int vysledekCelychCisel(String priklad) {
        int num1 = Integer.parseInt(priklad.substring(0, priklad.indexOf(" ")));
        int num2 = Integer.parseInt(priklad.substring(priklad.lastIndexOf(" ") + 1));
        String znaminko = priklad.substring(priklad.indexOf(" ") + 1, priklad.lastIndexOf(" "));
        switch (znaminko) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }
    public static double vysledekZlomku(String priklad,double num1, double num2) {
        String znaminko = priklad.substring(priklad.indexOf(" ") + 1, priklad.lastIndexOf(" "));
        switch (znaminko) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }
    public static Object[] genZlomekPriklad(int dif){
            Object[] priklad = new Object[3];
            Random rand = new Random();
            String znaminko = "";
            int znaminkoRand = rand.nextInt(4) + 1;
            switch (znaminkoRand) {
                case 1 -> znaminko = "+";
                case 2 -> znaminko = "-";
                case 3 -> znaminko = "*";
                case 4 -> znaminko = "/";
            }
            priklad[1] = znaminko;
            switch (dif) {
                case 1 -> {
                    Zlomek z1 = new Zlomek(rand.nextInt(21) - 10, rand.nextInt(21) - 10);
                    Zlomek z2 = new Zlomek(rand.nextInt(21) - 10, rand.nextInt(21) - 10);
                    priklad[0] = z1;
                    priklad[2] = z2;

                }
                case 2 -> {
                    Zlomek z1 = new Zlomek(rand.nextInt(201) - 100, rand.nextInt(201) - 100);
                    Zlomek z2 = new Zlomek(rand.nextInt(201) - 100, rand.nextInt(201) - 100);
                    priklad[0] = z1;
                    priklad[2] = z2;
                }
                case 3 -> {
                    Zlomek z1 = new Zlomek(rand.nextInt(2001) - 1000, rand.nextInt(2001) - 1000);
                    Zlomek z2 = new Zlomek(rand.nextInt(2001) - 1000, rand.nextInt(2001) - 1000);
                    priklad[0] = z1;
                    priklad[2] = z2;
                }
            }
            return priklad;
    }

    public static String genCelyPriklad(int difficulty) {

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
        return num1 + " " + znaminko + " " + num2;
    }
}
