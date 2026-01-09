package DAY_01;

/* Leetcode 1 */

/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 You may assume that each input would have exactly one solution, and you may not use the same element twice.
 You can return the answer in any order. */

/* Approach: Use a HashMap to store numbers and their indices.
 Iterate through the array, calculate the complement (target - current number),
 check if the complement exists in the map, and return indices if found. */

/* Time complexity: O(nlogn) */
/* Space complexity: O(nlogn) */

import java.util.Map;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // create hashmap to store numbers and their indices
        Map<Integer, Integer> numMap = new java.util.HashMap<>();

        // iterate through the array
        for(int i=0; i<nums.length; i++){
            int remainder = target - nums[i];

            // check if the complement exists in the map
            if(numMap.containsKey(remainder)){
                return new int[] {numMap.get(remainder), i}; // return indices if found
            }
            // add the current number and its index to the map
            numMap.put(nums[i], i);
        }

        return new int[] {}; // return empty array if no solution found
    }
}
