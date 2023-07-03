import java.util.Arrays;
import java.util.List;

public class saisathiraju_Mallipudi_East_Coast {
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
        List<String> notes = Arrays.asList("C", "D", "E", "F", "G", "A", "B");
        int lowestOctave = Integer.parseInt(lowestNote.substring(1));
        int highestOctave = Integer.parseInt(highestNote.substring(1));

        for (String note : song) {
            int octave = Integer.parseInt(note.substring(1));
            String pitch = note.substring(0, 1);
            int lowestIndex = notes.indexOf(lowestNote.substring(0, 1));
            int highestIndex = notes.indexOf(highestNote.substring(0, 1));
            int noteIndex = notes.indexOf(pitch);

            if (octave < lowestOctave || octave > highestOctave) {
                return false;
            }

            if (octave == lowestOctave && noteIndex < lowestIndex) {
                return false;
            }

            if (octave == highestOctave && noteIndex > highestIndex) {
                return false;
            }
        }

        return true;
    }
}
