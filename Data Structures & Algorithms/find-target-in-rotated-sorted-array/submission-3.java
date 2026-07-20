class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Step 1: Check if the left half is normally sorted
            if (nums[left] <= nums[mid]) {
                // Step 2: Check if the target lies within the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Narrow search to left
                } else {
                    left = mid + 1;  // Target is in the right half
                }
            } 
            // Step 3: Otherwise, the right half must be normally sorted
            else {
                // Step 4: Check if the target lies within the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // Narrow search to right
                } else {
                    right = mid - 1; // Target is in the left half
                }
            }
        }

        // Target was not found in the array
        return -1;
    }
}
