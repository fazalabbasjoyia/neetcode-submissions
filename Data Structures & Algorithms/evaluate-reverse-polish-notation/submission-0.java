class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (String token : tokens) {
            // Check if the token is an operator
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // Pop operands in reverse order
                int b = stack.pop(); 
                int a = stack.pop();
                
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        // Java integer division inherently truncates toward zero
                        stack.push(a / b);
                        break;
                }
            } else {
                // If it's a number, convert string to int and push to stack
                stack.push(Integer.parseInt(token));
            }
        }
        
        // The last remaining item in the stack is our final answer
        return stack.pop();
    }
}