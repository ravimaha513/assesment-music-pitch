import java.util.*;

public class Solution {
    public static void main(String[] argv) {
        String[] teleporters1 = {"3,1", "4,2", "5,10"};
        String[] teleporters2 = {"5,10", "6,22", "39,40", "40,49", "47,29"};
        String[] teleporters3 = {"6,18", "36,26", "41,21", "49,55", "54,52",
                "71,58", "74,77", "78,76", "80,73", "92,85"};
        String[] teleporters4 = {"97,93", "99,81", "36,33", "92,59", "17,3",
                "82,75", "4,1", "84,79", "54,4", "88,53",
                "91,37", "60,57", "61,7", "62,51", "31,19"};

        destinations(teleporters1, 6, 0, 20);
        System.out.println();

        destinations(teleporters2, 6, 46, 100);
        System.out.println();

        destinations(teleporters2, 10, 0, 50);
        System.out.println();

        destinations(teleporters3, 10, 95, 100);
        System.out.println();

        destinations(teleporters3, 10, 70, 100);
        System.out.println();

        destinations(teleporters4, 6, 0, 100);
    }

    public static void destinations(String[] teleporters, int die, int start, int end) {
        // Create a map to store the teleporter mappings
        Map<Integer, Integer> teleporterMap = new HashMap<>();
        for (String teleporter : teleporters) {
            String[] parts = teleporter.split(",");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            teleporterMap.put(from, to);
        }

        Stack<Integer> squareStack = new Stack<>();
        squareStack.push(start);

        Stack<List<Integer>> pathStack = new Stack<>();
        pathStack.push(new ArrayList<>(Collections.singletonList(start)));

        while (!squareStack.isEmpty()) {
            int currentSquare = squareStack.pop();
            List<Integer> currentPath = pathStack.pop();

            // If the current square is the end square, print the path
            if (currentSquare == end) {
                System.out.println(currentPath);
                continue;
            }

            // Roll the die and try all possible next squares
            for (int i = 1; i <= die; i++) {
                int nextSquare = currentSquare + i;

                // Check if the next square is a teleporter
                if (teleporterMap.containsKey(nextSquare)) {
                    nextSquare = teleporterMap.get(nextSquare);
                }

                // Check if the next square is within the board range
                if (nextSquare <= end) {
                    squareStack.push(nextSquare);

                    // Create a new path with the current path plus the next square
                    List<Integer> nextPath = new ArrayList<>(currentPath);
                    nextPath.add(nextSquare);
                    pathStack.push(nextPath);
                }
            }
        }
    }
}
