
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        
        // Loop up to 'n' to simulate a trailing 0-height bar
        for (int i = 0; i <= n; i++) {
            // Use 0 as the height for the dummy trailing bar
            int currentHeight = (i == n) ? 0 : heights[i];
            
            // Maintain monotonic increasing order
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                
                // If stack is empty, it means this bar was the shortest seen so far
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                
                maxArea = Math.max(maxArea, height * width);
            }
            
            stack.push(i);
        }
        
        return maxArea;
    }
}