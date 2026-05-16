class StockSpanner {
     private List<Integer> prices;
    private Stack<Integer> stack;

    public StockSpanner() {
        prices = new ArrayList<>();
        stack = new Stack<>();
    }

    public int next(int price) {

        prices.add(price);

        int index = prices.size() - 1;

        while (!stack.isEmpty() &&
               prices.get(stack.peek()) <= price) {
            stack.pop();
        }

        int span;

        if (stack.isEmpty()) {
            span = index + 1;
        } else {
            span = index - stack.peek();
        }

        stack.push(index);

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */