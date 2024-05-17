package classes.zlomky;

import java.util.InputMismatchException;

public class Zlomek {
    protected int citatel;
    protected int jmenovatel;

    public Zlomek(int citatel, int jmenovatel) {
        this.citatel = citatel;
        setJmenovatel(jmenovatel);
    }
    public static Zlomek parseZlomek(String s){
        if (!s.contains("/")){
            throw new InputMismatchException("Zlomek neobsahuje lomeno");
        }
        String[] split = s.split("/");
        return new Zlomek(Integer.parseInt(split[0]),Integer.parseInt(split[1]));
    }
    public void format(){
        if (jmenovatel<0){
            this.jmenovatel*=-1;
            this.citatel*=-1;
        }
        if (this.citatel>=0) {
            for (int i = this.citatel; i >= 2; i--) {
                if ((this.citatel % i) == 0 && (this.jmenovatel % i) == 0) {
                    this.citatel /= i;
                    this.jmenovatel /= i;
                    break;
                }
            }
        }else {
            for (int i = -this.citatel; i >=2; i--) {
                if ((this.citatel % i) == 0 && (this.jmenovatel % i) == 0) {
                    this.citatel /= i;
                    this.jmenovatel /= i;
                    break;
                }
            }
        }
    }
    public Zlomek(double decimal){
        if (Math.log10(decimal)>=0){
            double pow = Math.pow(10, Math.ceil(Math.log10(decimal)));
            citatel = (int) (decimal*pow);
            setJmenovatel((int) pow);
        }else {
            int count = 0;
            do {
                decimal*=10;
                count++;
            }while (decimal%1!=0);
            setJmenovatel((int) Math.pow(10, count));
            format();
        }
    }

    public int getCitatel() {
        return citatel;
    }

    public void setCitatel(int citatel) {
        this.citatel = citatel;
        format();
    }

    public int getJmenovatel() {
        return jmenovatel;
    }

    public void setJmenovatel(int jmenovatel) {
        this.jmenovatel = jmenovatel;
        format();
    }
    public double asDecimal(){
        return (double)citatel / jmenovatel;
    }
    public String toString() {
        return citatel + "/" + jmenovatel;
    }
}