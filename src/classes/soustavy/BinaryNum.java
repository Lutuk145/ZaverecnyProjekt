package classes.soustavy;


public class BinaryNum {
    private Node tail;

    private class Node{
        protected boolean value;
        protected Node next;

        /**
         *
         * @param value 1 or 0 stored in boolean form
         */
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
    public int toInt(){
        int output = 0;
        Node temp = tail;
        int i = 0;
        do {
            output+=temp.value?Math.pow(2,i):0;
            temp=temp.next;
            i++;
        }while(temp!=null);
        return output;
    }


}
