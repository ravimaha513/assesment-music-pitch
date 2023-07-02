package com.java.task.six;

public class Solution {

	public static void main(String[] args) {
		// 5 Samples of songs with list of notes
		String[] song1 = {"F4", "B4", "C5"};
	    String[] song2 = {"C3", "E3", "G3", "C4", "E4", "G4", "C5"};
	    String[] song3 = {"B4", "F5", "B5" };
	    String[] song4 = {"B4", "E4", "G4", "G4", "A4", "B4", "E4", "B4", "E4", "G4", "G4", "A4", "C5", "B4", "E5", "G4", 
	                      "G4", "A4", "B4", "C5", "D5", "C5", "B4", "C5", "E5", "D5", "C5", "C5", "B4", "B4", "E5", "E4", 
	                      "G4", "G4", "A4", "B4", "B4", "B4", "C5", "E5", "A5", "E5", "C5", "A4", "E5", "D5", "C5", "B4"};
	    String[] song5 = {"F4"};

	    //Given test cases/singers
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

	/*
	 * This function singable will return true if singer can sing the song.
	 */
	private static void singable(String[] song, String left, String right) {
		char leftAlpha = left.charAt(0);
		int leftNum = left.charAt(1);
		char rightAlpha = right.charAt(0);
		int rightNum = right.charAt(1);
		for(int i=0; i<song.length; i++) {
			char alpha = song[i].charAt(0);
			int num = song[i].charAt(1); 
			if(leftNum > num) {
				System.out.println("false");
				return;
			} else if (leftNum == num){
				if(order(leftAlpha) > order(alpha)) {
					System.out.println("false");
					return;
				}
			}
			if(rightNum < num) {
				System.out.println("false");
				return;
			} else if (rightNum == num) {
				if(order(rightAlpha) < order(alpha)) {
					System.out.println("false");
					return;
				}
			}
		}
		System.out.println("true");
	}
	
	/*
	 * This function return integer value according to pitch order scale
	 * i.e; low pitch C returning 0 to high pitch B returning 6
	 */
	private static int order (char ch) {
		if(ch == 'C') {
			return 0;
		} else if (ch == 'D') {
			return 1;
		} else if (ch == 'E') {
			return 2;
		} else if (ch == 'F') {
			return 3;
		} else if (ch == 'G') {
			return 4;
		} else if (ch == 'A') {
			return 5;
		} else if (ch == 'B') {
			return 6;
		} 
		return 7;
	}
}
