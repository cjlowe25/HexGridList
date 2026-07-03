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

//    public void grow() {
//
//        if (radius == 0) {
//            center = new Hexagon(3);
//            boolean finished = false;
//            ArrayList<HexCodes> removed =  new ArrayList<>();
//            while (!finished) {
//                HexCodes temp = hexOptions.get(rand.nextInt(hexOptions.size()));
//                if (temp.getColored() == 3){
//                    center.setN(temp.getNumber1());
//                    center.setNe(temp.getNumber2());
//                    center.setSe(temp.getNumber3());
//                    center.setS(temp.getNumber4());
//                    center.setSw(temp.getNumber5());
//                    center.setNw(temp.getNumber6());
//                    finished = true;
//                }
//                else{
//                    removed.add(temp);
//                    hexOptions.remove(temp);
//                }
//            }
//            hexOptions.addAll(removed);
//            allHexagons.add(center);
//            radius = 1;
//            return;
//        }
//        List<Hexagon> newRing = new ArrayList<>();
//        int count = 6 * radius;
//        for (int i = 0; i < count; i++) {
//            newRing.add(new Hexagon(0));
//        }
//        for (int i = 0; i < count; i++) {
//            Hexagon current = newRing.get(i);
//            Hexagon next = newRing.get((i + 1) % count);
//        }
//
//        allHexagons.addAll(newRing);
//        radius++;
//    }

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
//        int size = (int)Math.sqrt(((double) vertex) / 6) + 1; //WRONG
        int size = (int)(Math.sqrt((((double)vertex - 1) / 6)));
        System.out.println("Size: " + size);
        int difference = vertex - (int)(6 * Math.pow(size, 2) + 1);
        int a = 1; // Beginning 'a' of the chosen size
        int b = (int)(3 * Math.pow(size + 2, 2) - (3 * (size + 2)) + 1); // Beginning 'b' of the chosen size
        System.out.println("b: " + b);
        int splits; // The length of the pattern
        if (size > 0) { // size 1 is slightly different and needs it's own system, at least for the beginning
            a = (int) (3 * Math.pow(size, 2) - (3 * size) + 2);
        }


        splits = 1 + (2 * (size)); // Calculates the length of each pattern for that size
        int code = -1; // Default code to -1 in case it isn't reassigned and we'll know something went wrong
        int aIncrease = ((splits - 1) / 2);
        int bIncrease = 1 + ((splits - 1) / 2);
        int modifier = difference / splits;
        int inner = difference % splits;
        int blimit = b + 1;
        int alimit = (int)((3 * Math.pow(size + 1, 2) - (3 * (size + 1)) + 2));


        if (inner == 1){ // ((inner - 3) % 2 == 1)
            code = 1; // a, b, b + 1
        }
        else if ((inner - 1) % 2 == 0){
            code = 1; // a, b, b + 1
        }
        else if ((inner - 1) % 2 == 1){
            code = 0; // a, a + 1, b
        }
        else if (inner == 0){
            code = 1;
        }

        a += (aIncrease * modifier);
        b += (bIncrease * modifier);

        System.out.println("B before fix: " + b);
        if (b % blimit == 0){
            b = (int)(3 * (Math.pow(size, 2)) - 3 * size + 2);
            System.out.print("check1 hit");
        }
        else {
            b = (int)(b % blimit + (3 * (Math.pow(size + 1, 2)) - 3 * (size + 1) + 2)); //Makes sure b doesn't go to the next row
            System.out.println("check2 hit");
        }
        System.out.println("B after fix: " + b);


        if (inner > 1){ // If the last split is more than 1 in it
            if ((inner - 1) % 2 == 0) {
                a += ((inner - 1) / 2);
                b += 1 + ((inner - 1) / 2);
            }
            else if ((inner - 1) % 2 == 1){
                a += ((inner - 2) / 2);
                b += 2 + ((inner - 2) / 2);
            } // Basically just getting the exact numbers needed from the last
        }     // split since we can't use the whole split like the others
        else if (inner == 1){
            b += 1;
        }
        int nextB = -1;
        int nextA = -1;

        if ((b + 1) % blimit == 0){
            nextB = (int)(3 * Math.pow(size + 1, 2) - (3 * size) + 2);
        }
        else{
            nextB = b + 1;
        }

        System.out.println("a: " + a);
        System.out.println("b: " + b);

        System.out.println("a limit: " + alimit);
        System.out.println("b limit: " + blimit);

        if ((a + 1) % alimit == 0){
            nextA = (int)(3 * Math.pow(size, 2) - (3 * size) + 2);
        }
        else{
            nextA = a + 1;
        }

        if (code == 1){   // a, b, b + 1
            System.out.println("Inner Hexes: " + a + "\nOuter Hexes: " + b + ", " + nextB);
        }
        else if (code == 0){ // a, a + 1, b
            System.out.println("Inner Hexes: " + a + ", " + nextA + "\nOuter Hexes: " + b);
        }
        else if (code == -1){   //in case of failure
            System.out.println("Something went VERY wrong");
        }
    }
}