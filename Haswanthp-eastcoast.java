public class Hashwanth{

    private static boolean isNoteWithinRange(String note, String lowestNote, String highestNote) {
        int noteValue = getNoteValue(note);
        int lowestNoteValue = getNoteValue(lowestNote);
        int highestNoteValue = getNoteValue(highestNote);
        return noteValue >= lowestNoteValue && noteValue <= highestNoteValue;
    }

    private static int getNoteValue(String note) {
        String pitch = note.substring(0, 1);
        int octave = Integer.parseInt(note.substring(1));
        return (octave * 7) + getPitchValue(pitch);
    }

    private static int getPitchValue(String pitch) {
        switch (pitch) {
            case "C": return 0;
            case "D": return 1;
            case "E": return 2;
            case "F": return 3;
            case "G": return 4;
            case "A": return 5;
            case "B": return 6;
            default: throw new IllegalArgumentException("Invalid pitch: " + pitch);
        }
    }

    public static boolean singable(String[] song, String lowestNote, String highestNote) {
        for (String note : song) {
            if (!isNoteWithinRange(note, lowestNote, highestNote)) {
                return false;
            }
        }
        return true;
    }

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
}