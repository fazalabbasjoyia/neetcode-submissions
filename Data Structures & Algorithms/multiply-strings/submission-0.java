class Solution {
    public String multiply(String num1, String num2) {
        // Edge case: if either number is "0", the product is "0"
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int m = num1.length();
        int n = num2.length();
        // The maximum possible length of the product of two numbers 
        // of lengths m and n is m + n
        int[] result = new int[m + n];
        
        // Loop backwards through both strings
        for (int i = m - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0'; // Convert char to int
            
            for (int j = n - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';
                
                // Multiply the digits
                int product = d1 * d2;
                
                // Determine the positions in the result array
                int p1 = i + j;     // Position for the carryover
                int p2 = i + j + 1; // Position for the current digit
                
                // Add the product to whatever is already sitting at position p2
                int sum = product + result[p2];
                
                // Store the units digit at p2, and add the tens digit (carry) to p1
                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }
        
        // Build the final string, skipping any leading zero at index 0
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            // Skip the very first element if it's a 0 (e.g., 3 * 4 = 12, max size array is 2, no leading zero)
            if (sb.length() == 0 && num == 0) {
                continue;
            }
            sb.append(num);
        }
        
        return sb.toString();
        
    }
}
