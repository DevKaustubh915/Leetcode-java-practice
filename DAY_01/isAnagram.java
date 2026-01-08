package DAY_01;

/*Leetcode 242 */

/* Given two strings s and t, return true if t is an anagram of s, and false otherwise. */

/* approach: Count character frequencies in both strings and compare them. */
/*1. first check if lengths are equal
  2. create array of length 26 because there are 26 lowercase letters
  3. iterate through both strings, incrementing count for s and decrementing for t
  4. check if all counts in the array are zero
  5. return true if all counts are zero, false otherwise */

/*time complexity: O(n) */
/*space complexity: O(1) */

class Leetcode242 {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        else{
            int[] charCount = new int[26];

            for(int i =0 ; i<s.length(); i++){
                charCount[s.charAt(i) - 'a']++;
                charCount[t.charAt(i) - 'a']--;
            }
            for(int count : charCount){
                if(count != 0){
                    return false;
                }
            }
        }
        return true;
        
    }
}
