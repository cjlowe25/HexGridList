import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.util.Random;

public class HexGrid {

    private ArrayList<HexCodes> hexOptions = new ArrayList<>();

    private Hexagon center;
    private int radius = 0;

    private final List<Hexagon> allHexagons = new ArrayList<>();

    public void createHexOptions(){
        hexOptions.add(new HexCodes(0,0,0,0,0,0)); // 0
        hexOptions.add(new HexCodes(1,0,0,0,0,0)); // 1
        hexOptions.add(new HexCodes(0,1,0,0,0,0));
        hexOptions.add(new HexCodes(0,0,1,0,0,0));
        hexOptions.add(new HexCodes(0,0,0,1,0,0));
        hexOptions.add(new HexCodes(0,0,0,0,1,0));
        hexOptions.add(new HexCodes(0,0,0,0,0,1));
        hexOptions.add(new HexCodes(1,1,0,0,0,0)); // 2
        hexOptions.add(new HexCodes(0,1,1,0,0,0));
        hexOptions.add(new HexCodes(0,0,1,1,0,0));
        hexOptions.add(new HexCodes(0,0,0,1,1,0));
        hexOptions.add(new HexCodes(0,0,0,0,1,1));
        hexOptions.add(new HexCodes(1,0,0,0,0,1));
        hexOptions.add(new HexCodes(1,1,1,0,0,0)); // 3
        hexOptions.add(new HexCodes(0,1,1,1,0,0));
        hexOptions.add(new HexCodes(0,0,1,1,1,0));
        hexOptions.add(new HexCodes(0,0,0,1,1,1));
        hexOptions.add(new HexCodes(1,0,0,0,1,1));
        hexOptions.add(new HexCodes(1,1,0,0,0,1));
        hexOptions.add(new HexCodes(1,1,1,1,0,0)); // 4
        hexOptions.add(new HexCodes(0,1,1,1,1,0));
        hexOptions.add(new HexCodes(0,0,1,1,1,1));
        hexOptions.add(new HexCodes(1,0,0,1,1,1));
        hexOptions.add(new HexCodes(1,1,0,0,1,1));
        hexOptions.add(new HexCodes(1,1,1,0,0,1));
        hexOptions.add(new HexCodes(1,1,0,1,1,0));
        hexOptions.add(new HexCodes(0,1,1,0,1,1));
        hexOptions.add(new HexCodes(1,0,1,1,0,1));
        hexOptions.add(new HexCodes(0,1,1,1,1,1)); // 5
        hexOptions.add(new HexCodes(1,0,1,1,1,1));
        hexOptions.add(new HexCodes(1,1,0,1,1,1));
        hexOptions.add(new HexCodes(1,1,1,0,1,1));
        hexOptions.add(new HexCodes(1,1,1,1,0,1));
        hexOptions.add(new HexCodes(1,1,1,1,1,0));
        hexOptions.add(new HexCodes(1,1,1,1,1,1)); // 6
    }

    Random rand = new Random();

    private void change(Hexagon changedHex, int num1, int num2, int num3, int num4, int num5, int num6){
        changedHex.setN(num1);
        changedHex.setNe(num2);
        changedHex.setSe(num3);
        changedHex.setS(num4);
        changedHex.setSw(num5);
        changedHex.setNw(num6);
    }

    private void ranGivCon(int n, int ne, int se, int s, int sw, int nw){ // Random Given Condition
        boolean finished = false;
        Hexagon added = new Hexagon(0);
        ArrayList<HexCodes> removed =  new ArrayList<>();
        boolean north = true;
        boolean northeast = true;
        boolean southeast = true;
        boolean south = true;
        boolean southwest = true;
        boolean northwest = true;
        if (n == -1){
            north = false;
        }
        if (ne == -1) {
            northeast = false;
        }
        if (se == -1){
            southeast = false;
        }
        if (s == -1) {
            south = false;
        }
        if (sw == -1){
            southwest = false;
        }
        if (nw == -1) {
            northwest = false;
        }
        while (!finished) {
            HexCodes temp = hexOptions.get(rand.nextInt(hexOptions.size()));
            if ((!north || temp.getNum1() == n) && (!northeast || temp.getNum2() == ne) &&
                    (!southeast || temp.getNum3() == se) && (!south || temp.getNum4() == s) &&
                    (!southwest || temp.getNum5() == sw) && (!northwest || temp.getNum6() == nw)){
                change(added,temp.getNum1(), temp.getNum2(), temp.getNum3(), temp.getNum4(), temp.getNum5(), temp.getNum6());
                finished = true;
            }
            else{
                removed.add(temp);
                hexOptions.remove(temp);
            }
        }
        hexOptions.addAll(removed);
        removed.clear();
        allHexagons.add(added);
    }

    public void grow() { // The original grow function before I switched to manual

        if (radius == 0) {
            allHexagons.add(new Hexagon(0));
            center = new Hexagon(3);
            boolean finished = false;
            ArrayList<HexCodes> removed =  new ArrayList<>();
            while (!finished) {
                HexCodes temp = hexOptions.get(rand.nextInt(hexOptions.size()));
                if (temp.getColored() == 3){
                    change(center,temp.getNum1(), temp.getNum2(), temp.getNum3(), temp.getNum4(), temp.getNum5(), temp.getNum6());
                    finished = true;
                }
                else{
                    removed.add(temp);
                    hexOptions.remove(temp);
                }
            }
            hexOptions.addAll(removed);
            allHexagons.add(center);
            radius = 1;
            return;
        }
        List<Hexagon> newRing = new ArrayList<>();
        int count = 6 * radius;
        for (int i = 0; i < count; i++) {

        }
        for (int i = 0; i < count; i++) {
            Hexagon current = newRing.get(i);
            Hexagon next = newRing.get((i + 1) % count);
        }

        allHexagons.addAll(newRing);
        radius++;
    }

    private int checkAhead(int hex1, int hex2, int code){
        if (code == 1){ //ne, se, ne
            if (allHexagons.get(hex1).getNe() == 0){
                if (allHexagons.get(hex1).getSe() == 1){
                    if (allHexagons.get(hex2).getNe() == 0){
                        return 0;
                    }
                }
            }
        }
        else if (code == 2){ //se, s, se
            if (allHexagons.get(hex1).getSe() == 0){
                if (allHexagons.get(hex1).getS() == 1){
                    if (allHexagons.get(hex2).getSe() == 0){
                        return 0;
                    }
                }
            }
        }
        else if (code == 3){ //s, sw, s
            if (allHexagons.get(hex1).getS() == 0){
                if (allHexagons.get(hex1).getSw() == 1){
                    if (allHexagons.get(hex2).getS() == 0){
                        return 0;
                    }
                }
            }
        }
        else if (code == 4){ //sw, nw, sw
            if (allHexagons.get(hex1).getSw() == 0){
                if (allHexagons.get(hex1).getNw() == 1){
                    if (allHexagons.get(hex2).getSw() == 0){
                        return 0;
                    }
                }
            }
        }
        else if (code == 5){ //nw, n, nw
            if (allHexagons.get(hex1).getNw() == 0){
                if (allHexagons.get(hex1).getN() == 1){
                    if (allHexagons.get(hex2).getNw() == 0){
                        return 0;
                    }
                }
            }
        }
        else if (code == 6){ //n, ne, n
            if (allHexagons.get(hex1).getN() == 0){
                if (allHexagons.get(hex1).getNe() == 1){
                    if (allHexagons.get(hex2).getN() == 0){
                        return 0;
                    }
                }
            }
        }
        else if (code == 7){
            if (allHexagons.get(hex1).getNumber() == allHexagons.get(hex2).getNumber()){

            }
        }
        return -1;
    }



    public void growManual() { // Was struggling to make progress so I'm leaving very little to the computer
        if (radius == 0) {
            allHexagons.add(new Hexagon(0));
            center = new Hexagon(3);
            boolean finished = false;
            ArrayList<HexCodes> removed =  new ArrayList<>();
            while (!finished) {
                HexCodes temp = hexOptions.get(rand.nextInt(hexOptions.size()));
                if (temp.getColored() == 3){
                    change(center,temp.getNum1(), temp.getNum2(), temp.getNum3(), temp.getNum4(), temp.getNum5(), temp.getNum6());
                    finished = true;
                }
                else{
                    removed.add(temp);
                    hexOptions.remove(temp);
                }
            }
            hexOptions.addAll(removed);
            removed.clear();
            allHexagons.add(center);
            radius = 1;
            return;
        }
        else if (radius == 1){
            ranGivCon(-1,-1,-1,center.getNe(),center.getN(),-1); // 2
            ranGivCon(allHexagons.get(2).getSe(),-1,-1,-1,center.getSe(),center.getNe()); // 3
            ranGivCon(center.getSe(),allHexagons.get(3).getS(),-1,-1,-1,center.getS()); // 4
            ranGivCon(center.getSw(),center.getS(),allHexagons.get(4).getSw(),-1,-1,-1); // 5
            ranGivCon(-1,center.getNw(),center.getSe(),allHexagons.get(5).getNw(),-1,-1); // 6
            ranGivCon(-1,allHexagons.get(2).getNw(),center.getN(),center.getNw(),allHexagons.get(6).getN(),-1); // 7
        }
        else if (radius == 2){
            ranGivCon(-1,-1,checkAhead(2, 3, 1),allHexagons.get(2).getN(),-1,-1); // 8
            ranGivCon(allHexagons.get(8).getSe(), -1, -1, allHexagons.get(3).getNe(), allHexagons.get(3).getN(), allHexagons.get(2).getNe()); // 9
            ranGivCon(allHexagons.get(9).getSe(),-1,-1,checkAhead(3,4,2),allHexagons.get(3).getSe(),allHexagons.get(3).getNe()); // 10
            ranGivCon(allHexagons.get(3).getSe(),allHexagons.get(10).getS(),-1,-1,allHexagons.get(4).getSe(),allHexagons.get(3).getS()); // 11
            ranGivCon(allHexagons.get(4).getSw(),allHexagons.get(11).getS(),-1,-1,checkAhead(4,5,3) ,allHexagons.get(4).getS()); // 12
            ranGivCon(allHexagons.get(4).getSw(),allHexagons.get(4).getS(),allHexagons.get(12).getSw(),-1,-1,allHexagons.get(5).getS()); // 13
            ranGivCon(allHexagons.get(5).getSw(),allHexagons.get(5).getS(),allHexagons.get(13).getNw(),-1,-1,checkAhead(5,6,4)); // 14
            ranGivCon(allHexagons.get(6).getSw(),allHexagons.get(5).getNw(),allHexagons.get(14).getN(),allHexagons.get(14).getNw(),-1,-1); // 15
            ranGivCon(checkAhead(6,7,5),allHexagons.get(6).getNw(),allHexagons.get(15).getN(),allHexagons.get(15).getNw(),-1,-1); // 16
            ranGivCon(-1,allHexagons.get(7).getNw(),allHexagons.get(7).getSw(),allHexagons.get(16).getNe(),allHexagons.get(16).getN(),-1); // 17
            ranGivCon(-1,checkAhead(7,2,6),allHexagons.get(7).getN(),allHexagons.get(17).getNe(),allHexagons.get(17).getN(),-1); // 18
            ranGivCon(-1,allHexagons.get(8).getNw(),allHexagons.get(8).getSw(),allHexagons.get(2).getNw(),allHexagons.get(18).getSe(),allHexagons.get(18).getNe()); // 19
        }
        List<Hexagon> newRing = new ArrayList<>();
        int count = 6 * radius;
        allHexagons.addAll(newRing);
        radius++;
    }

    private void lookAhead(){

    }

    public int getRadius() {
        return radius;
    }

    public int getHexagonCount() {
        return allHexagons.size();
    }

    public double getVertexCount(){
        return 6 * (Math.pow(radius, 2));
    }

    private int ringBeginning(int currentHex) {
        int ring = (int)Math.ceil((Math.sqrt(12.0 * currentHex - 3) - 3) / 6.0);
        if (ring == 0) {
            return 1;
        }
        else {
            return 2 + 3 * (ring - 1) * ring;
        }
    }

    public void showHexagon(){
        for (int k = 1; k < allHexagons.size(); k++){
            System.out.println(allHexagons.get(k).getNumber() + "\n");
        }
    }

    public String displayCenter(){
        return "North Vertex: " + center.getN() + "\nNortheast Vertex: " + center.getNe() + "\nSoutheast Vertex: " + center.getSe() + "\nSouth Vertex: " + center.getS() + "\nSouthwest Vertex: " + center.getSw() + "\nNorthwest Vertex: " + center.getNw();
    }
    public String displayIndex(int index){
        return "North Vertex: " + allHexagons.get(index).getN() + "\nNortheast Vertex: " + allHexagons.get(index).getNe() + "\nSoutheast Vertex: " + allHexagons.get(index).getSe() + "\nSouth Vertex: " + allHexagons.get(index).getS() + "\nSouthwest Vertex: " + allHexagons.get(index).getSw() + "\nNorthwest Vertex: " + allHexagons.get(index).getNw();
    }
}