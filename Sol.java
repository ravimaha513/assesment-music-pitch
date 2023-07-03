import java.util.*;

public class Sol {
    public static void main(String[] argv) {
        String[] teleporters1 = {"3,1", "4,2", "5,10"};
        String[] teleporters2 = {"5,10", "6,22", "39,40", "40,49", "47,29"};
        String[] teleporters3 = {"6,18", "36,26", "41,21", "49,55", "54,52",
                "71,58", "74,77", "78,76", "80,73", "92,85"};
        String[] teleporters4 = {"97,93", "99,81", "36,33", "92,59", "17,3",
                "82,75", "4,1", "84,79", "54,4", "88,53",
                "91,37", "60,57", "61,7", "62,51", "31,19"};

        System.out.println(destinations(teleporters1, 6, 0, 20));
        System.out.println(destinations(teleporters2, 6, 46, 100));
        System.out.println(destinations(teleporters2, 10, 0, 50));
        System.out.println(destinations(teleporters3, 10, 95, 100));
        System.out.println(destinations(teleporters3, 10, 70, 100));
        System.out.println(destinations(teleporters4, 6, 0, 100));
    }

    public static List<Integer> destinations(String[] teleporters, int die, int start, int end) {
        Set<Integer> possibleSquares = new HashSet<>();

        for (int roll = 1; roll <= die; roll++) {
            int newSquare = start + roll;
            if (newSquare > end) {
                newSquare = end;
            }

            for (String teleporter : teleporters) {
                String[] teleporterParts = teleporter.split(",");
                int teleporterFrom = Integer.parseInt(teleporterParts[0]);
                int teleporterTo = Integer.parseInt(teleporterParts[1]);
                if (newSquare == teleporterFrom) {
                    newSquare = teleporterTo;
                    break;
                }
            }

            possibleSquares.add(newSquare);
        }

        List<Integer> result = new ArrayList<>(possibleSquares);
        Collections.sort(result);
        return result;
    }
}
