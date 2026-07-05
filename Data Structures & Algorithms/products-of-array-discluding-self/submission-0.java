class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        
        // Step 1: Calculate left products and store in output
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        
        // Step 2: Calculate right products on the fly and multiply
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] = output[i] * rightProduct;
            rightProduct *= nums[i];
        }
        
        return output;
        
    }
}  
