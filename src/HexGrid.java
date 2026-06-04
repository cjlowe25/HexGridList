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
        hexOptions.add(new HexCodes(0,0,0,0,0,1));
        hexOptions.add(new HexCodes(1,0,0,0,0,0));
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

    public void grow() {

        if (radius == 0) {
            center = new Hexagon(3);
            boolean finished = false;
            ArrayList<HexCodes> removed =  new ArrayList<>();
            while (!finished) {
                HexCodes temp = hexOptions.get(rand.nextInt(hexOptions.size()));
                if (temp.getColored() == 3){
                    center.setN(temp.getNumber1());
                    center.setNe(temp.getNumber2());
                    center.setSe(temp.getNumber3());
                    center.setS(temp.getNumber4());
                    center.setSw(temp.getNumber5());
                    center.setNw(temp.getNumber6());
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
            newRing.add(new Hexagon(0));
        }
        for (int i = 0; i < count; i++) {
            Hexagon current = newRing.get(i);
            Hexagon next = newRing.get((i + 1) % count);
        }

        allHexagons.addAll(newRing);
        radius++;
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

    public String displayCenter(){
        return "North Vertex: " + center.getN() + "\nNortheast Vertex: " + center.getNe() + "\nSoutheast Vertex: " + center.getSe() + "\nSouth Vertex: " + center.getS() + "\nSouthwest Vertex: " + center.getSw() + "\nNorthwest Vertex: " + center.getNw();
    }

//    public void connect(){
//        for (int i = 0; i < )
//    }
}