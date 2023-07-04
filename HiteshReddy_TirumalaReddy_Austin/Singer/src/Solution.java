

public class Solution {
	
	
	 /* Inside the class, there is a method called "singable" The
     *  three parameters: 
     *  1. An array of strings representing the notes of a song, 
     *  2. A string representing the lowest note allowed, 
     *  3. String representing the highest note allowed. 
     *  The method returns a boolean value indicating whether the song is singable within the specified range of notes.
     */ 
	
    public static boolean singable(String[] song, String lowestNote, String highestNote) 
    
      {
    	
    	 /* 
    	  * 1. char lowestPitch = lowestNote.charAt(0); 
    	  * Means that we are extracting the first character from the string lowestNote 
    	  * and storing it in a variable named lowestPitch. This character represents the pitch letter of the lowest note.
    	  * 2. int lowestOctave = Character.getNumericValue(lowestNote.charAt(1)); 
    	  * Means that we are extracting the second character from the string lowestNote
    	  * converting it to its corresponding numeric value, and storing it in a variable named lowestOctave. 
    	  * This numeric value represents the octave number of the lowest note.
         */ 
    	
    
        char lowestPitch = lowestNote.charAt(0);
        int lowestOctave = Character.getNumericValue(lowestNote.charAt(1));

        char highestPitch = highestNote.charAt(0);
        int highestOctave = Character.getNumericValue(highestNote.charAt(1));

        // Define the order of pitch letters in the scale
        String pitchOrder = "CDEFGAB";

        // Get the indices of the lowest and highest pitch letters
        int lowestPitchIndex = pitchOrder.indexOf(lowestPitch);
        int highestPitchIndex = pitchOrder.indexOf(highestPitch);

        // Iterate through each note in the song
        for (String note : song) {
            // Convert the note to its pitch letter and octave number
            char notePitch = note.charAt(0);
            int noteOctave = Character.getNumericValue(note.charAt(1));

            // Check if the note is outside the singer's range
            if (noteOctave < lowestOctave || noteOctave > highestOctave) {
                return false;
            }

            // Compare the pitch letters based on their order in the scale
            int notePitchIndex = pitchOrder.indexOf(notePitch);

            if (noteOctave == lowestOctave && notePitchIndex < lowestPitchIndex) {
                return false;
            }

            if (noteOctave == highestOctave && notePitchIndex > highestPitchIndex) {
                return false;
            }
        }

        return true;
    }

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

        boolean result1 = singable(song1, "F4", "C5");
        boolean result2 = singable(song1, "A4", "C5");
        boolean result3 = singable(song2, "B2", "C5");
        boolean result4 = singable(song2, "C3", "B4");
        boolean result5 = singable(song3, "B4", "B5");
        boolean result6 = singable(song3, "B4", "C5");
        boolean result7 = singable(song4, "D4", "A5");
        boolean result8 = singable(song4, "D4", "G5");
        boolean result9 = singable(song4, "D4", "C6");
        boolean result10 = singable(song4, "F4", "C6");
        boolean result11 = singable(song5, "D4", "E4");

        System.out.println("The Result for song1 : " + result1);  // true
        System.out.println("The Result for song1 : " +result2);   
        System.out.println("The Result for song2 : " +result3);
        System.out.println("The Result for song2 : " +result4);
        System.out.println("The Result for song3 : " +result5);
        System.out.println("The Result for song3 : " +result6);
        System.out.println("The Result for song4 : " +result7);
        System.out.println("The Result for song4 : " +result8);
       System.out.println("The Result for song4: " +result9);
       System.out.println("The Result for song4 : " +result10);
        System.out.println("The Result for song5 : " +result11);
   

        
    }

}
            
/*
 * The code defines a Java class named "Solution".



The method begins by extracting the pitch letters and octave numbers from the lowest and highest notes provided. It uses the charAt method to access specific characters in the note strings and the Character.getNumericValue method to convert the octave character to its corresponding numeric value.

The code defines a string variable named "pitchOrder" that represents the order of pitch letters in the musical scale, from C to B.

The next step is to determine the indices of the lowest and highest pitch letters in the "pitchOrder" string. It uses the indexOf method to find the positions of the lowest and highest pitch letters.

The code then enters a loop that iterates through each note in the song. It uses a for-each loop to traverse the elements of the "song" array.

For each note in the song, the code extracts the pitch letter and octave number in a similar manner as done for the lowest and highest notes.

The program checks if the note's octave is outside the singer's range (i.e., lower than the lowest octave or higher than the highest octave). If the condition is true, the method immediately returns false, indicating that the song is not singable within the specified range.

Next, the code compares the pitch letters based on their order in the scale. It obtains the pitch index of the note using the indexOf method on the "pitchOrder" string.

If the note's octave is equal to the lowest octave and its pitch index is less than the lowest pitch index, the method returns false.

Similarly, if the note's octave is equal to the highest octave and its pitch index is greater than the highest pitch index, the method returns false.

If the code reaches this point, it means that all the notes in the song have passed the range and pitch checks. In that case, the method returns true, indicating that the song is singable within the specified range.

The code also includes a "main" method, which serves as the entry point of the program.

Inside the "main" method, several arrays of strings are defined, each representing a different song.

The "singable" method is then called with different songs and note ranges, and the returned boolean values are stored in respective variables.

Finally, the results of singability for each song are printed to the console using System.out.println.

The code essentially checks if a given song can be sung within a specified range of notes by comparing the pitch letters and octave numbers of each note in the song with the provided lowest and highest notes.
 */
      
    
    
    
    
    

   