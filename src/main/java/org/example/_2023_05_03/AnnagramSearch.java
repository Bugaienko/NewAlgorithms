package org.example._2023_05_03;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sergii Bugaienko
 */

public class AnnagramSearch {
    public static void main(String[] args) {
        String s1 = "MdPfOTgEzK";
        String s2 = "cMKa12EPT78Oq4";
        String[] strings = {s1, s2};
        strings = deleteRepeats(strings);


    }

    private static String[] deleteRepeats(String[] strings) {

        List<Character> repeatedChars = createMap(strings);
        System.out.println(repeatedChars);
        List<String> cleanString = cleanStrings(strings, repeatedChars);

        rotateSecondString(cleanString);
        System.out.println(cleanString);

        String s1 = cleanString.get(0);
        String s2 = cleanString.get(1);

        List<String> listRes = new ArrayList<>();

        String sFirst;
        for (int i = 0; i < s1.length(); i++) {
            sFirst = s1.substring(i);
            listRes.add(searchMaxRepeatString(sFirst, s2));
        }
        System.out.println(listRes);
        String maxLengthRes = listRes.stream().max(Comparator.comparing(String::length)).orElse(null);
        System.out.println("Longest anagram: " + maxLengthRes);






        return strings;
    }

    private static String searchMaxRepeatString(String s1, String s2) {
        String tmpS2 = s2 + "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {


            int idx = searchChar(s1.charAt(i), tmpS2);
            if (idx > -1) {
                sb.append(s1.charAt(i));
                tmpS2 = tmpS2.substring(idx);
            }

        }
        return sb.toString();

    }

    private static int searchChar(char ch, String s2){
        return s2.indexOf(ch);
    }

    private static void rotateSecondString(List<String> cleanString){
        StringBuilder stringBuilder = new StringBuilder(cleanString.get(1));
        StringBuilder reverseStr = stringBuilder.reverse();
        cleanString.remove(cleanString.get(1));
        cleanString.add(reverseStr.toString());

    }

    private static List<String> cleanStrings (String[] strings, List<Character> repeatedChars) {
        List<String> cleanString = new ArrayList<>();

        for (String str: strings) {
            char[] chars = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char ch: chars) {
                if (repeatedChars.contains(ch)) {
                    sb.append(ch);
                }
            }
            cleanString.add(sb.toString());
        }

        return cleanString;
    }

    private static List<Character> createMap(String[] strings){
        Map<Character, Integer> result = new HashMap<>();

        for (String str : strings) {
            char[] chars = str.toCharArray();
            Set<Character> repeatInOneStr = new HashSet<>();
            for (char ch : chars) {
                if (!repeatInOneStr.contains(ch)) {
                    repeatInOneStr.add(ch);
                    Integer count = result.get(ch);
                    result.put(ch, count != null ? count + 1 : 1);
                }
            }
        }
        return result.entrySet().stream().filter(e -> e.getValue() == strings.length).map(e -> e.getKey()).collect(Collectors.toList());

    }
}
