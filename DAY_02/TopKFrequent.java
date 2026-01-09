package DAY_02;

/* Leetcode 347 */
/* Given an integer array nums and an integer k, return the k most frequent elements. You   
    may return the answer in any order. */

/*example: Input: nums = [1,1,1,2,2,3], k = 2
 Output: [1,2] */

 /*Approach:
 1. Count the frequency of each element using a HashMap.
    2. Use a Min-Heap (Priority Queue) to keep track of the top k frequent elements.
    3. Extract the elements from the heap to form the result array. */  

/*Time complexity: O(N log k) */
/*Space complexity: O(N) */



import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if(nums.length == k){
            return nums;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int n:nums){
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);

        }
        // create a min-heap using priority queue
        Queue <Integer> heap = new PriorityQueue<>(
            (n1, n2) -> countMap.get(n1) - countMap.get(n2) // min-heap based on frequency
        );
        for(int n: countMap.keySet()){
            heap.add(n);
            if(heap.size() > k){ // maintain the size of heap to k
                heap.poll();
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = heap.poll();
        }
        return result;
    }
}
