import java.util.Scanner;

public class VenkateswarReddy_Kothapally_Florida {
    public static void main(String[] args) {
        // SCANNING FOR NOTES 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the notes of the song (separated by spaces):");
        String input = scanner.nextLine();
        String[] songNotes = input.split(" ");

        // GET SINGERS CAPABILITIES
        System.out.println("Enter the lowest note the singer can sing:");
        String lowestNote = scanner.nextLine();
        System.out.println("Enter the highest note the singer can sing:");
        String highestNote = scanner.nextLine();

        // CHECKIGN IF SINGER CAN SING THE SONG 
        boolean canSing = isSingable(songNotes, lowestNote, highestNote);

        // RESULT 
        if (canSing) {
            System.out.println("The singer can sing the song!");
        } else {
            System.out.println("The singer cannot sing the song.");
        }
 
        scanner.close();
    }

    public static boolean isSingable(String[] songNotes, String lowestNote, String highestNote) {
        // NOTE TO OCTAVE CONVERSION 
        int lowestOctave = getOctave(lowestNote);
        int highestOctave = getOctave(highestNote);

         
        for (String note : songNotes) {
            // CONVERSION HEAPPENS HERE 
            int noteOctave = getOctave(note);

            // ACTUAL CHECK LOGIC 
            if (noteOctave < lowestOctave || noteOctave > highestOctave) {
                return false;
            }
        }
 
        return true;
    }

    public static int getOctave(String note) {
        // Extract the octave number from the note string
        return Integer.parseInt(note.substring(1));
    }
}
