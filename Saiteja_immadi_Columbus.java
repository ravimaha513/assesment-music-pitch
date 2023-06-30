import java.util.*;

public class Main {

    static HashMap<Character, Integer> map= new HashMap<Character, Integer>(){
        {
            put('C', 1);
            put('D', 2);
            put('E', 3);
            put('F', 4);
            put('G', 5);
            put('A', 6);
            put('B', 7);
        }
    };

    public static void main(String[] args) {

        //System.out.println("Hello world!");

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


        System.out.println(singable(song1, "F4", "C5"));//=> True
        System.out.println(singable(song1, "A4", "C5"));// => False
        System.out.println(singable(song2, "B2", "C5"));// => True
        System.out.println(singable(song2, "C3", "B4"));// => False
        System.out.println(singable(song3, "B4", "B5"));// => True
        System.out.println(singable(song3, "B4", "C5"));// => False
        System.out.println(singable(song4, "D4", "A5"));// => True
        System.out.println(singable(song4, "D4", "G5"));// => False
        System.out.println(singable(song4, "D4", "C6"));// => True
        System.out.println(singable(song4, "F4", "C6"));// => False
        System.out.println(singable(song5, "D4", "E4"));// => False
    }

    private static boolean singable(String[] song, String low, String high){

        char pl = low.charAt(0);
        int ol =  low.charAt(1);

        char ph = high.charAt(0);
        int oh =  high.charAt(1);

        for(int i = 0; i< song.length; i++){
            String s = song[i];
            char p = s.charAt(0);
            int o =  s.charAt(1);

            if(!(o>=ol)) return false;
            if(!(o<=oh)) return false;
            //if(!(o>=ol && o<=oh)) return false;
            if(o==ol) {
                if (!(map.get(p) >= map.get(pl))) return false;
            }
            if(o==oh) {
                if (!(map.get(p) <= map.get(ph))) return false;
            }
            //if(!(map.get(p) >= map.get(pl) && (map.get(p)<= map.get(ph)))) return false;
        }

        return true;
    }
}
