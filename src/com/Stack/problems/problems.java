package src.com.Stack.problems;

import java.util.Stack;

public class problems {


    //before and after $ should be palindrome
    public static boolean isInLanguage(String input) {
        Stack<Character> stack = new Stack<>();
        int dollarIndex = -1;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '$') {
                dollarIndex = i;
                break;
            }
            stack.push(ch);
        }
        for (int i = dollarIndex + 1; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    //insert and undo
    public void insertAndUndo(Stack<Character> stack, Character c) {
        if (c != '\b') {
            stack.push(c);
        } else {
            if (stack.isEmpty()) {
                stack.pop();
            }
        }
    }


    //Checking for Balanced Braces
    public boolean balanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (c == '(')
                stack.push(')');
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    //2d maze start to finish using Stack (DFS)
    public boolean solveMaze(int[][] maze, Point start, Point goal) {
        Stack<Point> stack = new Stack<>();
        stack.push(start);
        int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!stack.isEmpty()) {
            Point current = stack.pop();
            if (current.equals(goal)) {
                return true;
            }
            // Mark the current cell as visited
            maze[current.x][current.y] = 2;
            for (int[] direction : DIRECTIONS) {
                Point neighbor = new Point(current.x + direction[0], current.y + direction[1]);
                if (isInBounds(neighbor, maze) && maze[neighbor.x][neighbor.y] == 0) {
                    stack.push(neighbor);
                }
            }
        }
        return false;
    }

    private boolean isInBounds(Point p, int[][] maze) {
        return p.x >= 0 && p.x < maze.length && p.y >= 0 && p.y < maze[0].length;
    }

    //infix to postfix
    public String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result.append(stack.pop());
        }

        return result.toString();
    }

    private int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    //convert number to binary
    public  String convertToBinary(int number) {
        if (number == 0) return "0";
        Stack<Integer> stack = new Stack<>();
        while (number > 0) {
            stack.push(number % 2);
            number /= 2;
        }
        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }

    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {
            int val = stack.pop();
            if (val == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}

//min stack
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
