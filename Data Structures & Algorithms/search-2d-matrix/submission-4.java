class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int totalRows = matrix.length;
        int totalCols = matrix[0].length;

        // Treat the 2D matrix as a flat 1D array from index 0 to (totalRows * totalCols - 1)
        int left = 0;
        int right = (totalRows * totalCols) - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Map the 1D 'mid' index back to 2D matrix coordinates
            int midValue = matrix[mid / totalCols][mid % totalCols];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }

        return false;
    }
}
