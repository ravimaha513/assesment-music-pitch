import java.io.*;
import java.util.*;
class Note{
    private int pitchNote;
    private int octave;
    static String pitch = "CDEFGAB";
    public Note(){
        this.pitchNote = 0;
        this.octave = 0;
    }
    public Note(String note){
        this.pitchNote = pitch.indexOf(note.charAt(0));
        this.octave = Character.getNumericValue(note.charAt(1));
    }
    public int getPitch(){
        return this.pitchNote;
    }
    public int getOctave(){
        return this.octave;
    }
    public void setNote(String note){
        this.pitchNote = pitch.indexOf(note.charAt(0));
        this.octave = Character.getNumericValue(note.charAt(1));
    }
    public boolean lesserThan(Note newNote){
        if(this.octave < newNote.getOctave() || (this.octave == newNote.getOctave() && this.pitchNote < newNote.getPitch())){
            return true;
        }
        return false;
    }
    public boolean greaterThan(Note newNote){
        if(this.octave > newNote.getOctave() || (this.octave == newNote.getOctave() && this.pitchNote > newNote.getPitch())){
            return true;
        }
        return false;
    }
}
public class Ronak_S_Houston{
    public static boolean singable(String[] song, String low, String high){
        Note lowNote = new Note(low);
        Note highNote = new Note(high);
        Note singingNote = new Note();
        for(String note : song){
            singingNote.setNote(note);
            if(singingNote.lesserThan(lowNote) || singingNote.greaterThan(highNote)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String[] song1 =  {"F4", "B4", "C5"};
        String[] song2 =  {"C3", "E3", "G3", "C4", "E4", "G4", "C5"};
        String[] song3 =  {"B4", "F5", "B5"};
        String[] song4 =  {"B4", "E4", "G4", "G4", "A4", "B4", "E4", 
          "B4", "E4", "G4", "G4", "A4", "C5", "B4", 
          "E5", "G4", "G4", "A4", "B4", "C5", "D5", 
          "C5", "B4", "C5", "E5", "D5", "C5", "C5", 
          "B4", "B4", "E5", "E4", "G4", "G4", "A4", 
          "B4", "B4", "B4", "C5", "E5", "A5", "E5", 
          "C5", "A4", "E5", "D5", "C5", "B4"};
        String[] song5 =  {"F4"};
        System.out.println("Test case 1 : " + singable(song1, "F4", "C5"));
        System.out.println("Test case 2 : " + singable(song1, "A4", "C5"));
        System.out.println("Test case 3 : " + singable(song2, "B2", "C5"));
        System.out.println("Test case 4 : " + singable(song2, "C3", "B4"));
        System.out.println("Test case 5 : " + singable(song3,  "B4", "B5"));
        System.out.println("Test case 6 : " + singable(song3, "B4", "C5"));
        System.out.println("Test case 7 : " + singable(song4, "D4", "A5"));
        System.out.println("Test case 8 : " + singable(song4, "D4", "G5"));
        System.out.println("Test case 9 : " + singable(song4, "D4", "C6"));
        System.out.println("Test case 10 : " + singable(song4,"F4", "C6"));
        System.out.println("Test case 11 : " + singable(song5, "D4", "E4"));
    }
}