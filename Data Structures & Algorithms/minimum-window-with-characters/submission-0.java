class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Step 1: Map the frequency requirements of string t
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        // Map to track characters in our current sliding window
        Map<Character, Integer> windowMap = new HashMap<>();
        
        // 'required' is the number of unique characters in t that need to match frequency
        int required = targetMap.size();
        // 'formed' tracks how many unique characters currently meet the required target frequency
        int formed = 0;

        int left = 0;
        
        // Track the best window dimensions: {window length, left index, right index}
        int[] ans = {-1, 0, 0};

        // Step 2: Expand the window using the right pointer
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // If the current character's frequency matches its target frequency in t, increment 'formed'
            if (targetMap.containsKey(c) && windowMap.get(c).equals(targetMap.get(c))) {
                formed++;
            }

            // Step 3: Shrink the window from the left as long as it remains valid
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Save the smallest window found so far
                int windowLength = right - left + 1;
                if (ans[0] == -1 || windowLength < ans[0]) {
                    ans[0] = windowLength;
                    ans[1] = left;
                    ans[2] = right;
                }

                // The character at the 'left' pointer is about to slide out of the window
                windowMap.put(c, windowMap.get(c) - 1);
                
                // If losing this character breaks the target frequency requirement, decrement 'formed'
                if (targetMap.containsKey(c) && windowMap.get(c) < targetMap.get(c)) {
                    formed--;
                }

                // Move left pointer forward to contract the window
                left++;
            }
        }

        // Return the smallest substring, or empty string if no valid window was found
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
