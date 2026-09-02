/*Two Stack Approach

Forward and back mapped to two stacks. Back stack holds pages we've visited (and current page) and forward stack holds pages you can go forward to. 
Visiting a new URL pushes it onto the back stack and clears the forward stack
since the movement has branched off onto a new path.
Going back means moving pages from the back stack to the forward stack, and going forward 
is the reverse.

Algorihtmic Approach:
1) Initialize two stacks - "backHistory" with homepage, and "frontHistory" as empty
2)For "visit(url)": Push the new URL onto "backHistory" and clear "frontHistory"
    - new pages invalidate forward history
3)For "back(steps)": While steps remain and "backHistory" has more than one element, pop from "backHistory" and push onto "frontHistory". Return the top of "backHistory".
4) For "forward(steps)": While steps remain and "frontHistory" is not empty, pop from "frontHistory" and push onto "backHistory". Return the top of "backHistory".

*/

public class BrowserHistory {
    private Stack<String> backHistory;
    private Stack<String> frontHistory;

    public BrowserHistory(String homepage) {
        // initializes backHistory object with the "homepage" of the browser
        backHistory = new Stack<>();
        frontHistory = new Stack<>();
        backHistory.push(homepage);
    }
    
    public void visit(String url) {
        // Visits "url" from the current page. It clears up all the forward history
        // T: O(1)
        backHistory.push(url);
        frontHistory = new Stack<>();
    }
    
    public String back(int steps) {
        /* Move "steps" back in history. If you can only return "x" steps in the history
        and "steps > x", you will return only "x" steps. Return the current "url" after moving back in history at most "steps"*/
        while (steps > 0 && backHistory.size() > 1) {
            frontHistory.push(backHistory.pop());
            steps--;
        }
        return backHistory.peek();
    }
    
    public String forward(int steps) {
        /* Move "steps" forward in history. If you can only forrward "x" steps in the history and "steps > x", you will only move forward "x" steps. Return the current "url" after forwarding history AT MOST "steps"
        */
        while (steps > 0 && !frontHistory.isEmpty()) {
            backHistory.push(frontHistory.pop());
            steps--;
        }
        return backHistory.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */