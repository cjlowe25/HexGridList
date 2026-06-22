public class HexCodes {
    private int number1;
    private int number2;
    private int number3;
    private int number4;
    private int number5;
    private int number6;
    private int colored;
    public HexCodes(int number1, int number2, int number3, int number4, int number5, int number6) {
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
        this.number4 = number4;
        this.number5 = number5;
        this.number6 = number6;
        if (number1 == 1){
            colored++;
        }
        if (number2 == 1){
            colored++;
        }
        if (number3 == 1){
            colored++;
        }
        if (number4 == 1){
            colored++;
        }
        if (number5 == 1){
            colored++;
        }
        if (number6 == 1){
            colored++;
        }
    }

    public int getColored() {
        return colored;
    }

    public int getNum1() {
        return number1;
    }

    public int getNum2() {
        return number2;
    }

    public int getNum3() {
        return number3;
    }

    public int getNum4() {
        return number4;
    }

    public int getNum5() {
        return number5;
    }

    public int getNum6() {
        return number6;
    }
}
