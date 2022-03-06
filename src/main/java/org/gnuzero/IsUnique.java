package org.gnuzero;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsUnique {
    public static boolean isUniqueChars(String s) {
        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    public static boolean isUniqueUseArray(String s) {
        if (s.length() > 128) return false;
        boolean[] isSet = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if (isSet[val]) {
                return false;
            }
            isSet[val] = true;
        }
        return true;
    }

    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char arr1[] = s1.toCharArray();
        char arr2[] = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < s1.length(); i++) {
            if  (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPermutationUseArray(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        // prepare ASCII array
        int counts[] = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            counts[s2.charAt(i)]--;
            if (counts[s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    public static String getUrlfied(char[] str, int trueLength) {
        int numberOfSpaces = getCharCount(str, 0, trueLength, ' ');
        int newIndex = (trueLength - 1) + (numberOfSpaces * 2);
        int oldIndex = trueLength - 1;

        for (int i = oldIndex; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newIndex--] = '0';
                str[newIndex--] = '2';
                str[newIndex--] = '%';
            } else {
                str[newIndex--] = str[i];
            }
        }


        return String.valueOf(str);
    }

    public static int getCharCount(char[] str, int start, int length, char needle) {
        int count = 0;
        for (int i = start; i < length; i++) {
            if (str[i] == needle) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPalindrome(String str) {
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0 ; i < str.length(); i++) {
            if (counts.containsKey(str.charAt(i))) {
                int val = counts.get(str.charAt(i));
                val += 1;
                counts.put(str.charAt(i), val);
            } else {
                counts.put(str.charAt(i), 1);
            }
        }

        boolean isOdd = (str.length() % 2 == 1);
        int numEven = 0;
        int numOdd = 0;
        for (Map.Entry<Character, Integer> item : counts.entrySet()) {
            if (item.getValue() % 2 == 0) {
                numEven += 1;
            } else {
                numOdd += 1;
            }
        }

        if (isOdd && numOdd == 1) {
            return true;
        } else if (!isOdd && numOdd == 0){
            return true;
        } else {
            return false;
        }
    }

    public static boolean isOneEditOrReplacement(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }

        if (s1.length() == s2.length()) {
            return isOneDifference(s1, s2);
        } else if (s1.length() > s2.length()) {
            return isOneEditDifference(s1, s2);
        } else {
            return isOneEditDifference(s2, s1);
        }
    }

    public static boolean isOneEditDifference(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < s1.length() && index2 < s2.length())
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2 += 1;
            } else {
                index2 += 1;
                index1 += 1;
            }
        return true;
    }

    public static boolean isOneDifference(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) return false;
                foundDifference = true;
            }
        }
        return true;
    }

    public static String compress(String s1) {
        String compressed = "";
        int amount = 0;
        for (int i = 0; i < s1.length(); i++) {
            amount++;
            if (i + 1 >= s1.length() || s1.charAt(i) != s1.charAt(i + 1)) {
                compressed += "" + s1.charAt(i) + amount;
                amount = 0;
            }
        }
        return compressed;
    }

    public static void main(String[] args) {
        if (isPermutation("fooxbar", "barzfoo")) {
            System.out.println("is permutation");
        } else {
            System.out.println("not permutation");
        }
    }
}
