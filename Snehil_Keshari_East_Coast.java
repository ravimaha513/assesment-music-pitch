
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Snehil_Keshari_East_Coast {
	
	

	
	public static void singable(String[] songInput, String low, String high) {
	    // Check for invalid inputs

	    
	    String[] song = Arrays.copyOf(songInput, songInput.length);
	    if (song == null || song.length == 0 || low == null || low.isEmpty() || high == null || high.isEmpty()) {
	        throw new IllegalArgumentException("Invalid input");
	    }
	    Map<Character, Character> table = new HashMap<>();
	    table.put('C', '0'); // C D E F G A B 
	    table.put('D', '1');
	    table.put('E', '2');
	    table.put('F', '3');
	    table.put('G', '4');
	    table.put('A', '5');
	    table.put('B', '6');

	    for (int i = 0; i < song.length; i++) {
	        String curr = song[i];
	        curr = curr.replace(String.valueOf(curr.charAt(0)), String.valueOf(table.get(curr.charAt(0))));
	        curr = new StringBuilder(curr).reverse().toString();
	        song[i] = curr;
	    }

	    Arrays.sort(song, String.CASE_INSENSITIVE_ORDER);

	    low = low.replace(String.valueOf(low.charAt(0)), String.valueOf(table.get(low.charAt(0))));
	    low = new StringBuilder(low).reverse().toString();

	    high = high.replace(String.valueOf(high.charAt(0)), String.valueOf(table.get(high.charAt(0))));
	    high = new StringBuilder(high).reverse().toString();

	    if (low.compareTo(high) > 0) {
	        String temp1 = low;
	        low = high;
	        high = temp1;
	    }

	    if ((low.compareTo(song[0]) <= 0) && (high.compareTo(song[song.length - 1]) >= 0)) {
	        System.out.println("True");
	    } else {
	        System.out.println("False");
	    }
	}


	
	
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
    
    
    singable(song1, "F4", "C5");
    singable(song1, "A4", "C5");
    singable(song2, "B2", "C5");
    singable(song2, "C3", "B4");
    singable(song3, "B4", "B5");
    singable(song3, "B4", "C5");
    singable(song4, "D4", "A5");
    singable(song4, "D4", "G5");
    
    singable(song4, "D4", "C6");
    
    singable(song4, "F4", "C6");
    singable(song5, "D4", "E4");
    }

}
