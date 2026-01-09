package DAY_02;

/* Leetcode 49 */
/* Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 typically using all the original letters exactly once. */
 /*example: Input: strs = ["eat","tea","tan","ate","nat","bat"]
 Output: [["bat"],["nat","tan"],["ate","eat","tea"]] */

/*we know every string consists of letter between a-z
so we can create a array of size 26
then we traverse throught every string in our input array and and increment the position of each charater present in string
 */
/*if the strings are anagrams the resulted array woruld be same so we can just make that array as string and keep it in a map
as a key and in value we will create a list and store the actual string there */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {

        // edge case
        if(strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        // create a hashmap to store the anagrams
        Map<String , List> ansMap = new HashMap<>();

        // create an array to count the frequency of each character
        int[] count = new int[26];

        // traverse through each string in the input array
        for(String s :strs){

            // reset the count array
            Arrays.fill(count , 0);

            // count the frequency of each character in the string
            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }
            // create a string key from the count array
            StringBuilder sb = new StringBuilder("");
            // append the frequency of each character to the string builder
            for(int i=0; i<26; i++){
                sb.append('#'); // to avoid ambiguity we are adding a separator
                sb.append(count[i]);
            }

            // convert the string builder to string
            String key = sb.toString();

            // if the key is not present in the map, add it with an empty list
            if(!ansMap.containsKey(key)){
                ansMap.put(key , new ArrayList());
            }
            // add the original string to the list corresponding to the key
            ansMap.get(key).add(s);
        }

        return new ArrayList(ansMap.values());// return the values of the map as a list of lists
    }
}
