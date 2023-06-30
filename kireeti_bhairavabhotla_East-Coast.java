import java.util.*;

public class Main {
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
        System.out.println("Singable(song1, \"F4\", \"C5\") : " + Singable(song1, "F4", "C5"));
        System.out.println("Singable(song1, \"A4\", \"C5\") : " + Singable(song1, "A4", "C5"));
        System.out.println("Singable(song2, \"B2\", \"C5\") : " + Singable(song2, "B2", "C5"));
        System.out.println("Singable(song2, \"C3\", \"B4\") : " + Singable(song2, "C3", "B4"));
        System.out.println("Singable(song3, \"B4\", \"B5\") : " + Singable(song3, "B4", "B5"));
        System.out.println("Singable(song3, \"B4\", \"C5\") : " + Singable(song3, "B4", "C5"));
        System.out.println("Singable(song4, \"D4\", \"A5\") : " + Singable(song4, "D4", "A5"));
        System.out.println("Singable(song4, \"D4\", \"G5\") : " + Singable(song4, "D4", "G5"));
        System.out.println("Singable(song4, \"D4\", \"C6\") : " + Singable(song4, "D4", "C6"));
        System.out.println("Singable(song4, \"F4\", \"C6\") : " + Singable(song4, "F4", "C6"));
        System.out.println("Singable(song5, \"D4\", \"E4\") : " + Singable(song5, "D4", "E4"));

    }

    public static boolean Singable(String[] song, String lowestNoteSingable, String highestNoteSingable) {
        ParsedSong parsedSong = new ParsedSong(song);
        Note lowerLimit = new Note(lowestNoteSingable);
        Note upperLimit = new Note(highestNoteSingable);
        boolean canSing = true;
        for (Note note : parsedSong.getSongNotes()) {
            if (!lowerLimit.isLower(note) || !upperLimit.isHigher(note)) {
                canSing = false;
            };
        }

        return canSing;
    }
}

class Note {
    private String pitch;
    private Integer octave;

    private ArrayList<String> pitchScale = new ArrayList<String>() {
        {
            add("C");
            add("D");
            add("E");
            add("F");
            add("G");
            add("A");
            add("B");
        };
    };

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    public Integer getOctave() {
        return octave;
    }

    public void setOctave(Integer octave) {
        this.octave = octave;
    }

    public Note() {};

    public Note(String note) {
        this.pitch = note.substring(0, 1);
        this.octave = Integer.valueOf(note.substring(1, 2));
    }

    public boolean isLower(Note otherNote) {
        if (otherNote.octave < this.octave) {
            return false;
        } else if (otherNote.octave == this.octave) {
            if (pitchScale.indexOf(otherNote.pitch) < pitchScale.indexOf(this.pitch)) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public boolean isHigher(Note otherNote){
        if(otherNote.octave > this.octave){
            return false;
        } else if (otherNote.octave == this.octave) {
            if(pitchScale.indexOf(otherNote.pitch) > pitchScale.indexOf(this.pitch)){
                return false;
            }
            else {
                return true;
            }
        }else {
            return true;
        }
    }
}

class ParsedSong{

    public ParsedSong(){}

    public ParsedSong(String[] song){
        this.songNotes = new ArrayList<Note>();
        for(int i=0; i<song.length; i++){
            this.songNotes.add(new Note(song[i]));
        }
    }

    private ArrayList<Note> songNotes;

    public ArrayList<Note> getSongNotes() {
        return songNotes;
    }

    public void setSongNotes(ArrayList<Note> songNotes) {
        this.songNotes = songNotes;
    }
}
