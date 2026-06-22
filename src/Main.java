import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner temp = new Scanner(System.in);
        String message = "";
        HexGrid test = new HexGrid();
        test.createHexOptions();
        boolean chatting = true;
        while (chatting == true) {
            System.out.println("\nList Of Commands:\n-----------------------------------\nGrow\nRadius\nHexagon Count\nVertex Count\nConnect Hexes\nFind Hexes\nFirst Hex\nEnd");
            message = temp.nextLine();
            if (message.equalsIgnoreCase("Grow")) {
                test.grow();
            } else if (message.equalsIgnoreCase("Radius")) {
                System.out.println("\n");
                System.out.println(test.getRadius());
            } else if (message.equalsIgnoreCase("Hexagon Count")) {
                System.out.println("\n");
                System.out.println(test.getHexagonCount());
            } else if (message.equalsIgnoreCase("Vertex Count")) {
                System.out.println("\n");
                System.out.println((int) test.getVertexCount());
            } else if (message.equalsIgnoreCase("Connect Hexes")){
                System.out.println("\n");
//                test.connect();
            } else if (message.equalsIgnoreCase("End")){
                chatting = false;
            } else if (message.equalsIgnoreCase("First Hex")){
                System.out.println("\n");
                System.out.println(test.displayCenter());
            } else if (message.equalsIgnoreCase("Find Hexes")){
                int response = temp.nextInt();
                test.connectedHexes(response);
            }

        }
    }
}
