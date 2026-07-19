class Solution {
    public double myPow(double x, int n) {
        // double result = 1.0;
        // if (n > 0) {
        //     while (n > 0) {
        //         result *= x;
        //         n--;
        //     }

        // } else {
        //     while (n < 0) {
        //         result /= x;
        //         n++;
        //     }
        // }

        //     return result;


//most useful approach for larger n value
// Use long to prevent integer overflow when handling Integer.MIN_VALUE
        long N = n;
        
        // If the exponent is negative, invert x and make N positive
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double result = 1.0;
        double currentProduct = x;
        
        // Binary exponentiation loop
        while (N > 0) {
            // If N is odd, multiply the current product into the result
            if (N % 2 == 1) {
                result *= currentProduct;
            }
            // Square the base and halve the exponent
            currentProduct *= currentProduct;
            N /= 2;
        }
        
        return result;

        }
    }
