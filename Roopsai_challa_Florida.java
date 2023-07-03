import java.util.*;

public class Solution {
    public static void main(String[] argv) {
        String[] song1 = {"F4", "B4", "C5"};
        String[] song2 = {"C3", "E3", "G3", "C4", "E4", "G4", "C5"};
        String[] song3 = {"B4", "F5", "B5"};
        String[] song4 = {"B4", "E4", "G4", "G4", "A4", "B4", "E4",
                "B4", "E4", "G4", "G4", "A4", "C5", "B4",
                "E5", "G4", "G4", "A4", "B4", "C5", "D5",
                "C5", "B4", "C5", "E5", "D5", "C5", "C5",
                "B4", "B4", "E5", "E4", "G4", "G4", "A4",
                "B4", "B4", "B4", "C5", "E5", "A5", "E5",
                "C5", "A4", "E5", "D5", "C5", "B4"};
        String[] song5 = {"F4"};

        System.out.println(singable(song1, "F4", "C5"));  // True
        System.out.println(singable(song1, "A4", "C5"));  // False
        System.out.println(singable(song2, "B2", "C5"));  // True
        System.out.println(singable(song2, "C3", "B4"));  // False
        System.out.println(singable(song3, "B4", "B5"));  // True
        System.out.println(singable(song3, "B4", "C5"));  // False
        System.out.println(singable(song4, "D4", "A5"));  // True
        System.out.println(singable(song4, "D4", "G5"));  // False
        System.out.println(singable(song4, "D4", "C6"));  // True
        System.out.println(singable(song4, "F4", "C6"));  // False
        System.out.println(singable(song5, "D4", "E4"));  // False
    }

    public static boolean singable(String[] song, String lowestNote, String highestNote) {
        int lowest = getNoteValue(lowestNote);
        int highest = getNoteValue(highestNote);
        
        for (String note : song) {
            int noteValue = getNoteValue(note);
            if (noteValue < lowest || noteValue > highest) {
                return false;
            }
        }

        return true;
    }

    public static int getNoteValue(String note) {
        
        Map<Character, Integer> pitchMap = new HashMap<>();
        pitchMap.put('C', 0);
        pitchMap.put('D', 1);
        pitchMap.put('E', 2);
        pitchMap.put('F', 3);
        pitchMap.put('G', 4);
        pitchMap.put('A', 5);
        pitchMap.put('B', 6);
          
        char pitch = note.charAt(0);
        int octave = Integer.parseInt(note.substring(1));
        int pitchValue = pitchMap.get(pitch);

        return octave  + pitchValue;
    }
}
