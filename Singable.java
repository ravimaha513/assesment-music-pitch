package org.example;

public class Singable {
    public boolean Singable(String[] song, String low, String high) {
        String pitchOrder = "CDEFGAB";

        String lowNote = song[0];
        int lastIndex = song.length - 1;
        String highNote = song[lastIndex];

        String lowPitch = lowNote.substring(0, 1);
        int lowOctave = Integer.parseInt(lowNote.substring(1));

        String inputPitch = low.substring(0, 1);
        int inputOctave = Integer.parseInt(low.substring(1));

        String highPitch = highNote.substring(0, 1);
        int highOctave = Integer.parseInt(highNote.substring(1));

        String inputHighPitch = high.substring(0, 1);
        int inputHighOctave = Integer.parseInt(high.substring(1));

        if (lowOctave > inputOctave) {
            if (pitchOrder.indexOf(lowPitch) == pitchOrder.indexOf(inputPitch)) {
                return false;
            } else if (pitchOrder.indexOf(lowPitch) > pitchOrder.indexOf(inputPitch)) {
                return false;
            }
        } else if (lowOctave < inputOctave) {
            if (pitchOrder.indexOf(lowPitch) > pitchOrder.indexOf(inputPitch)) {
                return false;
            }
        } else {
            if (pitchOrder.indexOf(lowPitch) < pitchOrder.indexOf(inputPitch)) {
                return false;
            }
        }

        if (highOctave > inputHighOctave) {
            if (pitchOrder.indexOf(highPitch) == pitchOrder.indexOf(inputHighPitch)) {
                return false;
            } else if (pitchOrder.indexOf(highPitch) < pitchOrder.indexOf(inputHighPitch)) {
                return false;
            }
        } else if (highOctave < inputHighOctave) {
            return pitchOrder.indexOf(highPitch) >= pitchOrder.indexOf(inputHighPitch);
        } else {
            if (pitchOrder.indexOf(highPitch) > pitchOrder.indexOf(inputHighPitch)) {
                return false;
            }
        }

        return true;
    }
}
