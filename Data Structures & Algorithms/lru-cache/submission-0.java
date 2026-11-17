class LRUCache {

    class ListNode{
        int key;
        int value;
        ListNode prev;
        ListNode next;

        public ListNode(){}
        public ListNode(int key, int val){
            this.key = key;
            this.value = val;
        }
    }

    int capacity;
    Map<Integer, ListNode> recents = new HashMap<>();
    ListNode head;
    ListNode tail;
    int size = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!recents.containsKey(key)) return -1;
        ListNode selected = recents.get(key);
        remove(selected);
        insertToTop(selected);
        return selected.value;
    }
    
    public void put(int key, int value) {
        if(!recents.containsKey(key)){
            ListNode toAdd = new ListNode(key, value);
            insertToTop(toAdd);
            recents.put(key, toAdd);
            size++;
            if(size > this.capacity){
                recents.remove(tail.prev.key);
                remove(tail.prev);
                size--;
            }
            return;
        }
        ListNode accessed = recents.get(key);
        remove(accessed);
        accessed.value = value;
        insertToTop(accessed);
        return;
    }

    public void remove(ListNode toRemove){
        ListNode n = toRemove.next;
        ListNode p = toRemove.prev;
        n.prev = p;
        p.next = n;
    }

    public void insertToTop(ListNode recentlyUsed){
        ListNode temp = new ListNode();
        temp = head.next;
        head.next = recentlyUsed;
        recentlyUsed.prev = head;
        recentlyUsed.next = temp;
        temp.prev = recentlyUsed;
    }
}
