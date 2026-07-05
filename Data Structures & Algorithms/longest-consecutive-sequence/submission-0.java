class Solution {
    public int longestConsecutive(int[] nums) {
       // Handle empty array edge case
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Step 1: Add all numbers to a HashSet
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Step 2: Iterate through the set to find sequence starters
        for (int num : numSet) {
            // Check if 'num' is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Step 3: Count how long this consecutive sequence goes
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Keep track of the maximum length found
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
        
    }
}
