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

        System.out.println(singable(song1, "F4", "C5"));  // Output: true
        System.out.println(singable(song1, "A4", "C5"));  // Output: false
        System.out.println(singable(song2, "B2", "C5"));  // Output: true
        System.out.println(singable(song2, "C3", "B4"));  // Output: false
        System.out.println(singable(song3, "B4", "B5"));  // Output: true
        System.out.println(singable(song3, "B4", "C5"));  // Output: false
        System.out.println(singable(song4, "D4", "A5"));  // Output: true
        System.out.println(singable(song4, "D4", "G5"));  // Output: false
        System.out.println(singable(song4, "D4", "C6"));  // Output: true
        System.out.println(singable(song4, "F4", "C6"));  // Output: false
        System.out.println(singable(song5, "D4", "E4"));  // Output: false
    }

    public static boolean singable(String[] song, String lowestNote, String highestNote) {
        int lowest = noteToValue(lowestNote);
        int highest = noteToValue(highestNote);

        for (String note : song) {
            int noteValue = noteToValue(note);
            if (noteValue < lowest || noteValue > highest) {
                return false;
            }
        }

        return true;
    }

    public static int noteToValue(String note) {
        char pitch = note.charAt(0);
        int octave = Character.getNumericValue(note.charAt(1));
        return (octave * 7) + "CDEFGAB".indexOf(pitch);
    }
}