import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String[] song1 = {"F4", "B4", "C5"};
        String[] song2 = {"C3", "E3", "G3", "C4", "E4", "G4", "C5"};
        String[] song3 = {"B4", "F5", "B5"};
        String[] song4 = {"B4", "E4", "G4", "G4", "A4", "B4", "E4", "B4", "E4", "G4", "G4", "A4", "C5", "B4", "E5", "G4", "G4", "A4", "B4", "C5", "D5", "C5", "B4", "C5", "E5", "D5", "C5", "C5", "B4", "B4", "E5", "E4", "G4", "G4", "A4", "B4", "B4", "B4", "C5", "E5", "A5", "E5", "C5", "A4", "E5", "D5", "C5", "B4"};
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

    private static boolean singable(String[] songNotes, String lowerNote, String higherNote) {
        String[] pitch = {"C", "D", "E", "F", "G", "A", "B"};
        List<String> pitchLetters = Arrays.asList(pitch);
        int lowerPitchIndex = pitchLetters.indexOf(String.valueOf(lowerNote.charAt(0)));
        int lowerOctave = Integer.parseInt(lowerNote.substring(1));
        int higherPitchIndex = pitchLetters.indexOf(String.valueOf(higherNote.charAt(0)));
        int higherOctave = Integer.parseInt(higherNote.substring(1));

        for (String note : songNotes) {
            int noteOctave = Integer.parseInt(note.substring(1));
            int notePitchIndex = pitchLetters.indexOf(note.substring(0, 1));
            if (note.equals(lowerNote) || note.equals(higherNote) || (noteOctave > lowerOctave && noteOctave < higherOctave)) {
               continue;
            } else {
                if (noteOctave < lowerOctave || noteOctave > higherOctave)
                    return false;
                else {
                    if ((noteOctave == lowerOctave && notePitchIndex < lowerPitchIndex) || (noteOctave == higherOctave && notePitchIndex > higherPitchIndex))
                        return false;
                }
            }
        }
        return true;
    }
}

