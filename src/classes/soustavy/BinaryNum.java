package classes.soustavy;


/**
 * Represents a binary number using a linked list of binary digits.
 */
public class BinaryNum {

    private Node tail;

    /**
     * Inner class representing a single binary digit (0 or 1).
     */
    private class Node {
        protected boolean value;
        protected Node next;

        /**
         * Constructs a new Node with the given binary value.
         *
         * @param value The binary value (true for 1, false for 0).
         */
        public Node(boolean value) {
            this.value = value;
            next = null;
        }
    }

    /**
     * Constructs a BinaryNum object from a decimal value.
     *
     * @param value The decimal value to convert to binary.
     */
    public BinaryNum(int value) {
        if (value % 2 == 1) {
            tail = new Node(true);
        } else {
            tail = new Node(false);
        }
        value /= 2;
        while (value != 0) {
            Node temp = tail;
            while (temp.next != null) {
                temp = temp.next;
            }
            if (value % 2 == 1) {
                temp.next = new Node(true);
            } else {
                temp.next = new Node(false);
            }
            value /= 2;
        }
    }

    /**
     * Returns the binary representation of the number as a string.
     *
     * @return The binary string representation.
     */
    @Override
    public String toString() {
        String output = "";
        Node temp = tail;
        do {
            output = temp.value ? "1" + output : "0" + output;
            temp = temp.next;
        } while (temp != null);
        return output;
    }
}
