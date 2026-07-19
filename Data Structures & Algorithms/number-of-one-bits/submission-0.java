class Solution {
    public int hammingWeight(int n) {
        // less optimized with right shift a bit 
        // int count = 0;
        // while (n != 0) {
        //     // Check if the last bit is a 1
        //     count += (n & 1);
        //     // Logically shift right by 1 bit (fills with 0 from the left)
        //     n >>>= 1; 
        // }
        // return count;


        // 2nd is more effient as first one check for all bits and move bits shifts to the right;
        int count = 0;
        
        while (n != 0) {
            // Clears the rightmost '1' bit instantly
            n = n & (n - 1);
            count++;
        }
        
        return count;
    }
}
