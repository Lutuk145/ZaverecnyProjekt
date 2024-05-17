package classes.soustavy;

public class BinaryNum {
    private Node tail;

    private class Node{
        protected boolean value;
        protected Node next;
        public  Node(boolean value){
            this.value=value;
            next = null;
        }
        public void setNext(Node next){
            this.next = next;
        }
    }

    public BinaryNum(boolean value){
        tail = new Node(value);
    }

    public BinaryNum(byte value){
        if (value%2==1){
            tail = new Node(true);
        }else {
            tail = new Node(false);
        }
        value/=2;
        while (value!=0){
            Node temp = tail;
            while (temp.next!=null){
                temp = temp.next;
            }
            if (value%2==1){
                temp.next = new Node(true);
            }else {
               temp.next = new Node(false);
            }
            value/=2;
        }
    }
    public void add(boolean value){
        Node temp = tail;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.setNext(new Node(value));
    }

    @Override
    public String toString(){
        String output = "";
        Node temp = tail;
        do {
            output = temp.value?"1"+output:"0"+output;
            temp=temp.next;
        }while(temp!=null);
        return output;
    }

    public static void main(String[] args) {
        BinaryNum bn= new BinaryNum(true);
        System.out.println(bn.toString());
        bn.add(true);
        bn.add(false);
        bn.add(true);
        System.out.println(bn.toString());
        BinaryNum bn2 = new BinaryNum((byte) 64);
        System.out.print(bn2);
    }

}
