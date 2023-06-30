import java.util.Arrays;
public class Srikanth_Kot {
    private static final String[] notesOrder = {"C", "D", "E", "F", "G", "A", "B"};
    public static void main(String[] args) {
        String[] song1 = {"F4", "B4", "C5"};
        String[] song2 = {"C3", "E3", "G3", "C4", "E4", "G4", "C5"};
        String[] song3 = {"B4", "F5", "B5" };
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

    public static boolean singable(String[] song, String lowest, String highest) {
        String[] notesOrder = {"C", "D", "E", "F", "G", "A", "B"};
        int lowestOctave = getOctave(lowest);
        int highestOctave = getOctave(highest);
        int lowestIndex = getNoteIndex(lowest);
        int highestIndex = getNoteIndex(highest);

        for (String note : song) {
            int noteOctave = getOctave(note);
            int noteIndex = getNoteIndex(note);

            if (noteOctave < lowestOctave || noteOctave > highestOctave)
                return false;
            if (noteOctave == lowestOctave && noteIndex < lowestIndex)
                return false;
            if (noteOctave == highestOctave && noteIndex > highestIndex)
                return false;
        }

        return true;
    }
    public static int getOctave(String note) {
        return Integer.parseInt(note.substring(note.length() - 1));
    }

    public static int getNoteIndex(String note) {
        String pitch = note.substring(0, note.length() - 1);
        return Arrays.asList(notesOrder).indexOf(pitch);
    }
}