import java.util.HashMap;

public class Singer {
    public static boolean singable(String[] song, String lowestNote, String highestNote) {
        // Convert lowest and highest notes to numerical representation
        HashMap<Character, Integer> pitchValues = new HashMap<>();
        pitchValues.put('C', 0);
        pitchValues.put('D', 1);
        pitchValues.put('E', 2);
        pitchValues.put('F', 3);
        pitchValues.put('G', 4);
        pitchValues.put('A', 5);
        pitchValues.put('B', 6);

        char lowestPitch = lowestNote.charAt(0);
        int lowestOctave = Character.getNumericValue(lowestNote.charAt(1));
        char highestPitch = highestNote.charAt(0);
        int highestOctave = Character.getNumericValue(highestNote.charAt(1));
        int lowestNum = lowestOctave * 7 + pitchValues.get(lowestPitch);
        int highestNum = highestOctave * 7 + pitchValues.get(highestPitch);

        // Check each note in the song against the singer's range
        for (String note : song) {
            char pitch = note.charAt(0);
            int octave = Character.getNumericValue(note.charAt(1));
            int noteNum = octave * 7 + pitchValues.get(pitch);
            if (noteNum < lowestNum || noteNum > highestNum) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] song1 = {"F4", "B4", "C5"};
        System.out.println(singable(song1, "F4", "C5"));  // true
        System.out.println(singable(song1, "A4", "C5"));  // false

        String[] song2 = {"C3", "E3", "G3", "C4", "E4", "G4", "C5"};
        System.out.println(singable(song2, "B2", "C5"));  // true
        System.out.println(singable(song2, "C3", "B4"));  // false

        String[] song3 = {"B4", "F5", "B5"};
        System.out.println(singable(song3, "B4", "B5"));  // true
        System.out.println(singable(song3, "B4", "C5"));  // false
        String[] song4 = {"B4", "E4", "G4", "G4", "A4", "B4", "E4",
                "B4", "E4", "G4", "G4", "A4", "C5", "B4",
                "E5", "G4", "G4", "A4", "B4", "C5", "D5",
                "C5", "B4", "C5", "E5", "D5", "C5", "C5",
                "B4", "B4", "E5", "E4", "G4", "G4", "A4",
                "B4", "B4", "B4", "C5", "E5", "A5", "E5",
                "C5", "A4", "E5", "D5", "C5", "B4"};

        System.out.println(singable(song4, "D4", "A5"));  // true
        System.out.println(singable(song4, "D4", "G5"));  // false
        System.out.println(singable(song4, "D4", "C6"));  // true
        System.out.println(singable(song4, "F4", "C6"));  // false

        String[] song5 = {"F4"};

        System.out.println(singable(song5, "D4", "E4"));  // false
    }
}
