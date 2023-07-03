package org.example;

import java.util.ArrayList;
import java.util.List;

public class Singable {
    public boolean Singable(String[] song, String low, String high) {
        List<String> pitchOrder = new ArrayList<>(List.of("C", "D", "E", "F", "G", "A", "B"));
        int lowestOctave = Integer.parseInt(low.substring(1));
        int highestOctave = Integer.parseInt(high.substring(1));

        for (String note : song) {
            int octave = Integer.parseInt(note.substring(1));
            String pitch = note.substring(0, 1);

            if (octave < lowestOctave || octave > highestOctave) {
                return false;
            } else if (octave == lowestOctave && pitchOrder.indexOf(pitch) < pitchOrder.indexOf(low.substring(0, 1))) {
                return false;
            } else if (octave == highestOctave && pitchOrder.indexOf(pitch) > pitchOrder.indexOf(high.substring(0, 1))) {
                return false;
            }
        }

        return true;
    }
}
