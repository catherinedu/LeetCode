// Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

// Example 1:

// Input: [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.

public int maxProduct(int[] nums) {
        if(nums.length  == 0) return 0; 
        int curmax = nums[0];
        int curmin = nums[0];
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            int nextmax = curmax*nums[i];
            int nextmin = curmin*nums[i];
            curmax = Math.max(Math.max(nextmax, nextmin), nums[i]);
            curmin = Math.min(Math.min(nextmax, nextmin), nums[i]);
            result = Math.max(result, curmax);
        }
        
        return result;
    }