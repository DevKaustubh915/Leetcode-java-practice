package DAY_01;

/*Leetcode 217 */

/* Given an integer array nums, return true if any value appears at least twice in the array,
 and return false if every element is distinct. */

 /*Used hashmap to store numbers and check for duplicates
 if the number is already in the set, means it's a duplicate */
 
 /*time complexity: O(n) */
 /*space complexity: O(n) */

import java.util.HashSet;

class Leetcode217 {
    public boolean containsDuplicate(int[] nums) {

        // create hashset to store checked numbers
        HashSet<Integer> checkedNums = new HashSet<>();

        //Iterate through numbers in array
        for(int num:nums){
            // if number is already in hashset, return true
            if(checkedNums.contains(num)){
                return true;
            }
            // else add number to hashset
            checkedNums.add(num);
        }

        return false;
    }
}
