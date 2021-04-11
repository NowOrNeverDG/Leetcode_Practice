import java.util.HashMap;
import java.util.HashSet;


public class TypicalString {

    //242-Valid Anagram
    //Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    //Input: s = "anagram", t = "nagaram"
    //Output: true
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> s_map = new HashMap<Character, Integer>();
        for (char c: s.toCharArray()) s_map.put(c , s_map.getOrDefault(c,0)+1);
        for (char c: t.toCharArray()) s_map.put(c , s_map.getOrDefault(c,0)-1);
        for (char c : s_map.keySet()) {
            if (s_map.get(c) == 0) continue;
            return false;
        }
        return true;
    }

    //409-Longest Palindrome
    //Input: s = "abccccdd"
    //Output: 7
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        int count = 0;
        for (int i = 0; i<s.length();i++) {
            if (set.contains(arr[i])) { set.remove(arr[i]); count += 2;}
            else set.add(arr[i]);
        }

        return set.isEmpty() ? count:count+1;
    }

    //205-Isomorphic Strings
    //Given two strings s and t, determine if they are isomorphic.
    //Input: s = "egg", t = "add"
    //Output: true
    public boolean isIsomorphic(String s, String t) {
        int[] arr = new int[512];
        for (int i = 0; i< arr.length; i++) arr[i] = 0;
        for (int i = 0; i < s.length(); i++) {
            System.out.println(arr[s.charAt(i)] + " / " +  arr[t.charAt(i)+256]);
            if (arr[s.charAt(i)] != arr[t.charAt(i)+256]) return false;
            arr[i] += 1;
            arr[i+256] += 1;
        }
        return true;
    }

    //696-Count Binary Substrings
    //Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
    //Input: "00110011"
    //Output: 6
    public int countBinarySubstrings(String s) {
        int[] counts = new int[s.length()];
        int t = 0;
        counts[0] = 1;
        for (int i = 1; i < s.length();i++) {
            if (s.charAt(i-1) == s.charAt(i)) counts[t]++;
            else counts[++t] = 1;
        }
        int ans = 0;
        for (int i = 1; i <= t; i++) ans += Math.min(counts[i],counts[i-1]);
        return ans;
    }

    //647-Palindromic Substrings
    //Given a string, your task is to count how many palindromic substrings in this string.
    //Input: "abc"
    //Output: 3
    int count647 = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            isPalindromic647(s,i, i);
            isPalindromic647(s, i, i+1);
        }
        return count647;
    }
    public void isPalindromic647(String str, int left, int right) {
        char[] arr = str.toCharArray();
        while (left>=0&&right<arr.length&&arr[left] == arr[right]) {
            count647 += 1;
            left--;
            right++;
        }
    }

    //9-Palindrome Number
    //Given an integer x, return true if x is palindrome integer.
    //Input: x = 121
    //Output: true
    public boolean isPalindrome(int x) {
        String x_str = String.valueOf(x);
        System.out.println(x_str.length());
        Boolean isOdd = x_str.length()%2==0 ? false:true;
        System.out.println(isOdd);
        int left = 0, right = 0;
        if (isOdd == true) {left = x_str.length()/2; right = left;}
        else {left = x_str.length()/2-1; right = x_str.length()/2;}

        return isPalindromic9(x_str,left,right);
    }
    public boolean isPalindromic9(String str, int left, int right){
        char[] arr = str.toCharArray();
        while (left>=0&&right<arr.length) {
            if (arr[left] != arr[right]) return false;
            left--;
            right++;
        }
        return true;
    }
    public boolean isPalindrome1(int x) {
        if (x < 0) return false;
        int y = x;
        int rev = 0;
        while (y != 0) {
            rev = rev*10 + x%10;
            y = y/10;
        }
        return y == x;
    }

}
