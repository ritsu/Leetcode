package net.qiguang.leetcode;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 * Given s = "hello", return "holle".
 *
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 *
 * Note:
 * The vowels does not include the letter "y".
 */
public class L345_ReverseVowelsOfAString {
    // 5 ms ~84%
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] c = s.toCharArray();
        while (true) {
            while (i < j && !isVowel(c[i])) i++;
            while (j > i && !isVowel(c[j])) j--;
            if (i > j) break;
            c[i] = c[j];
            c[j] = s.charAt(i);
            i++;
            j--;
        }
        return new String(c);
    }
    private boolean isVowel(char c) {
        if (c == 'a' || c == 'A') return true;
        if (c == 'e' || c == 'E') return true;
        if (c == 'i' || c == 'I') return true;
        if (c == 'o' || c == 'O') return true;
        if (c == 'u' || c == 'U') return true;
        return false;
    }
    public static void main(String[] args) {
        L345_ReverseVowelsOfAString lc = new L345_ReverseVowelsOfAString();
        String[] words = {"hello", "leetcode"};
        for (String word : words)
            System.out.printf("%s %s\n", word, lc.reverseVowels(word));
    }
}
