import java.util.*;

public class Vijay_Kanth_Columbus {
    public static void main(String[] argv) {
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
    public static boolean isNoteLessThanOrEqual(String note1, String note2) {
        String[] notes = {"C", "D", "E", "F", "G", "A", "B"};
        int octave1 = Integer.parseInt(note1.substring(1));
        int octave2 = Integer.parseInt(note2.substring(1));
        int pitchIndex1 = Arrays.asList(notes).indexOf(note1.substring(0, 1));
        int pitchIndex2 = Arrays.asList(notes).indexOf(note2.substring(0, 1));
        if (octave1 < octave2) {
            return true;
        } else if (octave1 > octave2) {
            return false;
        } else {
            return pitchIndex1 <= pitchIndex2;
        }
    }
    public static boolean singable(String[] song, String lowestNote, String highestNote) {
        for (String note : song) {
            if (!isNoteLessThanOrEqual(lowestNote, note) || !isNoteLessThanOrEqual(note, highestNote)) {
                return false;
            }
        }
        return true;
    }
}