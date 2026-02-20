package com.arumbala.lcblind75.problems;

/**
 * Valid Anagram
 *
 * Given two strings s and t, return true if t is an anagram of s.
 * An anagram uses the same characters with the same frequency.
 *
 * Example: s = "anagram", t = "nagaram" → true
 * Example: s = "rat", t = "car" → false
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car"));         // false
        System.out.println(isAnagram("listen", "silent"));   // true
        System.out.println(isAnagram("rat", null)); //false
    }
}