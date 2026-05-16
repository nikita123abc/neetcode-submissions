class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;

        int[] nearestSmallerLeft = new int[n];
        int[] nearestSmallerRight = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Nearest Smaller to Left
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nearestSmallerLeft[i] = -1;
            } else {
                nearestSmallerLeft[i] = stack.peek();
            }

            stack.push(i);
        }

        // Clear stack for NSR
        stack.clear();

        // Nearest Smaller to Right
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nearestSmallerRight[i] = n;
            } else {
                nearestSmallerRight[i] = stack.peek();
            }

            stack.push(i);
        }

        int maxArea = 0;

        // Calculate area
        for (int i = 0; i < n; i++) {

            int width = nearestSmallerRight[i] - nearestSmallerLeft[i] - 1;

            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
