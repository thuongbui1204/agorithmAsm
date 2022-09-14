public class Myqueue {
    protected Node head, tail;
    public Myqueue(){
        this.head=null;
        this.tail=null;
    }
    public boolean is_Empty(){
        return(this.head==null);
    }

    public Node dequeue() {
        if(is_Empty()) {
            return null;
        }
        Node current=this.head;
        head=head.nextNode;
        if(head==null || head.getNextNode()==null){
            tail=null;
        }
        return current;
    }
    public void enqueue(Product product){
        Node newNode=new Node(product);
        if(this.head==null){
            this.head=newNode;
        }else if(this.tail==null){
            this.head.setNextNode(newNode);
            this.tail=newNode;
        }
        else {
            tail.nextNode=newNode;
            this.tail=tail.nextNode;
        }
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public Node getTail() {
        return tail;
    }

    @Override
    public String toString(){
        String result="";
        Node current=this.head;
        while (current!=null){
            result=result+current.toString()+"\n";
            current=current.getNextNode();
        }
        return result;
    }
}
