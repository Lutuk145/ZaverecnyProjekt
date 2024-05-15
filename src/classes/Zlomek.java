package classes;

public class Zlomek {
    private int citatel;
    private int jmenovatel;

    public Zlomek(int citatel, int jmenovatel) {
        this.citatel = citatel;
        setJmenovatel(jmenovatel);
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
        }
    }

    public int getCitatel() {
        return citatel;
    }

    public void setCitatel(int citatel) {
        this.citatel = citatel;
        for (int i = 2; i <= this.citatel; i++) {
            if (this.citatel%i==0 && jmenovatel%i==0){
                this.citatel/=i;
                jmenovatel/=i;
                i--;
            }
        }
        if (jmenovatel<0){
            jmenovatel*=-1;
            this.citatel*=-1;
        }
    }

    public int getJmenovatel() {
        return jmenovatel;
    }

    public void setJmenovatel(int jmenovatel) {
        this.jmenovatel = jmenovatel;
        for (int i = 2; i <= citatel; i++) {
            if (citatel%i==0 && this.jmenovatel%i==0){

                citatel/=i;
                this.jmenovatel/=i;
                i=2;
            }
        }
        if (this.jmenovatel<0){
            this.jmenovatel=jmenovatel*-1;
            citatel*=-1;
        }
    }
    public double asDecimal(){
        return (double)citatel / jmenovatel;
    }
    public String toString() {
        return citatel + "/" + jmenovatel;
    }
}
