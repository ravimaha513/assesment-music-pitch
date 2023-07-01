import java.util.*;

public class Singer {
    public static void main(String[] argv) {
        String[] song1 = { "F4", "B4", "C5" };
        String[] song2 = { "C3", "E3", "G3", "C4", "E4", "G4", "C5" };
        String[] song3 = { "B4", "F5", "B5" };
        String[] song4 = { "B4", "E4", "G4", "G4", "A4", "B4", "E4",
                "B4", "E4", "G4", "G4", "A4", "C5", "B4",
                "E5", "G4", "G4", "A4", "B4", "C5", "D5",
                "C5", "B4", "C5", "E5", "D5", "C5", "C5",
                "B4", "B4", "E5", "E4", "G4", "G4", "A4",
                "B4", "B4", "B4", "C5", "E5", "A5", "E5",
                "C5", "A4", "E5", "D5", "C5", "B4" };
        String[] song5 = { "F4" };

        System.out.println(singable(song1, "F4", "C5"));
        System.out.println(singable(song1, "A4", "C5"));
        System.out.println(singable(song2, "B2", "C5"));
        System.out.println(singable(song2, "C3", "B4"));   
        System.out.println(singable(song3, "B4", "B5"));   
        System.out.println(singable(song3, "B4", "C5"));
        System.out.println(singable(song4, "D4", "A5"));
        System.out.println(singable(song4, "D4", "G5"));
        System.out.println(singable(song4, "D4", "C6"));
        System.out.println(singable(song4, "F4", "C6"));
        System.out.println(singable(song5, "D4", "E4"));
    }

    public static boolean singable(String[] song, String lowest, String highest) {

        int lowestNoteIndex = Arrays.asList(pitchOrder).indexOf(lowest.charAt(0));
        int highestNoteIndex = Arrays.asList(pitchOrder).indexOf(highest.charAt(0));

        for (String note : song) {
            int notePitchIndex = Arrays.asList(pitchOrder).indexOf(note.charAt(0));
            int noteOctave = Character.getNumericValue(note.charAt(1));

            if (noteOctave < Character.getNumericValue(lowest.charAt(1)) ||
                    noteOctave > Character.getNumericValue(highest.charAt(1))) {
                return false;
            }

            if (noteOctave == Character.getNumericValue(lowest.charAt(1)) &&
                    notePitchIndex < lowestNoteIndex) {
                return false;
            }

            if (noteOctave == Character.getNumericValue(highest.charAt(1)) &&
                    notePitchIndex > highestNoteIndex) {
                        return false;
                    }
                }
        
                return true;
            }
        
            private static final char[] pitchOrder = {'C', 'D', 'E', 'F', 'G', 'A', 'B'};
        }
        