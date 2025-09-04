class Solution {
    private class NodeStack {
        private class Node {
            char value;
            Node next;

            Node(char value) {
                this.value = value;
            }
        }

        private Node top;

        public boolean isEmpty() {
            return top == null;
        }

        public void push(char c) {
            Node newNode = new Node(c);
            newNode.next = top;
            top = newNode;
        }

        public char pop() {
            char value = top.value;
            top = top.next;
            return value;
        }
    }

    public boolean isValid(String s) {
        NodeStack stack = new NodeStack();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char topChar = stack.pop();
                
                if ((c == ')' && topChar != '(') || 
                    (c == ']' && topChar != '[') || 
                    (c == '}' && topChar != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}