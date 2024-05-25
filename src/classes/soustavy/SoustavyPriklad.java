package classes.soustavy;

import java.util.Random;

public class SoustavyPriklad {
    private int value;
    private int inputSoustava;
    private int outputSoustava;

    public SoustavyPriklad(int value, int inputSoustava,int outputSoustava){
        this.value = value;
        setInput(inputSoustava);
        setOutput(outputSoustava);

    }
    public int getValue(){
        return value;
    }
    public int getOutputSoustava(){
        return outputSoustava;
    }
    private void setInput(int inputSoustava){
        switch (inputSoustava){
            case 0->{
                this.inputSoustava = 2;
            }
            case 1->{
                this.inputSoustava = 10;
            }
            case 2->{
                this.inputSoustava = 16;
            }
            default -> throw new IllegalArgumentException("Typ soustavy je spatne");
        }
    }
    private void setOutput(int outputSoustava){
        switch (outputSoustava){
            case 0->{
                this.outputSoustava = 2;
            }
            case 1->{
                this.outputSoustava = 10;
            }
            case 2->{
                this.outputSoustava = 16;
            }
            default -> throw new IllegalArgumentException("Typ soustavy je spatne");
        }
    }
    public String toString(){
       switch (inputSoustava){
           case 2-> {
               return String.format("%s (%d) -> (%d)",new BinaryNum(value),inputSoustava,outputSoustava);
           }
           case 10->{
              return String.format("%d (%d) -> (%d)",value,inputSoustava,outputSoustava);
           }
           case 16->{
               return String.format("%s (%d) -> (%d)",new HexNum(value),inputSoustava,outputSoustava);
           }
           default -> {
               return "";
           }
       }
    }
}
