package classes.soustavy;

public class HexNum {

    private Node tail;    private final byte A = 10;
    private final byte B = 11;
    private final byte C = 12;
    private final byte D = 13;
    private final byte E = 14;
    private final byte F = 15;

    public HexNum(int value){
        int nextVal = setTail(value);
        setValue(nextVal);
    }
    private class Node {
        protected int value;
        protected Node next;
        public Node(int value) {
            if (value<0){
                throw new IllegalArgumentException("Vstup musi by vetsi nez nula");
            }
            this.value = value;
            next = null;
        }
        public void setNext(int value) {
            next = new Node(value);
        }
        public Node getNext(){
            return next;
        }
        public String toString(){
            String output = "";
            if (value<9){
                output+=value;
            }else {
                switch (value){
                    case 10->output+="A";
                    case 11->output+="B";
                    case 12->output+="C";
                    case 13->output+="D";
                    case 14->output+="E";
                    case 15->output+="F";
                    default -> throw new RuntimeException("Couldnt load num");
                }
            }
            return output;
        }
    }
    public int toInt(){
        int output = 0;
        int i = 0;
        Node temp = tail;
         do {
             output+=Math.pow(16,i)*temp.value;
             temp=temp.next;
             i++;
         }while(temp!=null);
         return output;
    }
    public void setValue(int value){
        Node temp = tail;
        while (value>0) {
            temp.setNext(value % 16);
            value/=16;
            temp=temp.getNext();
        }

    }
    private int setTail(int value){
        tail = new Node(value%16);
        return value/16;
    }

    public String toString(){
        String output = "";
        Node temp = tail;
        do {
            output = temp.toString()+output;
            temp = temp.next;
        }while (temp!=null);
        return output;
    }
}
