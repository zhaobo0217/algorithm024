public LruCache{

    //基础思想使用双向链表，将最近使用的节点移动到队列的头部，移除超过capacity的队尾节点，为了加快查询速度，需要一个map记录节点信息
    private int capacity;
    private int size = 0;
    private Node header;
    private Node tail;
    private Map<Integer, Node>  cacheMap = new HashMap<>();

    public LruCache(int capacity) {
        this.capacity = capacity;
        header = new Node();
        tail = new Node();
        header.next = tail;
        tail.pre = header;
    }
    
    public int get(int key) {
        Node node = cacheMap.get(key);
        if(node != null){
            removeNode(node);
            addToHeader(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = cacheMap.get(key);
        if(node == null){
            node = new Node(key, value);
            addToHeader(node);
            ++size;
            cacheMap.put(key, node);
            if(size > capacity){
                Node tailNode = removeTail();
                if(tailNode != null){
                    --size;
                    cacheMap.remove(tailNode.key);
                }
            }
        }else{
            node.value = value;
            removeNode(node);
            addToHeader(node);
        }
    }

    public void addToHeader(Node node){
        node.next = header.next;
        header.next.pre = node;
        header.next = node;
        node.pre = header;
    }

    public Node removeNode(Node node){
        if(node == tail || node == header) return null;
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return node;
    }

    public Node removeTail(){
        return removeNode(tail.pre);
    }

    class Node{
        int key;
        int value;
        Node pre;
        Node next;

        Node(){}

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
