public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // for srited arrays we can use this approach of two pointer but for any unsorted array we can map and complement appraoch
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            if (currentSum == target) {
                // Return 1-indexed positions
                return new int[]{left + 1, right + 1};
            } else if (currentSum < target) {
                // Sum is too small, move left pointer to a larger number
                left++;
            } else {
                // Sum is too big, move right pointer to a smaller number
                right--;
            }
        }

        // Fallback return (though the problem guarantees a solution exists)
        return new int[]{-1, -1};
    }
}
