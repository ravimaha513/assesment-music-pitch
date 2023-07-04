import java.util.*;

public class TeleportersGame {

    public static List<Integer> destinations(List<String> teleporters, int dieSides, int start, int lastSquare) {
        Map<Integer, Integer> teleporterMap = new HashMap<>();

        for (String teleporter : teleporters) {
            String[] parts = teleporter.split(",");
            int sourceSquare = Integer.parseInt(parts[0]);
            int destinationSquare = Integer.parseInt(parts[1]);
            teleporterMap.put(sourceSquare, destinationSquare);
        }

        Set<Integer> possibleDestinations = new HashSet<>();
        for (int diceRoll = 1; diceRoll <= dieSides; diceRoll++) {
            int currentPosition = start + diceRoll;
            if (currentPosition <= lastSquare) {
                if (teleporterMap.containsKey(currentPosition)) {
                    currentPosition = teleporterMap.get(currentPosition);
                }
                possibleDestinations.add(currentPosition);
            }
        }

        return new ArrayList<>(possibleDestinations);
    }

    public static void main(String[] args) {
        List<String> teleporters1 = List.of("3,1", "4,2", "5,10");
        List<String> teleporters2 = List.of("5,10", "6,22", "39,40", "40,49", "47,29");
        List<String> teleporters3 = List.of("6,18", "36,26", "41,21", "49,55", "54,52", "71,58", "74,77", "78,76", "80,73", "92,85");
        List<String> teleporters4 = List.of("97,93", "99,81", "36,33", "92,59", "17,3", "82,75", "4,1", "84,79", "54,4", "88,53", "91,37", "60,57", "61,7", "62,51", "31,19");
        List<Integer> result1 = destinations(teleporters1, 6, 0, 20);
        List<Integer> result2 = destinations(teleporters2, 6, 46, 100);//  => [48, 49, 50, 51, 52, 29]
        List<Integer> result3 = destinations(teleporters2, 10, 0, 50);//  => [1, 2, 3, 4, 7, 8, 9, 10, 22]
        List<Integer> result4 = destinations(teleporters3, 10, 95, 100);//  => [96, 97, 98, 99, 100]
        List<Integer> result5 = destinations(teleporters3, 10, 70, 100);//  => [72, 73, 75, 76, 77, 79, 58]
        List<Integer> result6 = destinations(teleporters4, 6, 0, 100);//  => [1, 2, 3, 5, 6]

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
    }
}
