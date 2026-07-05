public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            // 1. Skip non-alphanumeric characters on the left
            if (!isAlphanumeric(leftChar)) {
                left++;
                continue; // Restart loop to check the next left character
            }

            // 2. Skip non-alphanumeric characters on the right
            if (!isAlphanumeric(rightChar)) {
                right--;
                continue; // Restart loop to check the next right character
            }

            // 3. Compare characters case-insensitively using ASCII arithmetic
            if (toLowerCase(leftChar) != toLowerCase(rightChar)) {
                return false;
            }

            // Move pointers inward if they match
            left++;
            right--;
        }

        return true;
    }

    // Helper method using raw ASCII boundaries
    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || 
               (c >= 'A' && c <= 'Z') || 
               (c >= '0' && c <= '9');
    }

    // Helper method to convert uppercase to lowercase using ASCII offset (32)
    private char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32); // Adding 32 shifts 'A' (65) to 'a' (97)
        }
        return c;
    }
}
