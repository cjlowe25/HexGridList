import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class HexGrid {

    private ArrayList<HexCodes> hexOptions = new ArrayList<>();

    private Hexagon center;
    private int radius = 0;

    private final List<Hexagon> allHexagons = new ArrayList<>();

    public void createHexOptions() {
        hexOptions.add(new HexCodes(0, 0, 0, 0, 0, 0)); // 0
        hexOptions.add(new HexCodes(1, 0, 0, 0, 0, 0)); // 1
        hexOptions.add(new HexCodes(0, 1, 0, 0, 0, 0));
        hexOptions.add(new HexCodes(0, 0, 1, 0, 0, 0));
        hexOptions.add(new HexCodes(0, 0, 0, 1, 0, 0));
        hexOptions.add(new HexCodes(0, 0, 0, 0, 1, 0));
        hexOptions.add(new HexCodes(0, 0, 0, 0, 0, 1));
        hexOptions.add(new HexCodes(1, 1, 0, 0, 0, 0)); // 2
        hexOptions.add(new HexCodes(0, 1, 1, 0, 0, 0));
        hexOptions.add(new HexCodes(0, 0, 1, 1, 0, 0));
        hexOptions.add(new HexCodes(0, 0, 0, 1, 1, 0));
        hexOptions.add(new HexCodes(0, 0, 0, 0, 1, 1));
        hexOptions.add(new HexCodes(0, 0, 0, 0, 0, 1));
        hexOptions.add(new HexCodes(1, 0, 0, 0, 0, 0));
        hexOptions.add(new HexCodes(1, 1, 1, 0, 0, 0)); // 3
        hexOptions.add(new HexCodes(0, 1, 1, 1, 0, 0));
        hexOptions.add(new HexCodes(0, 0, 1, 1, 1, 0));
        hexOptions.add(new HexCodes(0, 0, 0, 1, 1, 1));
        hexOptions.add(new HexCodes(1, 0, 0, 0, 1, 1));
        hexOptions.add(new HexCodes(1, 1, 0, 0, 0, 1));
        hexOptions.add(new HexCodes(1, 1, 1, 1, 0, 0)); // 4
        hexOptions.add(new HexCodes(0, 1, 1, 1, 1, 0));
        hexOptions.add(new HexCodes(0, 0, 1, 1, 1, 1));
        hexOptions.add(new HexCodes(1, 0, 0, 1, 1, 1));
        hexOptions.add(new HexCodes(1, 1, 0, 0, 1, 1));
        hexOptions.add(new HexCodes(1, 1, 1, 0, 0, 1));
        hexOptions.add(new HexCodes(1, 1, 0, 1, 1, 0));
        hexOptions.add(new HexCodes(0, 1, 1, 0, 1, 1));
        hexOptions.add(new HexCodes(1, 0, 1, 1, 0, 1));
        hexOptions.add(new HexCodes(0, 1, 1, 1, 1, 1)); // 5
        hexOptions.add(new HexCodes(1, 0, 1, 1, 1, 1));
        hexOptions.add(new HexCodes(1, 1, 0, 1, 1, 1));
        hexOptions.add(new HexCodes(1, 1, 1, 0, 1, 1));
        hexOptions.add(new HexCodes(1, 1, 1, 1, 0, 1));
        hexOptions.add(new HexCodes(1, 1, 1, 1, 1, 0));
        hexOptions.add(new HexCodes(1, 1, 1, 1, 1, 1)); // 6
    }


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

    public double getVertexCount() {
        return 6 * (Math.pow(radius, 2));
    }

    private int ringBeginning(int currentHex) {
        int ring = (int) Math.ceil((Math.sqrt(12.0 * currentHex - 3) - 3) / 6.0);
        if (ring == 0) {
            return 1;
        } else {
            return 2 + 3 * (ring - 1) * ring;
        }
    }

    public String displayCenter() {
        return "North Vertex: " + center.getN() + "\nNortheast Vertex: " + center.getNe() + "\nSoutheast Vertex: " + center.getSe() + "\nSouth Vertex: " + center.getS() + "\nSouthwest Vertex: " + center.getSw() + "\nNorthwest Vertex: " + center.getNw();
    }

//    public void connect(){
//        for (int i = 0; i < )
//    }

    public static ArrayList<Integer> connectedHexes(int vertex) {
        int size = (int) (Math.sqrt((((double) vertex - 1) / 6)));
        int difference = vertex - (int) (6 * Math.pow(size, 2) + 1);
        int a = 1; // Beginning 'a' of the chosen size
        int b = (int) (3 * Math.pow(size + 2, 2) - (3 * (size + 2)) + 1); // Beginning 'b' of the chosen size
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
        int bLimit = b + 1;
        int aLimit = (int) ((3 * Math.pow(size + 1, 2) - (3 * (size + 1)) + 2));


        if (inner == 1) { // ((inner - 3) % 2 == 1)
            code = 1; // a, b, b + 1
        } else if ((inner - 1) % 2 == 0) {
            code = 1; // a, b, b + 1
        } else if ((inner - 1) % 2 == 1) {
            code = 0; // a, a + 1, b
        } else if (inner == 0) {
            code = 1;
        }

        a += (aIncrease * modifier);
        b += (bIncrease * modifier);

        if (inner > 1) { // If the last split is more than 1 in it
            if ((inner - 1) % 2 == 0) {
                a += ((inner - 1) / 2);
                b += 1 + ((inner - 1) / 2);
            } else if ((inner - 1) % 2 == 1) {
                a += ((inner - 2) / 2);
                b += 2 + ((inner - 2) / 2);
            } // Basically just getting the exact numbers needed from the last
        }     // split since we can't use the whole split like the others
        else if (inner == 1) {
            b += 1;
        }
        if (b / bLimit >= 1) {
            b = (int) (b % (3 * (Math.pow(size + 2, 2)) - 3 * (size + 2) + 2) + ((3 * (Math.pow(size + 1, 2)) - 3 * (size + 1) + 2)));
        }
        int nextB;
        int nextA;

        if ((b + 1) % bLimit == 0) {
            nextB = (int) (3 * Math.pow(size + 1, 2) - (3 * (size + 1)) + 2);
        } else {
            nextB = b + 1;
        }

        if ((a + 1) % aLimit == 0) {
            nextA = (int) (3 * Math.pow(size, 2) - (3 * size) + 2);
        } else {
            nextA = a + 1;
        }
        ArrayList<Integer> hexes = new ArrayList<>();

        if (code == 1) {   // a, b, b + 1
            System.out.println("Inner Hexes: " + a + "\nOuter Hexes: " + b + ", " + nextB);
            hexes.add(a);
            hexes.add(b);
            hexes.add(nextB);
            return hexes;
        } else if (code == 0) { // a, a + 1, b
            System.out.println("Inner Hexes: " + a + ", " + nextA + "\nOuter Hexes: " + b);
            hexes.add(a);
            hexes.add(nextA);
            hexes.add(b);
            return hexes;
        } else if (code == -1) {   //in case of failure
            System.out.println("Something went VERY wrong");
            return null;
        } else {
            return null;
        }
    }


//    public void connectedVertices(int hex){ // Abandoned
//        int size = 1;
//        int a = 1;
//        int b = -1;
//        if (size == 2){
//            a = 7;
//        }
//        else if (size == 3){
//            a = 25;
//        }
//        else if (size > 3){
//            a = a + (6 + (2 * (size - 2)) * 6);
//        }
//    }

    private static int fixHex(int hex, int upperLimit, int lowerLimit, int change) {
        int size = (int) ((3 + Math.sqrt(12 * hex - 15)) / 6);
        if ((hex + change < upperLimit) && (hex + change > lowerLimit)) {
            return hex + change;
        } else if (hex + change >= upperLimit) {
            hex = (int) (((hex + change) % upperLimit) + (3 * Math.pow(size, 2) - (3 * size) + 2));
            return hex;
        } else if (hex + change <= lowerLimit) {
            hex = (int) (3 * Math.pow(size + 1, 2) - (3 * (size + 1)) + 1);
            return hex;
        } else {
            System.out.println("Everything is very wrong");
            return -1;
        }
    }

    public static ArrayList<Integer> adjacentHexes(int hex) {
        int size = (int) ((3 + Math.sqrt(12 * hex - 15)) / 6);
        int c = (int) (3 * Math.pow(size + 2, 2) - (3 * (size + 2)) + 1); // Last hex of next size up
        int b = (int) (3 * Math.pow(size, 2) - (3 * size) + 2); // Beginning hex of current size
        int a = (int) (3 * Math.pow(size - 1, 2) - (3 * (size - 1)) + 2); // Beginning hex of one size down
        int aLimit = b;
        int bLimit = (int) (3 * Math.pow(size + 1, 2) - (3 * (size + 1)) + 2);
        int cLimit = (int) (3 * Math.pow(size + 2, 2) - (3 * (size + 2)) + 2);
        int difference = hex - b;
        if (size == 1) { // Special case for setting 'a' since size 1 doesn't work for this system otherwise
            a = 1;
        } else if (size == 0) { // Special case since size 0 doesn't have an inner or an outer, depends on how you look at it.
            ArrayList<Integer> one = new ArrayList<>();
            for (int i = 2; i < 8; i++) {
                one.add(i);
            }
            return one;
        }
        int inner = difference % size; // Size is the same as the length of the pattern
        a += (size - 1) * (difference / size); // Increase a by pattern length - 1 times the amount of times the pattern appears
        c += (2 * (difference / size)) + (difference / size) * (size - 1); // 'c' is increased by 2 times # of pattern appearances
                                                                    // then add # of pattern appearances times the size - 1
        // Inner calculations                                       // since every entry after the first in the pattern increases 'c' by 1 instead of 2
        if (inner > 0) { // if inner doesn't exist, no changes needed
            a += (inner - 1); // every point after the first one increments 'a' by 1
            c += (2 + (inner - 1));
        }
        if (c / cLimit > 0) {
            c = (int) (c % cLimit + (3 * Math.pow(size + 1, 2) - (3 * (size + 1)) + 2)); // wraps the 'c' around
        }
        if ((size == 1) || ((size > 1) && (inner == 0))) { // Special case needed for size == 1,
            ArrayList<Integer> sent = new ArrayList<>(); // overall just determines what pattern is needed to return
            sent.add(a);
            sent.add(c);
            sent.add(fixHex(c, cLimit, (int) (3 * Math.pow(size + 1, 2) - (3 * (size + 1)) + 2), 1)); // c + 1
            sent.add(fixHex(c, cLimit, (int) (3 * Math.pow(size + 1, 2) - (3 * (size + 1)) + 2), 2)); // c + 1
            sent.add(fixHex(hex, (int) (3 * Math.pow(size + 1, 2) - (3 * (size + 1)) + 2), (int) (3 * Math.pow(size, 2) - (3 * (size)) + 1), -1)); // hex - 1
            sent.add(fixHex(hex, (int) (3 * Math.pow(size + 1, 2) - (3 * (size + 1)) + 2), (int) (3 * Math.pow(size, 2) - (3 * (size)) + 1), 1)); // hex + 1
            return sent;
        } else if (inner > 0) {
            ArrayList<Integer> sent = new ArrayList<>();
            sent.add(a);
            sent.add(fixHex(a, b, a - 1, 1)); // a + 1
            sent.add(c);
            sent.add(fixHex(c, cLimit, (int) (3 * Math.pow(size + 1, 2) - (3 * (size + 1)) + 2), 1)); // c + 1
            sent.add(fixHex(hex, (int) (3 * Math.pow(size + 1, 2) - (3 * (size + 1)) + 2), (int) (3 * Math.pow(size, 2) - (3 * (size)) + 1), -1)); // hex - 1
            sent.add(fixHex(hex, (int) (3 * Math.pow(size + 1, 2) - (3 * (size + 1)) + 2), (int) (3 * Math.pow(size, 2) - (3 * (size)) + 1), 1)); // hex + 1
            return sent;
        } else { // Just in case something is horribly wrong and if neither if statement is true.
            System.out.println("SOMETHING IS WRONG");
            return null;
        }
    }

  }