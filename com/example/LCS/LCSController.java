package com.example.LCS;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class LCSController {

    @PostMapping("/lcs")
    public ResponseEntity<Object> findLongestCommonSubstring(@RequestBody LCSRequest request) {
        Set<String> setOfStrings = request.getSetOfStrings().stream()
                .map(LCSRequest.StringObject::getValue)
                .collect(Collectors.toSet());

        if (setOfStrings.isEmpty()) {
            return ResponseEntity.badRequest().body("setOfStrings should not be empty.");
        }

        if (setOfStrings.size() < request.getSetOfStrings().size()) {
            return ResponseEntity.badRequest().body("setOfStrings must be a Set.");
        }

        List<Map<String, String>> longestCommonSubstrings = findLongestCommonSubstrings(setOfStrings);

        if (longestCommonSubstrings.isEmpty()) {
            return ResponseEntity.ok().body(Collections.emptyMap());
        }

        Map<String, List<Map<String, String>>> response = new HashMap<>();
        response.put("lcs", longestCommonSubstrings);

        return ResponseEntity.ok().body(response);
    }

    private List<Map<String, String>> findLongestCommonSubstrings(Set<String> setOfStrings) {
        String[] strings = setOfStrings.toArray(new String[0]);
        int n = strings.length;

        // Find all common substrings using dynamic programming
        List<String> commonSubstrings = new ArrayList<>();
        for (int i = 0; i < strings[0].length(); i++) {
            for (int j = i + 1; j <= strings[0].length(); j++) {
                String substring = strings[0].substring(i, j);
                boolean isCommonSubstring = true;
                for (int k = 1; k < n; k++) {
                    if (!strings[k].contains(substring)) {
                        isCommonSubstring = false;
                        break;
                    }
                }
                if (isCommonSubstring) {
                    commonSubstrings.add(substring);
                }
            }
        }

        // Find the longest common substrings
        int maxLen = 0;
        List<Map<String, String>> longestCommonSubstrings = new ArrayList<>();
        for (String substring : commonSubstrings) {
            int len = substring.length();
            if (len > maxLen) {
                maxLen = len;
                longestCommonSubstrings.clear();
                Map<String, String> substringMap = new HashMap<>();
                substringMap.put("value", substring);
                longestCommonSubstrings.add(substringMap);
            } else if (len == maxLen) {
                Map<String, String> substringMap = new HashMap<>();
                substringMap.put("value", substring);
                longestCommonSubstrings.add(substringMap);
            }
        }

        return longestCommonSubstrings;
    }




    private int calculateCommonLength(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        int maxLength = 0;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        return maxLength;
    }
}
