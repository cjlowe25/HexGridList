import java.util.ArrayList;
import java.util.List;

public class Hexagon {
    private int number;
    private int n = 0;
    private int ne = 0;
    private int se = 0;
    private int s = 0;
    private int sw = 0;
    private int nw = 0;

    public Hexagon(int number) {
        this.number = number;
    }


    public int getNumber() {
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
