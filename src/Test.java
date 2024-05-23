import classes.soustavy.BinaryNum;
import classes.soustavy.HexNum;

public class Test {
    public static void main(String[] args) {
        BinaryNum  b = new BinaryNum((byte) 15);
        System.out.println(b.toString());
        HexNum h = new HexNum(b.toInt());
        System.out.println(h.toString());
        System.out.println(h.toInt());
    }
}
