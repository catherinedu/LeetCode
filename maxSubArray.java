//  Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

// Example:

// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.


 public int maxSubArray(int[] nums) {
        int maxsum = 0;
        int minsum = 0;
        int min = 0;
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            maxsum += nums[i];
            minsum = Math.min(minsum, min);
            result = Math.max(result, maxsum - minsum);
            min += nums[i];
        }
        return result;
}