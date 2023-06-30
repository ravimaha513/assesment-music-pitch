class RangeFinder {
    String pitch = "CDEFGAB";

    private boolean inRange(String min, String s, String max) {
        int minInt = min.charAt(1) - 48;
        int minS = s.charAt(1) - 48;
        int maxInt = max.charAt(1) - 48;
        if (s.equals(min) || s.equals(max)) {
            return true;
        } else if (minS < minInt || minS > maxInt) {
            return false;
        } else if (minS == minInt || minS == maxInt) {
            if (minInt == maxInt) {
                return pitch.indexOf(s.charAt(0)) > pitch.indexOf(min.charAt(0)) && pitch.indexOf(s.charAt(0)) < pitch.indexOf(max.charAt(0));
            }
            if (minS == minInt) {
                return pitch.indexOf(s.charAt(0)) > pitch.indexOf(min.charAt(0));
            }
            return pitch.indexOf(s.charAt(0)) < pitch.indexOf(max.charAt(0));
        }
        return true;

    }

    public boolean singable(String[] song, String min, String max) {
        boolean flag;
        for (String s : song) {
            flag = inRange(min, s, max);
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}

public class TaskSolution {
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
        RangeFinder rangeFinder = new RangeFinder();

        System.out.println("singable(song1, \"F4\", \"C5\") :"+rangeFinder.singable(song1, "F4", "C5"));
        System.out.println("singable(song1, \"A4\", \"C5\") :"+rangeFinder.singable(song1, "A4", "C5"));
        System.out.println("singable(song2, \"B2\", \"C5\") :"+rangeFinder.singable(song2, "B2", "C5"));
        System.out.println("singable(song2, \"C3\", \"B4\") :"+rangeFinder.singable(song2, "C3", "B4"));
        System.out.println("singable(song3, \"B4\", \"B5\") :"+rangeFinder.singable(song3, "B4", "B5"));
        System.out.println("singable(song3, \"B4\", \"C5\") :"+rangeFinder.singable(song3, "B4", "C5"));
        System.out.println("singable(song4, \"D4\", \"A5\") :"+rangeFinder.singable(song4, "D4", "A5"));
        System.out.println("singable(song4, \"D4\", \"G5\") :"+rangeFinder.singable(song4, "D4", "G5"));
        System.out.println("singable(song4, \"D4\", \"C6\") :"+rangeFinder.singable(song4, "D4", "C6"));
        System.out.println("singable(song4, \"F4\", \"C6\") :"+rangeFinder.singable(song4, "F4", "C6"));
        System.out.println("singable(song5, \"D4\", \"E4\") :"+rangeFinder.singable(song5, "D4", "E4"));


    }
}
