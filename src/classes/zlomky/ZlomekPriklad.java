package classes.zlomky;

public class ZlomekPriklad {
    private Zlomek z1;
    private Zlomek z2;
    private String znaminko;
    private Zlomek vysledek;

    public ZlomekPriklad(Zlomek z1, Zlomek z2, String znaminko) {
        this.z1 = z1;
        this.z2 = z2;
        this.znaminko = znaminko;
        calcVysledek();
    }

    public Zlomek getVysledek() {
        return vysledek;
    }

    private void calcVysledek() {
        switch (znaminko) {
            case "+" -> {
                vysledek = new Zlomek(z1.citatel * z2.jmenovatel + z2.citatel + z1.jmenovatel, z1.jmenovatel * z2.jmenovatel);
            }
            case "-" -> {
                vysledek = new Zlomek(z1.citatel * z2.jmenovatel - z2.citatel + z1.jmenovatel, z1.jmenovatel * z2.jmenovatel);
            }
            case "*" -> {
                vysledek = new Zlomek(z1.citatel * z2.citatel, z2.jmenovatel * z1.jmenovatel);
            }
            case "/" -> {
                vysledek = new Zlomek(z1.citatel * z2.jmenovatel, z2.citatel * z1.jmenovatel);
            }
        }
    }

    public Zlomek getZ1() {
        return z1;
    }

    public Zlomek getZ2() {
        return z2;
    }

    public String getZnaminko() {
        return znaminko;
    }
    @Override
    public String toString(){
        return String.format("%s %s %s =",z1,znaminko,z2);
    }
}
