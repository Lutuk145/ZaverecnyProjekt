package classes.soustavy;

/**
 * Represents a system of equations problem .
 * This class encapsulates a value, input system base, and output system base.
 * It converts the value between different numeral systems (binary, decimal, hexadecimal).
 */
public class SoustavyPriklad {
    private int value; // The value to convert
    private int inputSoustava; // Input numeral system base (0: binary, 1: decimal, 2: hexadecimal)
    private int outputSoustava; // Output numeral system base (0: binary, 1: decimal, 2: hexadecimal)

    /**
     * Constructs a new SoustavyPriklad instance.
     *
     * @param value          The value to convert
     * @param inputSoustava  Input numeral system base (0: binary, 1: decimal, 2: hexadecimal)
     * @param outputSoustava Output numeral system base (0: binary, 1: decimal, 2: hexadecimal)
     */
    public SoustavyPriklad(int value, int inputSoustava, int outputSoustava) {
        this.value = value;
        setInput(inputSoustava);
        setOutput(outputSoustava);
    }

    /**
     * Gets the value to convert.
     *
     * @return The value
     */
    public int getValue() {
        return value;
    }

    /**
     * Gets the output numeral system base.
     *
     * @return The output numeral system base
     */
    public int getOutputSoustava() {
        return outputSoustava;
    }

    /**
     * Sets the input numeral system base.
     *
     * @param inputSoustava Input numeral system base (0: binary, 1: decimal, 2: hexadecimal)
     */
    private void setInput(int inputSoustava) {
        switch (inputSoustava) {
            case 0 -> this.inputSoustava = 2;
            case 1 -> this.inputSoustava = 10;
            case 2 -> this.inputSoustava = 16;
            default -> throw new IllegalArgumentException("Typ soustavy je spatne");
        }
    }

    /**
     * Sets the output numeral system base.
     *
     * @param outputSoustava Output numeral system base (0: binary, 1: decimal, 2: hexadecimal)
     */
    private void setOutput(int outputSoustava) {
        switch (outputSoustava) {
            case 0 -> this.outputSoustava = 2;
            case 1 -> this.outputSoustava = 10;
            case 2 -> this.outputSoustava = 16;
            default -> throw new IllegalArgumentException("Typ soustavy je spatne");
        }
    }

    /**
     * Returns a string representation of the converted value.
     *
     * @return The formatted value in the specified numeral system
     */
    @Override
    public String toString() {
        switch (inputSoustava) {
            case 2 -> {
                return String.format("%s (%d) -> (%d)", new BinaryNum(value), inputSoustava, outputSoustava);
            }
            case 10 -> {
                return String.format("%d (%d) -> (%d)", value, inputSoustava, outputSoustava);
            }
            case 16 -> {
                return String.format("%s (%d) -> (%d)", new HexNum(value), inputSoustava, outputSoustava);
            }
            default -> {
                return "";
            }
        }
    }
}