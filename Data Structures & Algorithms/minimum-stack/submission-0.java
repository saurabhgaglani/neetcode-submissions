class MinStack {
    
    public class Node{
        int data;
        int min;
        Node next;

        public Node(int data, int min){
            this.data = data;
            this.min = min;
        }
    }
    int size;
    Node top;
    public MinStack() {
        size = 0;
        top = null;
    }
    
    public void push(int val) {
        if(size == 0){
            top = new Node(val, val);
            size++;
            return;
        }
        int currMin = Math.min(val, top.min);
        Node tempNode = new Node(val, currMin);
        tempNode.next = top;
        top = tempNode;
        size++;
        return;
    }
    
    public void pop() {
        top = top.next;
        size--;
    }
    
    public int top() {
        return top.data;
    }
    
    public int getMin() {
        return top.min;
    }
}
