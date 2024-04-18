package utils;

import java.util.Random;

public class CodingUtils {
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
    public static String genCelyPriklad(int difficulty){
        Random rand = new Random();
        int num1 =0;
        int num2 =0;
        int znaminkor = rand.nextInt(4)+1;
        String znaminko ="";
        switch (znaminkor){
            case 1-> znaminko = "+";
            case 2-> znaminko = "-";
            case 3-> znaminko = "*";
            case 4-> znaminko = "/";
        }
        switch(difficulty){
            case 1->{
                if (znaminkor == 4){
                    num1 = rand.nextInt(21)-10;
                    num2 = num1* rand.nextInt(3)+1;
                }

                num1 = rand.nextInt(21)-10;
                num2 = rand.nextInt(21)-10;
            }
            case 2-> {
                if (znaminkor == 4){
                    num1 = rand.nextInt(201)-100;
                    num2 = num1* rand.nextInt(3)+1;
                }
                num1 = rand.nextInt(201) - 100;
                num2 = rand.nextInt(201) - 100;
            }
            case 3-> {
                if (znaminkor == 4){
                    num1 = rand.nextInt(2001)-1000;
                    num2 = num1* rand.nextInt(3)+1;
                    return num1 + " " + znaminko + " " + num2;
                }
                num1 = rand.nextInt(2001) - 1000;
                num2 = rand.nextInt(2001) - 1000;
            }
        }

    }
}
