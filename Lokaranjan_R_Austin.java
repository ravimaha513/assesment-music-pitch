package efidemo1;

import java.io.*;
import java.util.Arrays;

public class Solution {
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
    System.out.println(singable(song2, "B2", "C5") );
    System.out.println(singable(song2, "C3", "B4") );
    System.out.println(singable(song3, "B4", "B5"));
    System.out.println(singable(song3, "B4", "C5") );
    System.out.println(singable(song4, "D4", "A5"));
    System.out.println(singable(song4, "D4", "G5"));
    System.out.println(singable(song4, "D4", "C6") );
    System.out.println(singable(song4, "F4", "C6") );
    System.out.println(singable(song5, "D4", "E4") );

    
  }
  
  
  public static boolean singable(String[] song, String lowNote, String highNote) {
	  for (String note : song) {
	    int noteValue = getNoteValue(note);
	    int lowNoteValue = getNoteValue(lowNote);
	    int highNoteValue = getNoteValue(highNote);

	    if (noteValue < lowNoteValue || noteValue > highNoteValue) {
	      return false;
	    }
	  }

	  return true;
	}

	private static int getNoteValue(String note) {
	  int octave = note.charAt(note.length() - 1) - '0';
	  int pitch = note.charAt(0) - 'C';

	  return 12 * octave + pitch;
	}}