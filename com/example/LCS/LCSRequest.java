package com.example.LCS;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LCSRequest {
    private List<StringObject> setOfStrings;

    public List<StringObject> getSetOfStrings() {
        return setOfStrings;
    }

    public void setSetOfStrings(List<StringObject> setOfStrings) {
        this.setOfStrings = setOfStrings;
    }

    public static class StringObject {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}

