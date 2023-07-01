public class Singer {
    public static void main(String[] args) {

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

        System.out.println(singable(song1, "F4", "C5")); // True
        System.out.println(singable(song1, "A4", "C5")); // False
        System.out.println(singable(song2, "B2", "C5")); // True
        System.out.println(singable(song2, "C3", "B4")); // False
        System.out.println(singable(song3, "B4", "B5")); // True
        System.out.println(singable(song3, "B4", "C5")); // False
        System.out.println(singable(song4, "D4", "A5")); // True
        System.out.println(singable(song4, "D4", "G5")); // False
        System.out.println(singable(song4, "D4", "C6")); // True
        System.out.println(singable(song4, "F4", "C6")); // False
        System.out.println(singable(song5, "D4", "E4")); // False
    }

    public static boolean singable(String[] song, String lowest, String highest) {
        // Convert the singer's lowest and highest notes to numerical representations
        int singerLowest = convertToNumber(lowest);
        int singerHighest = convertToNumber(highest);

        // Iterate through each note in the song
        for (String note : song) {
            // Convert the current song note to a numerical representation
            int currentNote = convertToNumber(note);

            // Check if the current note is outside the singer's range
            if (currentNote < singerLowest || currentNote > singerHighest) {
                return false; // Singer cannot perform the song
            }
        }

        return true; // All notes are within the singer's range
    }

    // Helper function to convert a note string to a numerical representation
    private static int convertToNumber(String note) {
        char pitch = note.charAt(0);
        int octave = Character.getNumericValue(note.charAt(1));

        return octave * 7 + getPitchValue(pitch);
    }

    // Helper function to get the numerical value of a pitch
    private static int getPitchValue(char pitch) {
        switch (pitch) {
            case 'C':
                return 0;
            case 'D':
                return 1;
            case 'E':
                return 2;
            case 'F':
                return 3;
            case 'G':
                return 4;
            case 'A':
                return 5;
            case 'B':
                return 6;
            default:
                return -1; // Invalid pitch
        }
    }
}
