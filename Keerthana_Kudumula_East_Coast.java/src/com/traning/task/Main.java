package com.traning.task;

import java.util.*;

public class Main {
  // Helper function to convert a note in string format to numerical value
  public static int noteToValue(String note) {
    char pitch = note.charAt(0);
    int octave = Character.getNumericValue(note.charAt(1));
    // C4 is the reference note with value 40
    int referenceValue = 40;
    int pitchValue = "CDEFGAB".indexOf(pitch);
    return (octave * 12) + pitchValue + referenceValue;
  }

  // Function to check if the singer can sing the song
  public static boolean singable(String[] song, String lowest, String highest) {
    int singerLowest = noteToValue(lowest);
    int singerHighest = noteToValue(highest);

    for (String note : song) {
      int noteValue = noteToValue(note);
      if (noteValue < singerLowest || noteValue > singerHighest) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String[] song1 = {"F4", "B4", "C5"};
    String[] song2 = {"C3", "E3", "G3", "C4", "E4", "G4", "C5"};
    String[] song3 = {"B4", "F5", "B5"};
    String[] song4 = {
      "B4", "E4", "G4", "G4", "A4", "B4", "E4", "B4", "E4", "G4", "G4", "A4", "C5", "B4",
      "E5", "G4", "G4", "A4", "B4", "C5", "D5", "C5", "B4", "C5", "E5", "D5", "C5", "C5",
      "B4", "B4", "E5", "E4", "G4", "G4", "A4", "B4", "B4", "B4", "C5", "E5", "A5", "E5",
      "C5", "A4", "E5", "D5", "C5", "B4"
    };
    String[] song5 = {"F4"};

    System.out.println(singable(song1, "F4", "C5")); // Output: True
    System.out.println(singable(song1, "A4", "C5")); // Output: False
    System.out.println(singable(song2, "B2", "C5")); // Output: True
    System.out.println(singable(song2, "C3", "B4")); // Output: False
    System.out.println(singable(song3, "B4", "B5")); // Output: True
    System.out.println(singable(song3, "B4", "C5")); // Output: False
    System.out.println(singable(song4, "D4", "A5")); // Output: True
    System.out.println(singable(song4, "D4", "G5")); // Output: False
    System.out.println(singable(song4, "D4", "C6")); // Output: True
    System.out.println(singable(song4, "F4", "C6"));
  }
}

