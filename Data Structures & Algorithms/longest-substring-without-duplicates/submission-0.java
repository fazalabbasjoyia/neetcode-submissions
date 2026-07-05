public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> charSet = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        // 'right' expands the sliding window boundary
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // Shrink the window from the left if a duplicate is found
            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(left));
                left++;
            }

            // Add the new character to the valid window
            charSet.add(currentChar);

            // Update the maximum window length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
