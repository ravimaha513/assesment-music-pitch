import java.util.Map;

public class RevanthT_EastCoast {

    public static boolean isValidNote(String note, String lowestNote, String highestNote) {
        Map<Character, Integer> noteOrder = Map.of('C', 1, 'D', 2, 'E', 3, 'F', 4,
                'G', 5, 'A', 6, 'B', 7);
        Integer lowestOctave = 1;
        Integer highestOctave = 7;

        if (note.length() != 2 || Character.getNumericValue(note.charAt(1)) < lowestOctave
                || Character.getNumericValue(note.charAt(1)) > highestOctave) {
            return false;
        }

        if (Character.getNumericValue(note.charAt(1)) > Character.getNumericValue(highestNote.charAt(1))) {
            // higher octave
            return false;
        } else {
            if (Character.getNumericValue(note.charAt(1)) == Character.getNumericValue(lowestNote.charAt(1))) {
                // note's octave equals lowest octave => should be lower pitch
                if (noteOrder.get(note.charAt(0)) < noteOrder.get(lowestNote.charAt(0))) {
                    return false;
                }
            }
            if (Character.getNumericValue(note.charAt(1)) == Character.getNumericValue(highestNote.charAt(1))) {
                // note's octave equals hishest octave => should be lower pitch
                if (noteOrder.get(note.charAt(0)) > noteOrder.get(highestNote.charAt(0))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean singable(String[] song, String lowestNote, String highestNote) {
        /*
         * This method checks whether each note in the song is between the
         * lowestNote and highestNote
         */
        for (int i = 0; i < song.length; ++i) {
            if (!isValidNote(song[i], lowestNote, highestNote)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
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

        System.out.println(singable(song1, "F4", "C5") + " vs True");
        System.out.println(singable(song1, "A4", "C5") + " vs False");
        System.out.println(singable(song2, "B2", "C5") + " vs True");
        System.out.println(singable(song2, "C3", "B4") + " vs False");
        System.out.println(singable(song3, "B4", "B5") + " vs True");
        System.out.println(singable(song3, "B4", "C5") + " vs False");
        System.out.println(singable(song4, "D4", "A5") + " vs True");
        System.out.println(singable(song4, "D4", "G5") + " vs False");
        System.out.println(singable(song4, "D4", "C6") + " vs True");
        System.out.println(singable(song4, "F4", "C6") + " vs False");
        System.out.println(singable(song5, "D4", "E4") + " vs False");

    }

}