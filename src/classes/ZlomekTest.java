package classes;

import utils.CodingUtils;

import static utils.CodingUtils.wrongGuesses;

public class ZlomekTest {
    private int pocet;
    private int diff;
    public ZlomekTest(int pocet, int diff) {
        this.pocet = pocet;
        this.diff = diff;
    }
    public void test(){
        int spravne = 0;
        String priklad = "";
        for (int i =0;i<pocet;i++){
            Object[] prikladList = CodingUtils.genZlomekPriklad(diff);
            priklad = String.format("%s %s %s =",prikladList);
            System.out.println(priklad);
            if (wrongGuesses <=0){
                System.out.println("Zadal jsi 5 neplatnych odpovedi, test ukoncen");
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        ZlomekTest test = new ZlomekTest(10,3);
        test.test();
    }
}
