import java.io.*;
import java.util.*;

public class Solution {
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
    
}
static List<String> arrCheckList=Arrays.asList("C","D","E","F","G","A","B");
public static int numberCheckList[]={0,1,2,3,4,5,6,7};
public static int countValue;
public static boolean boolValue;

public static int count(String x){
   countValue = arrCheckList.indexOf(x.substring(0,1))+ (Integer.parseInt(x.substring(1))+1)*100;
    return countValue;
}

public static boolean singable(String[] song,String lowest,String highest){
    for(String a:song){
        if(count(a)<count(lowest)||count(a)>count(highest)){
            return false;
        }
    }
    return true;
}
}