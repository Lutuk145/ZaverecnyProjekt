package classes.soustavy;

public class HexNum {
    private enum HexNonNums {
        A,B,C,D,E,F
    }

    private class Node {
        protected byte value;
        protected Node next;
        public Node(byte value) {
            this.value = value;
            next = null;
        }

        public void setNext(byte value) {
            next = new Node(value);
        }

    }

    public static void main(String[] args) {
        System.out.println(HexNonNums.A);

    }
}
