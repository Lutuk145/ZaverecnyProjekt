package classes.soustavy;

/**
 * Represents a hexadecimal number (HexNum).
 * This class converts an integer value to its hexadecimal representation.
 */
public class HexNum {

    private Node tail; // The tail node of the linked list representing the hexadecimal number

    /**
     * Constructs a new HexNum instance.
     *
     * @param value The integer value to convert to hexadecimal
     */
    public HexNum(int value) {
        int nextVal = setTail(value);
        setValue(nextVal);
    }

    /**
     * Represents a node in the linked list.
     */
    private class Node {
        protected int value;
        protected Node next;

        public Node(int value) {
            if (value < 0) {
                throw new IllegalArgumentException("Input must be greater than zero");
            }
            this.value = value;
            next = null;
        }

        public void setNext(int value) {
            next = new Node(value);
        }

        public Node getNext() {
            return next;
        }

        public String toString() {
            String output = "";
            if (value <= 9) {
                output += value;
            } else {
                switch (value) {
                    case 10 -> output += "A";
                    case 11 -> output += "B";
                    case 12 -> output += "C";
                    case 13 -> output += "D";
                    case 14 -> output += "E";
                    case 15 -> output += "F";
                    default -> {
                        throw new RuntimeException("Could not load number");
                    }
                }
            }
            return output;
        }
    }

    /**
     * Sets the value of the hexadecimal number.
     *
     * @param value The integer value to convert
     */
    public void setValue(int value) {
        Node temp = tail;
        while (value > 0) {
            temp.setNext(value % 16);
            value /= 16;
            temp = temp.getNext();
        }
    }

    /**
     * Sets the tail node of the linked list.
     *
     * @param value The integer value to convert
     * @return The remaining value after setting the tail
     */
    private int setTail(int value) {
        tail = new Node(value % 16);
        return value / 16;
    }

    /**
     * Returns the hexadecimal representation of the number.
     *
     * @return The hexadecimal string
     */
    @Override
    public String toString() {
        String output = "";
        Node temp = tail;
        do {
            output = temp.toString() + output;
            temp = temp.next;
        } while (temp != null);
        return output;
    }
}
