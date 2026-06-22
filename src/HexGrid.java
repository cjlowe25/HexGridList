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

    public void connectedHexes(int vertex){
        int size = (int)Math.sqrt((double) vertex / 6) + 1;
        int difference = vertex - (int)(6 * Math.pow(size, 2) - 12 * size + 7);
        System.out.println("size: " + size);
        int a = (int)((1.0/3) * Math.pow(size, 3) + (1.0/2) * Math.pow(size, 2) - ((5.0/6) * size) + 1);
        int b = (int)(6 * Math.pow(size + 1, 2) - (12 * size + 1) + 7);
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        int splits = 0;
        if (size >= 3){
            splits = 3 + (2 * (size - 3));
            int code = -1;
            int aIncrease = 1 + ((splits - 3) / 2);
            int bIncrease = 2 + ((splits - 3) / 2);
            int modifier = difference / splits;
            int inner = difference % splits;
            int limit = b + 1;
            System.out.println("difference: " + difference);
            System.out.println("splits: " + splits);
            if ((inner - 3) % 2 == 1){
                code = 0; // a, b, b + 1
            }
            else if ((inner - 3) % 2 == 0){
                code = 1; // a, a + 1, b
            }
            else if ((inner == 2) || (inner == 1)){
                code = 0;
            }
            a += (aIncrease * modifier);
            b += (bIncrease * modifier);
            if (inner >= 3){
                a += 1 + ((inner - 3) / 2);
                b += 2 + ((inner - 3) / 2);
            }
            else if (inner == 2){
                b += 2;
            }
            else if (inner == 1){
                b += 1;
            }
            System.out.println("b before: " + b);
            b = b % limit + (3 * (size) * (size - 1) + 2);
            System.out.println("b additive: " + (3 * (size) * (size - 1) + 2));
            System.out.println("Code: " + code);
            System.out.println("a: " + a);
            System.out.println("b: " + b);
            System.out.println("inner: " + inner);

            if (code == 0){   // ab
                System.out.println();
            }
            else if (code == 1){ //   aa
                System.out.println();
            }
            else if (code == -1){   //in case of failure
                System.out.println("Something went VERY wrong");
            }
        }

    }
}