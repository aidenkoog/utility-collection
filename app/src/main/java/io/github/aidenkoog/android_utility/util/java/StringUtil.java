package io.github.aidenkoog.android_utility.util.java;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringUtil {
    // substring
    public static String getSubstring(String value, int start) {
        // "ABCDEFG" => start: 3 => "DEFG"
        return value.substring(start);
    }

    // substring
    public static String getSubstring(String value, int start, int end) {
        // "ABCDEFG" => start: 3, end: 6 => "DEF"
        return value.substring(start, end);
    }

    // substring
    public static String trimLastChars(String value, int trimCount) {
        // "ABCDEFG" => trimCount: 3 => "EFG"
        return value.substring(value.length() - trimCount, value.length());
    }

    // substring + lastIndexOf
    // refs. lastIndexOf: -1 (false)
    public static String getCharsAfterDelimeter(String value, String delimeter) {
        // "ABCD/EFG" => delimeter: "/" => "EFG
        return value.substring(value.lastIndexOf("/") + 1);
    }

    // substring + lastIndexOf
    public static String getCharsBeforeDelimeter(String value, String delimeter) {
        // "ABCD/EFG" => delimeter: "/" => "ABCD"
        return value.substring(0, value.lastIndexOf("/"));
    }

    // substring + indexOf
    // refs. indexOf: -1 (false)
    public static String trimChars(String value, String target) {
        // "AAA: 1000won, BBB: 3000won, CCC: 4000won"
        // target: "BBB" => "BBB: 3000" => "BBB: 3000won"
        int targetIndex = value.indexOf(target);
        String result = value.substring(
                targetIndex,
                (value.substring(targetIndex).indexOf("won")));
        return result + "won";
    }

    // split
    public static String splitString(String value, String regex) {
        // "0#1#2#3#4#" => regex: # => 0, 1, 2, 3, 4
        String[] valueArray = value.split(regex);
        return Arrays.toString(valueArray);
    }

    // split
    public static String[] splitString2(String value, String regex) {
        // "110" => regex: 1 => '', '', 0
        // "1101" => regex: 1 => '', '', 0
        return value.split(regex);
    }

    // trim
    public static String trimSpaceChars(String value) {
        // " ABCDE FG " => "ABCDE FG"
        return value.trim();
    }

    // trim + replace
    public static String trimSpaceInMiddle(String value) {
        // " ABCDE FG " => "ABCDEFG"
        return value.trim().replace(" ", "");
    }

    // replace
    public static String replaceString(String value, String target, String replacement) {
        // "A,B,C" => replacement: , => "ABC"
        return value.replace(target, replacement);
    }

    // replaceFirst
    public static String replaceFirstString(String value, String target, String replacement) {
        // "A,B,C" => "AB,C"
        return value.replaceFirst(target, replacement);
    }

    // concat
    public static String concatString(String value1, String value2) {
        // return value1 + value2;
        return value1.concat(value2);
    }

    // isEmpty
    public static boolean isEmptyString(String value) {
        return value.isEmpty();
    }

    // charAt
    public static char getChar(String value, int index) {
        return value.charAt(index);
    }

    // getChars (similar to arraycopy)
    public static String copyCharArray() {
        String value = new String("abcd");
        char[] charArray = new char[4];
        value.getChars(0, 2, charArray, 0);
        return Arrays.toString(charArray);
    }

    // equals
    public static boolean equalString(String value1, String value2) {
        return value1.equals(value2);
    }

    // compareTo
    public static int compareToString(String value1, String value2) {
        // value1 == value2: 0
        // value1 < value2: -1
        // value1 > value2: 1
        return value1.compareTo(value2);
    }

    // contains
    public static boolean containString(String value, String compareString) {
        return value.contains(compareString);
    }

    // toString
    public static String intToString(int value) {
        return Integer.toString(value);
    }

    // parseInt
    public static int stringToInt(String value) {
        return Integer.parseInt(value);
    }

    // Character isLetter / isWhitespace / toLowerCase
    public static boolean isLetterOrWhitespace(char ch) {
        ch = Character.toLowerCase(ch);
        return Character.isLetter(ch) || Character.isWhitespace(ch);
    }

    // ArrayList
    public static List<String> getArrayList() {
        List<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("BBB");
        list.add(1, "CCC");
        // "AAA, CCC, BBB"

        list.add("DDD");
        list.add("EEE");
        // "AAA, CCC, BBB, DDD, EEE"

        list.remove(4);
        // "AAA, CCC, BBB, DDD"
        return list;
    }

    // HashMap
    public static Map<String, String> getHashMap() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("A", "100");
        hashMap.put("B", "200");
        hashMap.put("C", hashMap.get("A"));
        // A=100, B=200, C=100
        return hashMap;
    }

    // StringBuilder
    public static StringBuilder getStringBuilder() {
        StringBuilder builder = new StringBuilder("START");
        builder.append("1000");
        builder.insert(0, "INSERT");
        builder.delete(0, 1);
        builder.substring(0);
        Log.d("debug", "builder length: " + builder.length());
        builder.reverse();
        return builder;
    }
}
