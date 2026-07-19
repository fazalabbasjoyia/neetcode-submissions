class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        // XOR every number in the array will cancel out identical numbers and will left with only unique number
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
        
    }
}
