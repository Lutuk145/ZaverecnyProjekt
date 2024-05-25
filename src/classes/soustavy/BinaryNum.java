package classes.soustavy;


public class BinaryNum{
    private Node tail;

    private class Node{
        protected boolean value;
        protected Node next;
        public  Node(boolean value){
            this.value=value;
            next = null;
        }
    }

    public BinaryNum(int value){
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
}
