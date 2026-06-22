import java.util.ArrayList;
import java.util.List;

public class Hexagon {
    private int number;
    private int n = -1;
    private int ne = -1;
    private int se = -1;
    private int s = -1;
    private int sw = -1;
    private int nw = -1;

    public Hexagon(int number) {
        this.number = number;
    }


    public int getNumber() {
        if (number == 0){
            if (n == 1){
                number++;
            }
            if (ne == 1){
                number++;
            }
            if (se == 1){
                number++;
            }
            if (s == 1){
                number++;
            }
            if (sw == 1){
                number++;
            }
            if (nw == 1){
                number++;
            }
        }
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getNe() {
        return ne;
    }

    public void setNe(int ne) {
        this.ne = ne;
    }

    public int getSe() {
        return se;
    }

    public void setSe(int se) {
        this.se = se;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getSw() {
        return sw;
    }

    public void setSw(int sw) {
        this.sw = sw;
    }

    public int getNw() {
        return nw;
    }

    public void setNw(int nw) {
        this.nw = nw;
    }
}
