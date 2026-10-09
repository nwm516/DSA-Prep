/*
empty record at start of game.
list of strings called operations, with operations[i] being the ith operation you must apply to the record and is one of the following:
    - int x : record a new score of x
    - + : record a new score that is the sum of the previous two scores
    - D : record new score that is double of the previous score
    - C : invalidate the previous score, removing it from the record.

unlike my other submission for this problem, this one keeps a running total so as not to have to pass through again to account for it.
*/

class Solution {
    public int calPoints(String[] operations) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();

            for (String op : operations){
                if (op.equals("+")){
                    int top = stack.pop();
                    int newTop = top + stack.peek();
                    stack.push(top);
                    stack.push(newTop);
                    res += newTop;
                } else if (op.equals("D")) {
                    stack.push(2 *stack.peek());
                    res += stack.peek();
                } else if (op.equals("C")) {
                    res -= stack.pop();
                } else {
                    stack.push(Integer.parseInt(op));
                    res += stack.peek();
                }
            }
            return res;
    }
}